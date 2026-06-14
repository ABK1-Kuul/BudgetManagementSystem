# ExpenseController.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.controllers`  
**Component Type:** `Class`  
**Description:** UI controller handling the expense management grid, managing user interactions for creating, filtering, and removing expense entries.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private ExpenseService expenseService;
private IncomeService incomeService;
private UserSession userSession;
private User currentUser;
```

### Declared Methods & Constructors (Behaviors)
```java
public void initialize();
private void setupExpenseTableColumns();
private void setupIncomeTableColumns();
private void loadCategories();
public String toString(Category category);
public Category fromString(String string);
private void refreshTables();
private void onSaveExpenseClick();
private void onDeleteExpenseClick();
private void onSaveIncomeClick();
private void onDeleteIncomeClick();
private void clearExpenseInputs();
private void clearIncomeInputs();
private void onBackClick();
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `ExpenseController.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.controllers;` | Declares the package namespace `com.smartbudget.controllers` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import java.time.LocalDate;` | Imports `java.time.LocalDate` to make its classes and methods accessible within this file. |
| 4 | `import java.util.List;` | Imports `java.util.List` to make its classes and methods accessible within this file. |
| 5 | *Spacer* | Blank line used as a visual separator for code readability. |
| 6 | `import javafx.beans.property.SimpleStringProperty;` | Imports `javafx.beans.property.SimpleStringProperty` to make its classes and methods accessible within this file. |
| 7 | `import javafx.collections.FXCollections;` | Imports `javafx.collections.FXCollections` to make its classes and methods accessible within this file. |
| 8 | `import javafx.collections.ObservableList;` | Imports `javafx.collections.ObservableList` to make its classes and methods accessible within this file. |
| 9 | `import javafx.fxml.FXML;` | Imports `javafx.fxml.FXML` to make its classes and methods accessible within this file. |
| 10 | `import javafx.scene.control.*;` | Imports `javafx.scene.control.*` to make its classes and methods accessible within this file. |
| 11 | `import javafx.scene.control.cell.PropertyValueFactory;` | Imports `javafx.scene.control.cell.PropertyValueFactory` to make its classes and methods accessible within this file. |
| 12 | `import javafx.util.StringConverter;` | Imports `javafx.util.StringConverter` to make its classes and methods accessible within this file. |
| 13 | *Spacer* | Blank line used as a visual separator for code readability. |
| 14 | `import com.smartbudget.MainApplication;` | Imports `com.smartbudget.MainApplication` to make its classes and methods accessible within this file. |
| 15 | `import com.smartbudget.exceptions.DatabaseException;` | Imports `com.smartbudget.exceptions.DatabaseException` to make its classes and methods accessible within this file. |
| 16 | `import com.smartbudget.exceptions.ValidationException;` | Imports `com.smartbudget.exceptions.ValidationException` to make its classes and methods accessible within this file. |
| 17 | `import com.smartbudget.models.Category;` | Imports `com.smartbudget.models.Category` to make its classes and methods accessible within this file. |
| 18 | `import com.smartbudget.models.Expense;` | Imports `com.smartbudget.models.Expense` to make its classes and methods accessible within this file. |
| 19 | `import com.smartbudget.models.Income;` | Imports `com.smartbudget.models.Income` to make its classes and methods accessible within this file. |
| 20 | `import com.smartbudget.models.User;` | Imports `com.smartbudget.models.User` to make its classes and methods accessible within this file. |
| 21 | `import com.smartbudget.services.ExpenseService;` | Imports `com.smartbudget.services.ExpenseService` to make its classes and methods accessible within this file. |
| 22 | `import com.smartbudget.services.IncomeService;` | Imports `com.smartbudget.services.IncomeService` to make its classes and methods accessible within this file. |
| 23 | `import com.smartbudget.session.UserSession;` | Imports `com.smartbudget.session.UserSession` to make its classes and methods accessible within this file. |
| 24 | `import com.smartbudget.utils.AlertUtil;` | Imports `com.smartbudget.utils.AlertUtil` to make its classes and methods accessible within this file. |
| 25 | *Spacer* | Blank line used as a visual separator for code readability. |
| 26 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 27 | `* Controller for the transactions screen (Expenses and Income).` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 28 | `* Coordinates user action events with underlying services.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 29 | `* Demonstrates clean MVC binding, encapsulation, and JavaFX event handlers.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 30 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 31 | `public class ExpenseController {` | Declares the public class `ExpenseController` as a main architectural component of the module. |
| 32 | *Spacer* | Blank line used as a visual separator for code readability. |
| 33 | `// Expense Tab Components` | Single-line comment explaining: "Expense Tab Components" |
| 34 | `@FXML private ComboBox<Category> expenseCategoryComboBox;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 35 | `@FXML private TextField expenseAmountField;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 36 | `@FXML private TextField expenseDescriptionField;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 37 | `@FXML private DatePicker expenseDatePicker;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 38 | *Spacer* | Blank line used as a visual separator for code readability. |
| 39 | `@FXML private TableView<Expense> expenseTableView;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 40 | `@FXML private TableColumn<Expense, Integer> expenseIdCol;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 41 | `@FXML private TableColumn<Expense, String> expenseCategoryCol;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 42 | `@FXML private TableColumn<Expense, Double> expenseAmountCol;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 43 | `@FXML private TableColumn<Expense, String> expenseDescriptionCol;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 44 | `@FXML private TableColumn<Expense, LocalDate> expenseDateCol;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 45 | *Spacer* | Blank line used as a visual separator for code readability. |
| 46 | `// Income Tab Components` | Single-line comment explaining: "Income Tab Components" |
| 47 | `@FXML private TextField incomeAmountField;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 48 | `@FXML private TextField incomeDescriptionField;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 49 | `@FXML private DatePicker incomeDatePicker;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 50 | *Spacer* | Blank line used as a visual separator for code readability. |
| 51 | `@FXML private TableView<Income> incomeTableView;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 52 | `@FXML private TableColumn<Income, Integer> incomeIdCol;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 53 | `@FXML private TableColumn<Income, Double> incomeAmountCol;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 54 | `@FXML private TableColumn<Income, String> incomeDescriptionCol;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 55 | `@FXML private TableColumn<Income, LocalDate> incomeDateCol;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 56 | *Spacer* | Blank line used as a visual separator for code readability. |
| 57 | `// Services & Session Management` | Single-line comment explaining: "Services & Session Management" |
| 58 | `private ExpenseService expenseService;` | Declares a private instance field `expenseService` of type `ExpenseService` to maintain state with strict encapsulation. |
| 59 | `private IncomeService incomeService;` | Declares a private instance field `incomeService` of type `IncomeService` to maintain state with strict encapsulation. |
| 60 | `private UserSession userSession;` | Declares a private instance field `userSession` of type `UserSession` to maintain state with strict encapsulation. |
| 61 | `private User currentUser;` | Declares a private instance field `currentUser` of type `User` to maintain state with strict encapsulation. |
| 62 | *Spacer* | Blank line used as a visual separator for code readability. |
| 63 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 64 | `public void initialize() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 65 | `expenseService = new ExpenseService();` | Assigns or computes a value for the variable/field `expenseService`. |
| 66 | `incomeService = new IncomeService();` | Assigns or computes a value for the variable/field `incomeService`. |
| 67 | `userSession = UserSession.getInstance();` | Assigns or computes a value for the variable/field `userSession`. |
| 68 | *Spacer* | Blank line used as a visual separator for code readability. |
| 69 | `// Safety redirect if session isn't loaded` | Single-line comment explaining: "Safety redirect if session isn't loaded" |
| 70 | `if (!userSession.isLoggedIn()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 71 | `MainApplication.showLoginScreen();` | Calls the method `MainApplication.showLoginScreen` to execute its corresponding logic. |
| 72 | `return;` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 73 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 74 | *Spacer* | Blank line used as a visual separator for code readability. |
| 75 | `currentUser = userSession.getCurrentUser();` | Assigns or computes a value for the variable/field `currentUser`. |
| 76 | *Spacer* | Blank line used as a visual separator for code readability. |
| 77 | `// 1. Configure cell factories and binding for columns` | Single-line comment explaining: "1. Configure cell factories and binding for columns" |
| 78 | `setupExpenseTableColumns();` | Declares a JavaFX TableColumn control to bind a specific model property to a TableView column. |
| 79 | `setupIncomeTableColumns();` | Declares a JavaFX TableColumn control to bind a specific model property to a TableView column. |
| 80 | *Spacer* | Blank line used as a visual separator for code readability. |
| 81 | `// 2. Load Category ComboBox` | Single-line comment explaining: "2. Load Category ComboBox" |
| 82 | `loadCategories();` | Calls the method `loadCategories` to execute its corresponding logic. |
| 83 | *Spacer* | Blank line used as a visual separator for code readability. |
| 84 | `// 3. Load database tables with records` | Single-line comment explaining: "3. Load database tables with records" |
| 85 | `refreshTables();` | Calls the method `refreshTables` to execute its corresponding logic. |
| 86 | *Spacer* | Blank line used as a visual separator for code readability. |
| 87 | `// 4. Set default date picker values to today` | Single-line comment explaining: "4. Set default date picker values to today" |
| 88 | `expenseDatePicker.setValue(LocalDate.now());` | Calls the method `expenseDatePicker.setValue` to execute its corresponding logic. |
| 89 | `incomeDatePicker.setValue(LocalDate.now());` | Calls the method `incomeDatePicker.setValue` to execute its corresponding logic. |
| 90 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 91 | *Spacer* | Blank line used as a visual separator for code readability. |
| 92 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 93 | `* Map JavaFX columns to Expense model properties.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 94 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 95 | `private void setupExpenseTableColumns() {` | Declares a JavaFX TableColumn control to bind a specific model property to a TableView column. |
| 96 | `expenseIdCol.setCellValueFactory(new PropertyValueFactory<>("expenseId"));` | Calls the method `expenseIdCol.setCellValueFactory` to execute its corresponding logic. |
| 97 | `expenseAmountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));` | Calls the method `expenseAmountCol.setCellValueFactory` to execute its corresponding logic. |
| 98 | `expenseDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));` | Calls the method `expenseDescriptionCol.setCellValueFactory` to execute its corresponding logic. |
| 99 | `expenseDateCol.setCellValueFactory(new PropertyValueFactory<>("expenseDate"));` | Calls the method `expenseDateCol.setCellValueFactory` to execute its corresponding logic. |
| 100 | *Spacer* | Blank line used as a visual separator for code readability. |
| 101 | `// Dynamic cell rendering: Category is aggregated, so map its nested name property` | Single-line comment explaining: "Dynamic cell rendering: Category is aggregated, so map its nested name property" |
| 102 | `expenseCategoryCol.setCellValueFactory(cellData -> {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 103 | `Expense exp = cellData.getValue();` | Assigns or computes a value for the variable/field `exp`. |
| 104 | `if (exp.getCategory() != null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 105 | `return new SimpleStringProperty(exp.getCategory().getCategoryName());` | Returns the expression/value `new SimpleStringProperty(exp.getCategory().getCategoryName())` to the calling method, completing this thread's execution. |
| 106 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 107 | `return new SimpleStringProperty("Uncategorized");` | Returns the expression/value `new SimpleStringProperty("Uncategorized")` to the calling method, completing this thread's execution. |
| 108 | `});` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 109 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 110 | *Spacer* | Blank line used as a visual separator for code readability. |
| 111 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 112 | `* Map JavaFX columns to Income model properties.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 113 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 114 | `private void setupIncomeTableColumns() {` | Declares a JavaFX TableColumn control to bind a specific model property to a TableView column. |
| 115 | `incomeIdCol.setCellValueFactory(new PropertyValueFactory<>("incomeId"));` | Calls the method `incomeIdCol.setCellValueFactory` to execute its corresponding logic. |
| 116 | `incomeAmountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));` | Calls the method `incomeAmountCol.setCellValueFactory` to execute its corresponding logic. |
| 117 | `incomeDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));` | Calls the method `incomeDescriptionCol.setCellValueFactory` to execute its corresponding logic. |
| 118 | `incomeDateCol.setCellValueFactory(new PropertyValueFactory<>("incomeDate"));` | Calls the method `incomeDateCol.setCellValueFactory` to execute its corresponding logic. |
| 119 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 120 | *Spacer* | Blank line used as a visual separator for code readability. |
| 121 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 122 | `* Fetch all expense categories and display them inside the Combo Box.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 123 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 124 | `private void loadCategories() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 125 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 126 | `List<Category> categories = expenseService.getCategories();` | Assigns or computes a value for the variable/field `categories`. |
| 127 | `expenseCategoryComboBox.setItems(FXCollections.observableArrayList(categories));` | Declares a JavaFX ComboBox control to allow users to select from a dropdown list. |
| 128 | *Spacer* | Blank line used as a visual separator for code readability. |
| 129 | `// Format how categories are shown visually inside the ComboBox` | Single-line comment explaining: "Format how categories are shown visually inside the ComboBox" |
| 130 | `expenseCategoryComboBox.setConverter(new StringConverter<Category>() {` | Declares a JavaFX ComboBox control to allow users to select from a dropdown list. |
| 131 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 132 | `public String toString(Category category) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 133 | `return category == null ? "" : category.getCategoryName();` | Returns the expression/value `category == null ? "" : category.getCategoryName()` to the calling method, completing this thread's execution. |
| 134 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 135 | *Spacer* | Blank line used as a visual separator for code readability. |
| 136 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 137 | `public Category fromString(String string) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 138 | `return null; // Not needed for selection` | Returns the expression/value `null // Not needed for selection` to the calling method, completing this thread's execution. |
| 139 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 140 | `});` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 141 | `} catch (DatabaseException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 142 | `AlertUtil.showError("Database Error", "Failed to retrieve categories: " + e.getMessage());` | Calls the method `AlertUtil.showError` to execute its corresponding logic. |
| 143 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 144 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 145 | *Spacer* | Blank line used as a visual separator for code readability. |
| 146 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 147 | `* Re-query the database to load active records for the tables.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 148 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 149 | `private void refreshTables() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 150 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 151 | `// Load Expenses` | Single-line comment explaining: "Load Expenses" |
| 152 | `List<Expense> expenses = expenseService.getExpensesByUser(currentUser.getUserId());` | Assigns or computes a value for the variable/field `expenses`. |
| 153 | `expenseTableView.setItems(FXCollections.observableArrayList(expenses));` | Declares a JavaFX TableView control for displaying structured records in rows and columns. |
| 154 | *Spacer* | Blank line used as a visual separator for code readability. |
| 155 | `// Load Income` | Single-line comment explaining: "Load Income" |
| 156 | `List<Income> incomes = incomeService.getIncomesByUser(currentUser.getUserId());` | Assigns or computes a value for the variable/field `incomes`. |
| 157 | `incomeTableView.setItems(FXCollections.observableArrayList(incomes));` | Declares a JavaFX TableView control for displaying structured records in rows and columns. |
| 158 | `} catch (DatabaseException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 159 | `AlertUtil.showError("Database Error", "Failed to populate record tables: " + e.getMessage());` | Calls the method `AlertUtil.showError` to execute its corresponding logic. |
| 160 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 161 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 162 | *Spacer* | Blank line used as a visual separator for code readability. |
| 163 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 164 | `* Handle saving a new Expense.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 165 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 166 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 167 | `private void onSaveExpenseClick() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 168 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 169 | `Category category = expenseCategoryComboBox.getValue();` | Declares a JavaFX ComboBox control to allow users to select from a dropdown list. |
| 170 | `String amountStr = expenseAmountField.getText().trim();` | Assigns or computes a value for the variable/field `amountStr`. |
| 171 | `String description = expenseDescriptionField.getText().trim();` | Assigns or computes a value for the variable/field `description`. |
| 172 | `LocalDate date = expenseDatePicker.getValue();` | Assigns or computes a value for the variable/field `date`. |
| 173 | *Spacer* | Blank line used as a visual separator for code readability. |
| 174 | `if (amountStr.isEmpty()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 175 | `throw new ValidationException("Expense amount cannot be empty.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 176 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 177 | *Spacer* | Blank line used as a visual separator for code readability. |
| 178 | `double amount;` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 179 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 180 | `amount = Double.parseDouble(amountStr);` | Assigns or computes a value for the variable/field `amount`. |
| 181 | `} catch (NumberFormatException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 182 | `throw new ValidationException("Please enter a valid numeric value for the expense amount.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 183 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 184 | *Spacer* | Blank line used as a visual separator for code readability. |
| 185 | `// Call Service Layer with transaction values` | Single-line comment explaining: "Call Service Layer with transaction values" |
| 186 | `expenseService.addExpense(currentUser, category, amount, description, date);` | Calls the method `expenseService.addExpense` to execute its corresponding logic. |
| 187 | *Spacer* | Blank line used as a visual separator for code readability. |
| 188 | `AlertUtil.showSuccess("Success", "Expense successfully recorded!");` | Calls the method `AlertUtil.showSuccess` to execute its corresponding logic. |
| 189 | *Spacer* | Blank line used as a visual separator for code readability. |
| 190 | `// Clear inputs and refresh TableView` | Single-line comment explaining: "Clear inputs and refresh TableView" |
| 191 | `clearExpenseInputs();` | Calls the method `clearExpenseInputs` to execute its corresponding logic. |
| 192 | `refreshTables();` | Calls the method `refreshTables` to execute its corresponding logic. |
| 193 | *Spacer* | Blank line used as a visual separator for code readability. |
| 194 | `} catch (ValidationException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 195 | `AlertUtil.showWarning("Validation Error", e.getMessage());` | Calls the method `AlertUtil.showWarning` to execute its corresponding logic. |
| 196 | `} catch (DatabaseException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 197 | `AlertUtil.showError("Database Error", e.getMessage());` | Calls the method `AlertUtil.showError` to execute its corresponding logic. |
| 198 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 199 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 200 | *Spacer* | Blank line used as a visual separator for code readability. |
| 201 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 202 | `* Handle deleting selected Expense.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 203 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 204 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 205 | `private void onDeleteExpenseClick() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 206 | `Expense selected = expenseTableView.getSelectionModel().getSelectedItem();` | Declares a JavaFX TableView control for displaying structured records in rows and columns. |
| 207 | `if (selected == null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 208 | `AlertUtil.showWarning("Selection Required", "Please select an expense entry to delete.");` | Calls the method `AlertUtil.showWarning` to execute its corresponding logic. |
| 209 | `return;` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 210 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 211 | *Spacer* | Blank line used as a visual separator for code readability. |
| 212 | `boolean confirm = AlertUtil.showConfirmation("Confirm Deletion", "Are you sure you want to permanently delete this expense?");` | Assigns or computes a value for the variable/field `confirm`. |
| 213 | `if (confirm) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 214 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 215 | `expenseService.deleteExpense(selected.getExpenseId());` | Calls the method `expenseService.deleteExpense` to execute its corresponding logic. |
| 216 | `AlertUtil.showSuccess("Success", "Expense deleted successfully.");` | Calls the method `AlertUtil.showSuccess` to execute its corresponding logic. |
| 217 | `refreshTables();` | Calls the method `refreshTables` to execute its corresponding logic. |
| 218 | `} catch (DatabaseException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 219 | `AlertUtil.showError("Database Error", "Failed to delete expense entry: " + e.getMessage());` | Calls the method `AlertUtil.showError` to execute its corresponding logic. |
| 220 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 221 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 222 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 223 | *Spacer* | Blank line used as a visual separator for code readability. |
| 224 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 225 | `* Handle saving a new Income record.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 226 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 227 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 228 | `private void onSaveIncomeClick() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 229 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 230 | `String amountStr = incomeAmountField.getText().trim();` | Assigns or computes a value for the variable/field `amountStr`. |
| 231 | `String description = incomeDescriptionField.getText().trim();` | Assigns or computes a value for the variable/field `description`. |
| 232 | `LocalDate date = incomeDatePicker.getValue();` | Assigns or computes a value for the variable/field `date`. |
| 233 | *Spacer* | Blank line used as a visual separator for code readability. |
| 234 | `if (amountStr.isEmpty()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 235 | `throw new ValidationException("Income amount cannot be empty.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 236 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 237 | *Spacer* | Blank line used as a visual separator for code readability. |
| 238 | `double amount;` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 239 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 240 | `amount = Double.parseDouble(amountStr);` | Assigns or computes a value for the variable/field `amount`. |
| 241 | `} catch (NumberFormatException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 242 | `throw new ValidationException("Please enter a valid numeric value for the income amount.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 243 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 244 | *Spacer* | Blank line used as a visual separator for code readability. |
| 245 | `// Call Service Layer` | Single-line comment explaining: "Call Service Layer" |
| 246 | `incomeService.addIncome(currentUser, amount, description, date);` | Calls the method `incomeService.addIncome` to execute its corresponding logic. |
| 247 | *Spacer* | Blank line used as a visual separator for code readability. |
| 248 | `AlertUtil.showSuccess("Success", "Income entry successfully recorded!");` | Calls the method `AlertUtil.showSuccess` to execute its corresponding logic. |
| 249 | *Spacer* | Blank line used as a visual separator for code readability. |
| 250 | `// Clear and reload` | Single-line comment explaining: "Clear and reload" |
| 251 | `clearIncomeInputs();` | Calls the method `clearIncomeInputs` to execute its corresponding logic. |
| 252 | `refreshTables();` | Calls the method `refreshTables` to execute its corresponding logic. |
| 253 | *Spacer* | Blank line used as a visual separator for code readability. |
| 254 | `} catch (ValidationException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 255 | `AlertUtil.showWarning("Validation Error", e.getMessage());` | Calls the method `AlertUtil.showWarning` to execute its corresponding logic. |
| 256 | `} catch (DatabaseException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 257 | `AlertUtil.showError("Database Error", e.getMessage());` | Calls the method `AlertUtil.showError` to execute its corresponding logic. |
| 258 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 259 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 260 | *Spacer* | Blank line used as a visual separator for code readability. |
| 261 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 262 | `* Handle deleting selected Income entry.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 263 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 264 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 265 | `private void onDeleteIncomeClick() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 266 | `Income selected = incomeTableView.getSelectionModel().getSelectedItem();` | Declares a JavaFX TableView control for displaying structured records in rows and columns. |
| 267 | `if (selected == null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 268 | `AlertUtil.showWarning("Selection Required", "Please select an income entry to delete.");` | Calls the method `AlertUtil.showWarning` to execute its corresponding logic. |
| 269 | `return;` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 270 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 271 | *Spacer* | Blank line used as a visual separator for code readability. |
| 272 | `boolean confirm = AlertUtil.showConfirmation("Confirm Deletion", "Are you sure you want to permanently delete this income entry?");` | Assigns or computes a value for the variable/field `confirm`. |
| 273 | `if (confirm) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 274 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 275 | `incomeService.deleteIncome(selected.getIncomeId());` | Calls the method `incomeService.deleteIncome` to execute its corresponding logic. |
| 276 | `AlertUtil.showSuccess("Success", "Income entry deleted successfully.");` | Calls the method `AlertUtil.showSuccess` to execute its corresponding logic. |
| 277 | `refreshTables();` | Calls the method `refreshTables` to execute its corresponding logic. |
| 278 | `} catch (DatabaseException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 279 | `AlertUtil.showError("Database Error", "Failed to delete income entry: " + e.getMessage());` | Calls the method `AlertUtil.showError` to execute its corresponding logic. |
| 280 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 281 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 282 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 283 | *Spacer* | Blank line used as a visual separator for code readability. |
| 284 | `private void clearExpenseInputs() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 285 | `expenseCategoryComboBox.setValue(null);` | Declares a JavaFX ComboBox control to allow users to select from a dropdown list. |
| 286 | `expenseAmountField.clear();` | Calls the method `expenseAmountField.clear` to execute its corresponding logic. |
| 287 | `expenseDescriptionField.clear();` | Calls the method `expenseDescriptionField.clear` to execute its corresponding logic. |
| 288 | `expenseDatePicker.setValue(LocalDate.now());` | Calls the method `expenseDatePicker.setValue` to execute its corresponding logic. |
| 289 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 290 | *Spacer* | Blank line used as a visual separator for code readability. |
| 291 | `private void clearIncomeInputs() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 292 | `incomeAmountField.clear();` | Calls the method `incomeAmountField.clear` to execute its corresponding logic. |
| 293 | `incomeDescriptionField.clear();` | Calls the method `incomeDescriptionField.clear` to execute its corresponding logic. |
| 294 | `incomeDatePicker.setValue(LocalDate.now());` | Calls the method `incomeDatePicker.setValue` to execute its corresponding logic. |
| 295 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 296 | *Spacer* | Blank line used as a visual separator for code readability. |
| 297 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 298 | `private void onBackClick() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 299 | `MainApplication.showDashboardScreen();` | Calls the method `MainApplication.showDashboardScreen` to execute its corresponding logic. |
| 300 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 301 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `ExpenseController` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
- **Model-View-Controller (MVC) Pattern**: Performs controller view-binding tasks, isolating FXML controls, layout bindings, and visual handlers from computational services.
