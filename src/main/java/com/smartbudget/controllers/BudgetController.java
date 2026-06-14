package com.smartbudget.controllers;

import java.time.LocalDate;
import java.util.List;

import com.smartbudget.MainApplication;
import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.models.Budget;
import com.smartbudget.models.User;
import com.smartbudget.services.BudgetService;
import com.smartbudget.session.UserSession;
import com.smartbudget.utils.AlertUtil;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Controller for Budget configuration.
 * Maps monthly budget inputs, displays set budgets, and queries status calculations.
 * Demonstrates MVC structure and simple business rule routing.
 */
public class BudgetController {

    // Inputs
    @FXML private ComboBox<Integer> yearComboBox;
    @FXML private ComboBox<Integer> monthComboBox;
    @FXML private TextField budgetAmountField;

    // Table
    @FXML private TableView<Budget> budgetTableView;
    @FXML private TableColumn<Budget, Integer> budgetIdCol;
    @FXML private TableColumn<Budget, Integer> budgetYearCol;
    @FXML private TableColumn<Budget, Integer> budgetMonthCol;
    @FXML private TableColumn<Budget, Double> budgetAmountCol;

    // Status Area
    @FXML private Label statusBudgetLabel;
    @FXML private Label statusSpentLabel;
    @FXML private Label statusRemainingLabel;

    private BudgetService budgetService;
    private UserSession userSession;
    private User currentUser;

    @FXML
    public void initialize() {
        budgetService = new BudgetService();
        userSession = UserSession.getInstance();

        if (!userSession.isLoggedIn()) {
            MainApplication.showLoginScreen();
            return;
        }

        currentUser = userSession.getCurrentUser();

        // 1. Configure ComboBox selections
        yearComboBox.setItems(FXCollections.observableArrayList(2025, 2026, 2027, 2028, 2029, 2030));
        monthComboBox.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        
        // Default to current year and month
        LocalDate today = LocalDate.now();
        yearComboBox.setValue(today.getYear());
        monthComboBox.setValue(today.getMonthValue());

        // 2. Configure table bindings
        budgetIdCol.setCellValueFactory(new PropertyValueFactory<>("budgetId"));
        budgetYearCol.setCellValueFactory(new PropertyValueFactory<>("year"));
        budgetMonthCol.setCellValueFactory(new PropertyValueFactory<>("month"));
        budgetAmountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));

        // 3. Load budget records from DB
        loadBudgets();
        
        // 4. Precheck current month status
        updateStatusDisplay(today.getMonthValue(), today.getYear());
    }

    /**
     * Re-query DB and populate TableView with set budgets.
     */
    private void loadBudgets() {
        try {
            List<Budget> budgets = budgetService.getBudgetsByUser(currentUser.getUserId());
            budgetTableView.setItems(FXCollections.observableArrayList(budgets));
        } catch (DatabaseException e) {
            AlertUtil.showError("Database Error", "Failed to retrieve budgets: " + e.getMessage());
        }
    }

    /**
     * Save/Create a new monthly budget.
     */
    @FXML
    private void onSaveBudgetClick() {
        try {
            Integer year = yearComboBox.getValue();
            Integer month = monthComboBox.getValue();
            String amountStr = budgetAmountField.getText().trim();

            if (year == null) throw new ValidationException("Please select a target Year.");
            if (month == null) throw new ValidationException("Please select a target Month.");
            if (amountStr.isEmpty()) throw new ValidationException("Budget limit amount cannot be empty.");

            double amount;
            try {
                amount = Double.parseDouble(amountStr);
            } catch (NumberFormatException e) {
                throw new ValidationException("Please enter a valid numeric value for the budget amount.");
            }

            // Save to DB
            budgetService.setBudget(currentUser, month, year, amount);
            
            AlertUtil.showSuccess("Success", "Budget plan saved successfully!");
            
            budgetAmountField.clear();
            loadBudgets();
            updateStatusDisplay(month, year);
            
        } catch (ValidationException e) {
            AlertUtil.showWarning("Validation Error", e.getMessage());
        } catch (DatabaseException e) {
            AlertUtil.showError("Database Error", e.getMessage());
        }
    }

    /**
     * Query budget spent calculations for selected ComboBox dates.
     */
    @FXML
    private void onCheckStatusClick() {
        Integer month = monthComboBox.getValue();
        Integer year = yearComboBox.getValue();

        if (month == null || year == null) {
            AlertUtil.showWarning("Period Required", "Please select both a Month and a Year to check budget status.");
            return;
        }

        updateStatusDisplay(month, year);
    }

    /**
     * Delete selected budget.
     */
    @FXML
    private void onDeleteBudgetClick() {
        Budget selected = budgetTableView.getSelectionModel().getSelectedItem();
        if (selected == null) {
            AlertUtil.showWarning("Selection Required", "Please select a budget plan to delete from the list.");
            return;
        }

        boolean confirm = AlertUtil.showConfirmation("Confirm Deletion", "Are you sure you want to permanently delete this budget plan?");
        if (confirm) {
            try {
                budgetService.deleteBudget(selected.getBudgetId()); // delete standard ID
                AlertUtil.showSuccess("Success", "Budget plan deleted successfully.");
                loadBudgets();
                
                // Clear query displays
                statusBudgetLabel.setText("0.00 ETB");
                statusSpentLabel.setText("0.00 ETB");
                statusRemainingLabel.setText("0.00 ETB");
                statusRemainingLabel.setStyle("-fx-text-fill: black;");
            } catch (DatabaseException e) {
                AlertUtil.showError("Database Error", "Failed to delete budget plan: " + e.getMessage());
            }
        }
    }

    /**
     * Update the query labels showing Total Budget, Spent, and Remaining amounts.
     */
    private void updateStatusDisplay(int month, int year) {
        try {
            int userId = currentUser.getUserId();
            Budget budget = budgetService.getBudgetForPeriod(userId, month, year);
            
            if (budget == null) {
                statusBudgetLabel.setText("0.00 ETB (Not Set)");
                double spent = budgetService.getSpentForPeriod(userId, month, year);
                statusSpentLabel.setText(String.format("%.2f ETB", spent));
                statusRemainingLabel.setText(String.format("%.2f ETB", -spent));
                statusRemainingLabel.setStyle("-fx-text-fill: #e74c3c;"); // Red (no budget)
                return;
            }

            double limit = budget.getAmount();
            double spent = budgetService.getSpentForPeriod(userId, month, year);
            double remaining = limit - spent;

            statusBudgetLabel.setText(String.format("%.2f ETB", limit));
            statusSpentLabel.setText(String.format("%.2f ETB", spent));
            statusRemainingLabel.setText(String.format("%.2f ETB", remaining));

            if (remaining < 0) {
                statusRemainingLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-weight: bold;"); // Red (Overbudget!)
            } else {
                statusRemainingLabel.setStyle("-fx-text-fill: #27ae60; -fx-font-weight: bold;"); // Green (Under budget!)
            }

        } catch (DatabaseException e) {
            System.err.println("Error updating budget status query display: " + e.getMessage());
        }
    }

    @FXML
    private void onBackClick() {
        MainApplication.showDashboardScreen();
    }
}
