package com.smartbudget.controllers;

import java.time.LocalDate;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;

import com.smartbudget.MainApplication;
import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.models.Category;
import com.smartbudget.models.Expense;
import com.smartbudget.models.Income;
import com.smartbudget.models.User;
import com.smartbudget.services.ExpenseService;
import com.smartbudget.services.IncomeService;
import com.smartbudget.services.impl.ExpenseServiceImpl;
import com.smartbudget.services.impl.IncomeServiceImpl;
import com.smartbudget.session.UserSession;
import com.smartbudget.utils.AlertUtil;

/**
 * Controller for the transactions screen (Expenses and Income).
 * Coordinates user action events with underlying services.
 * Demonstrates clean MVC binding, encapsulation, and JavaFX event handlers.
 */
public class ExpenseController {

    // Expense Tab Components
    @FXML private ComboBox<Category> expenseCategoryComboBox;
    @FXML private TextField expenseAmountField;
    @FXML private TextField expenseDescriptionField;
    @FXML private DatePicker expenseDatePicker;
    
    @FXML private TableView<Expense> expenseTableView;
    @FXML private TableColumn<Expense, Integer> expenseIdCol;
    @FXML private TableColumn<Expense, String> expenseCategoryCol;
    @FXML private TableColumn<Expense, Double> expenseAmountCol;
    @FXML private TableColumn<Expense, String> expenseDescriptionCol;
    @FXML private TableColumn<Expense, LocalDate> expenseDateCol;

    // Income Tab Components
    @FXML private TextField incomeAmountField;
    @FXML private TextField incomeDescriptionField;
    @FXML private DatePicker incomeDatePicker;

    @FXML private TableView<Income> incomeTableView;
    @FXML private TableColumn<Income, Integer> incomeIdCol;
    @FXML private TableColumn<Income, Double> incomeAmountCol;
    @FXML private TableColumn<Income, String> incomeDescriptionCol;
    @FXML private TableColumn<Income, LocalDate> incomeDateCol;

    // Services & Session Management
    private ExpenseService expenseService;
    private IncomeService incomeService;
    private UserSession userSession;
    private User currentUser;

    @FXML
    public void initialize() {
        expenseService = new ExpenseServiceImpl();
        incomeService = new IncomeServiceImpl();
        userSession = UserSession.getInstance();

        // Safety redirect if session isn't loaded
        if (!userSession.isLoggedIn()) {
            MainApplication.showLoginScreen();
            return;
        }

        currentUser = userSession.getCurrentUser();

        // 1. Configure cell factories and binding for columns
        setupExpenseTableColumns();
        setupIncomeTableColumns();

        // 2. Load Category ComboBox
        loadCategories();

        // 3. Load database tables with records
        refreshTables();

        // 4. Set default date picker values to today
        expenseDatePicker.setValue(LocalDate.now());
        incomeDatePicker.setValue(LocalDate.now());
    }

    /**
     * Map JavaFX columns to Expense model properties.
     */
    private void setupExpenseTableColumns() {
        expenseIdCol.setCellValueFactory(new PropertyValueFactory<>("expenseId"));
        expenseAmountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        expenseDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        expenseDateCol.setCellValueFactory(new PropertyValueFactory<>("expenseDate"));
        
        // Dynamic cell rendering: Category is aggregated, so map its nested name property
        expenseCategoryCol.setCellValueFactory(cellData -> {
            Expense exp = cellData.getValue();
            if (exp.getCategory() != null) {
                return new SimpleStringProperty(exp.getCategory().getCategoryName());
            }
            return new SimpleStringProperty("Uncategorized");
        });
    }

    /**
     * Map JavaFX columns to Income model properties.
     */
    private void setupIncomeTableColumns() {
        incomeIdCol.setCellValueFactory(new PropertyValueFactory<>("incomeId"));
        incomeAmountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        incomeDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        incomeDateCol.setCellValueFactory(new PropertyValueFactory<>("incomeDate"));
    }

    /**
     * Fetch all expense categories and display them inside the Combo Box.
     */
    private void loadCategories() {
        try {
            List<Category> categories = expenseService.getCategories();
            expenseCategoryComboBox.setItems(FXCollections.observableArrayList(categories));
            
            // Format how categories are shown visually inside the ComboBox
            expenseCategoryComboBox.setConverter(new StringConverter<Category>() {
                @Override
                public String toString(Category category) {
                    return category == null ? "" : category.getCategoryName();
                }

                @Override
                public Category fromString(String string) {
                    return null; // Not needed for selection
                }
            });
        } catch (DatabaseException e) {
            AlertUtil.showError("Database Error", "Failed to retrieve categories: " + e.getMessage());
        }
    }

    /**
     * Re-query the database to load active records for the tables.
     */
    private void refreshTables() {
        try {
            // Load Expenses
            List<Expense> expenses = expenseService.getExpensesByUser(currentUser.getUserId());
            expenseTableView.setItems(FXCollections.observableArrayList(expenses));

            // Load Income
            List<Income> incomes = incomeService.getIncomesByUser(currentUser.getUserId());
            incomeTableView.setItems(FXCollections.observableArrayList(incomes));
        } catch (DatabaseException e) {
            AlertUtil.showError("Database Error", "Failed to populate record tables: " + e.getMessage());
        }
    }

    /**
     * Handle saving a new Expense.
     */
    @FXML
    private void onSaveExpenseClick() {
        try {
            Category category = expenseCategoryComboBox.getValue();
            String amountStr = expenseAmountField.getText().trim();
            String description = expenseDescriptionField.getText().trim();
            LocalDate date = expenseDatePicker.getValue();

            if (amountStr.isEmpty()) {
                throw new ValidationException("Expense amount cannot be empty.");
            }

            double amount;
            try {
                amount = Double.parseDouble(amountStr);
            } catch (NumberFormatException e) {
                throw new ValidationException("Please enter a valid numeric value for the expense amount.");
            }

            // Call Service Layer with transaction values
            expenseService.addExpense(currentUser, category, amount, description, date);
            
            AlertUtil.showSuccess("Success", "Expense successfully recorded!");
            
            // Clear inputs and refresh TableView
            clearExpenseInputs();
            refreshTables();
            
        } catch (ValidationException e) {
            AlertUtil.showWarning("Validation Error", e.getMessage());
        } catch (DatabaseException e) {
            AlertUtil.showError("Database Error", e.getMessage());
        }
    }

    /**
     * Handle deleting selected Expense.
     */
    @FXML
    private void onDeleteExpenseClick() {
        Expense selected = expenseTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            AlertUtil.showWarning("Selection Required", "Please select an expense entry to delete.");
            return;
        }

        boolean confirm = AlertUtil.showConfirmation("Confirm Deletion", "Are you sure you want to permanently delete this expense?");
        if (confirm) {
            try {
                expenseService.deleteExpense(selected.getExpenseId());
                AlertUtil.showSuccess("Success", "Expense deleted successfully.");
                refreshTables();
            } catch (DatabaseException e) {
                AlertUtil.showError("Database Error", "Failed to delete expense entry: " + e.getMessage());
            }
        }
    }

    /**
     * Handle saving a new Income record.
     */
    @FXML
    private void onSaveIncomeClick() {
        try {
            String amountStr = incomeAmountField.getText().trim();
            String description = incomeDescriptionField.getText().trim();
            LocalDate date = incomeDatePicker.getValue();

            if (amountStr.isEmpty()) {
                throw new ValidationException("Income amount cannot be empty.");
            }

            double amount;
            try {
                amount = Double.parseDouble(amountStr);
            } catch (NumberFormatException e) {
                throw new ValidationException("Please enter a valid numeric value for the income amount.");
            }

            // Call Service Layer
            incomeService.addIncome(currentUser, amount, description, date);
            
            AlertUtil.showSuccess("Success", "Income entry successfully recorded!");
            
            // Clear and reload
            clearIncomeInputs();
            refreshTables();
            
        } catch (ValidationException e) {
            AlertUtil.showWarning("Validation Error", e.getMessage());
        } catch (DatabaseException e) {
            AlertUtil.showError("Database Error", e.getMessage());
        }
    }

    /**
     * Handle deleting selected Income entry.
     */
    @FXML
    private void onDeleteIncomeClick() {
        Income selected = incomeTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            AlertUtil.showWarning("Selection Required", "Please select an income entry to delete.");
            return;
        }

        boolean confirm = AlertUtil.showConfirmation("Confirm Deletion", "Are you sure you want to permanently delete this income entry?");
        if (confirm) {
            try {
                incomeService.deleteIncome(selected.getIncomeId());
                AlertUtil.showSuccess("Success", "Income entry deleted successfully.");
                refreshTables();
            } catch (DatabaseException e) {
                AlertUtil.showError("Database Error", "Failed to delete income entry: " + e.getMessage());
            }
        }
    }

    private void clearExpenseInputs() {
        expenseCategoryComboBox.setValue(null);
        expenseAmountField.clear();
        expenseDescriptionField.clear();
        expenseDatePicker.setValue(LocalDate.now());
    }

    private void clearIncomeInputs() {
        incomeAmountField.clear();
        incomeDescriptionField.clear();
        incomeDatePicker.setValue(LocalDate.now());
    }

    @FXML
    private void onBackClick() {
        MainApplication.showDashboardScreen();
    }
}
