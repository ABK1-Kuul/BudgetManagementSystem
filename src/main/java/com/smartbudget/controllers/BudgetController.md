# BudgetController.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.controllers`  
**Component Type:** `Class`  
**Description:** UI controller managing the budget definition screen, responding to user actions like creating, editing, and monitoring category limits.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private BudgetService budgetService;
private UserSession userSession;
private User currentUser;
```

### Declared Methods & Constructors (Behaviors)
```java
public void initialize();
private void loadBudgets();
private void onSaveBudgetClick();
private void onCheckStatusClick();
private void onDeleteBudgetClick();
private void updateStatusDisplay(int month, int year);
private void onBackClick();
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `BudgetController.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.controllers;` | Declares the package namespace `com.smartbudget.controllers` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import java.time.LocalDate;` | Imports `java.time.LocalDate` to make its classes and methods accessible within this file. |
| 4 | `import java.util.List;` | Imports `java.util.List` to make its classes and methods accessible within this file. |
| 5 | *Spacer* | Blank line used as a visual separator for code readability. |
| 6 | `import com.smartbudget.MainApplication;` | Imports `com.smartbudget.MainApplication` to make its classes and methods accessible within this file. |
| 7 | `import com.smartbudget.exceptions.DatabaseException;` | Imports `com.smartbudget.exceptions.DatabaseException` to make its classes and methods accessible within this file. |
| 8 | `import com.smartbudget.exceptions.ValidationException;` | Imports `com.smartbudget.exceptions.ValidationException` to make its classes and methods accessible within this file. |
| 9 | `import com.smartbudget.models.Budget;` | Imports `com.smartbudget.models.Budget` to make its classes and methods accessible within this file. |
| 10 | `import com.smartbudget.models.User;` | Imports `com.smartbudget.models.User` to make its classes and methods accessible within this file. |
| 11 | `import com.smartbudget.services.BudgetService;` | Imports `com.smartbudget.services.BudgetService` to make its classes and methods accessible within this file. |
| 12 | `import com.smartbudget.session.UserSession;` | Imports `com.smartbudget.session.UserSession` to make its classes and methods accessible within this file. |
| 13 | `import com.smartbudget.utils.AlertUtil;` | Imports `com.smartbudget.utils.AlertUtil` to make its classes and methods accessible within this file. |
| 14 | *Spacer* | Blank line used as a visual separator for code readability. |
| 15 | `import javafx.collections.FXCollections;` | Imports `javafx.collections.FXCollections` to make its classes and methods accessible within this file. |
| 16 | `import javafx.fxml.FXML;` | Imports `javafx.fxml.FXML` to make its classes and methods accessible within this file. |
| 17 | `import javafx.scene.control.ComboBox;` | Imports `javafx.scene.control.ComboBox` to make its classes and methods accessible within this file. |
| 18 | `import javafx.scene.control.Label;` | Imports `javafx.scene.control.Label` to make its classes and methods accessible within this file. |
| 19 | `import javafx.scene.control.TableColumn;` | Imports `javafx.scene.control.TableColumn` to make its classes and methods accessible within this file. |
| 20 | `import javafx.scene.control.TableView;` | Imports `javafx.scene.control.TableView` to make its classes and methods accessible within this file. |
| 21 | `import javafx.scene.control.TextField;` | Imports `javafx.scene.control.TextField` to make its classes and methods accessible within this file. |
| 22 | `import javafx.scene.control.cell.PropertyValueFactory;` | Imports `javafx.scene.control.cell.PropertyValueFactory` to make its classes and methods accessible within this file. |
| 23 | *Spacer* | Blank line used as a visual separator for code readability. |
| 24 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 25 | `* Controller for Budget configuration.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 26 | `* Maps monthly budget inputs, displays set budgets, and queries status calculations.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 27 | `* Demonstrates MVC structure and simple business rule routing.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 28 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 29 | `public class BudgetController {` | Declares the public class `BudgetController` as a main architectural component of the module. |
| 30 | *Spacer* | Blank line used as a visual separator for code readability. |
| 31 | `// Inputs` | Single-line comment explaining: "Inputs" |
| 32 | `@FXML private ComboBox<Integer> yearComboBox;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 33 | `@FXML private ComboBox<Integer> monthComboBox;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 34 | `@FXML private TextField budgetAmountField;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 35 | *Spacer* | Blank line used as a visual separator for code readability. |
| 36 | `// Table` | Single-line comment explaining: "Table" |
| 37 | `@FXML private TableView<Budget> budgetTableView;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 38 | `@FXML private TableColumn<Budget, Integer> budgetIdCol;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 39 | `@FXML private TableColumn<Budget, Integer> budgetYearCol;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 40 | `@FXML private TableColumn<Budget, Integer> budgetMonthCol;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 41 | `@FXML private TableColumn<Budget, Double> budgetAmountCol;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 42 | *Spacer* | Blank line used as a visual separator for code readability. |
| 43 | `// Status Area` | Single-line comment explaining: "Status Area" |
| 44 | `@FXML private Label statusBudgetLabel;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 45 | `@FXML private Label statusSpentLabel;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 46 | `@FXML private Label statusRemainingLabel;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 47 | *Spacer* | Blank line used as a visual separator for code readability. |
| 48 | `private BudgetService budgetService;` | Declares a private instance field `budgetService` of type `BudgetService` to maintain state with strict encapsulation. |
| 49 | `private UserSession userSession;` | Declares a private instance field `userSession` of type `UserSession` to maintain state with strict encapsulation. |
| 50 | `private User currentUser;` | Declares a private instance field `currentUser` of type `User` to maintain state with strict encapsulation. |
| 51 | *Spacer* | Blank line used as a visual separator for code readability. |
| 52 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 53 | `public void initialize() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 54 | `budgetService = new BudgetService();` | Assigns or computes a value for the variable/field `budgetService`. |
| 55 | `userSession = UserSession.getInstance();` | Assigns or computes a value for the variable/field `userSession`. |
| 56 | *Spacer* | Blank line used as a visual separator for code readability. |
| 57 | `if (!userSession.isLoggedIn()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 58 | `MainApplication.showLoginScreen();` | Calls the method `MainApplication.showLoginScreen` to execute its corresponding logic. |
| 59 | `return;` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 60 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 61 | *Spacer* | Blank line used as a visual separator for code readability. |
| 62 | `currentUser = userSession.getCurrentUser();` | Assigns or computes a value for the variable/field `currentUser`. |
| 63 | *Spacer* | Blank line used as a visual separator for code readability. |
| 64 | `// 1. Configure ComboBox selections` | Single-line comment explaining: "1. Configure ComboBox selections" |
| 65 | `yearComboBox.setItems(FXCollections.observableArrayList(2025, 2026, 2027, 2028, 2029, 2030));` | Declares a JavaFX ComboBox control to allow users to select from a dropdown list. |
| 66 | `monthComboBox.setItems(FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));` | Declares a JavaFX ComboBox control to allow users to select from a dropdown list. |
| 67 | *Spacer* | Blank line used as a visual separator for code readability. |
| 68 | `// Default to current year and month` | Single-line comment explaining: "Default to current year and month" |
| 69 | `LocalDate today = LocalDate.now();` | Assigns or computes a value for the variable/field `today`. |
| 70 | `yearComboBox.setValue(today.getYear());` | Declares a JavaFX ComboBox control to allow users to select from a dropdown list. |
| 71 | `monthComboBox.setValue(today.getMonthValue());` | Declares a JavaFX ComboBox control to allow users to select from a dropdown list. |
| 72 | *Spacer* | Blank line used as a visual separator for code readability. |
| 73 | `// 2. Configure table bindings` | Single-line comment explaining: "2. Configure table bindings" |
| 74 | `budgetIdCol.setCellValueFactory(new PropertyValueFactory<>("budgetId"));` | Calls the method `budgetIdCol.setCellValueFactory` to execute its corresponding logic. |
| 75 | `budgetYearCol.setCellValueFactory(new PropertyValueFactory<>("year"));` | Calls the method `budgetYearCol.setCellValueFactory` to execute its corresponding logic. |
| 76 | `budgetMonthCol.setCellValueFactory(new PropertyValueFactory<>("month"));` | Calls the method `budgetMonthCol.setCellValueFactory` to execute its corresponding logic. |
| 77 | `budgetAmountCol.setCellValueFactory(new PropertyValueFactory<>("amount"));` | Calls the method `budgetAmountCol.setCellValueFactory` to execute its corresponding logic. |
| 78 | *Spacer* | Blank line used as a visual separator for code readability. |
| 79 | `// 3. Load budget records from DB` | Single-line comment explaining: "3. Load budget records from DB" |
| 80 | `loadBudgets();` | Calls the method `loadBudgets` to execute its corresponding logic. |
| 81 | *Spacer* | Blank line used as a visual separator for code readability. |
| 82 | `// 4. Precheck current month status` | Single-line comment explaining: "4. Precheck current month status" |
| 83 | `updateStatusDisplay(today.getMonthValue(), today.getYear());` | Calls the method `updateStatusDisplay` to execute its corresponding logic. |
| 84 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 85 | *Spacer* | Blank line used as a visual separator for code readability. |
| 86 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 87 | `* Re-query DB and populate TableView with set budgets.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 88 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 89 | `private void loadBudgets() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 90 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 91 | `List<Budget> budgets = budgetService.getBudgetsByUser(currentUser.getUserId());` | Assigns or computes a value for the variable/field `budgets`. |
| 92 | `budgetTableView.setItems(FXCollections.observableArrayList(budgets));` | Declares a JavaFX TableView control for displaying structured records in rows and columns. |
| 93 | `} catch (DatabaseException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 94 | `AlertUtil.showError("Database Error", "Failed to retrieve budgets: " + e.getMessage());` | Calls the method `AlertUtil.showError` to execute its corresponding logic. |
| 95 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 96 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 97 | *Spacer* | Blank line used as a visual separator for code readability. |
| 98 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 99 | `* Save/Create a new monthly budget.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 100 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 101 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 102 | `private void onSaveBudgetClick() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 103 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 104 | `Integer year = yearComboBox.getValue();` | Declares a JavaFX ComboBox control to allow users to select from a dropdown list. |
| 105 | `Integer month = monthComboBox.getValue();` | Declares a JavaFX ComboBox control to allow users to select from a dropdown list. |
| 106 | `String amountStr = budgetAmountField.getText().trim();` | Assigns or computes a value for the variable/field `amountStr`. |
| 107 | *Spacer* | Blank line used as a visual separator for code readability. |
| 108 | `if (year == null) throw new ValidationException("Please select a target Year.");` | Assigns or computes a value for the variable/field `(year`. |
| 109 | `if (month == null) throw new ValidationException("Please select a target Month.");` | Assigns or computes a value for the variable/field `(month`. |
| 110 | `if (amountStr.isEmpty()) throw new ValidationException("Budget limit amount cannot be empty.");` | Calls the method `if` to execute its corresponding logic. |
| 111 | *Spacer* | Blank line used as a visual separator for code readability. |
| 112 | `double amount;` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 113 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 114 | `amount = Double.parseDouble(amountStr);` | Assigns or computes a value for the variable/field `amount`. |
| 115 | `} catch (NumberFormatException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 116 | `throw new ValidationException("Please enter a valid numeric value for the budget amount.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 117 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 118 | *Spacer* | Blank line used as a visual separator for code readability. |
| 119 | `// Save to DB` | Single-line comment explaining: "Save to DB" |
| 120 | `budgetService.setBudget(currentUser, month, year, amount);` | Calls the method `budgetService.setBudget` to execute its corresponding logic. |
| 121 | *Spacer* | Blank line used as a visual separator for code readability. |
| 122 | `AlertUtil.showSuccess("Success", "Budget plan saved successfully!");` | Calls the method `AlertUtil.showSuccess` to execute its corresponding logic. |
| 123 | *Spacer* | Blank line used as a visual separator for code readability. |
| 124 | `budgetAmountField.clear();` | Calls the method `budgetAmountField.clear` to execute its corresponding logic. |
| 125 | `loadBudgets();` | Calls the method `loadBudgets` to execute its corresponding logic. |
| 126 | `updateStatusDisplay(month, year);` | Calls the method `updateStatusDisplay` to execute its corresponding logic. |
| 127 | *Spacer* | Blank line used as a visual separator for code readability. |
| 128 | `} catch (ValidationException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 129 | `AlertUtil.showWarning("Validation Error", e.getMessage());` | Calls the method `AlertUtil.showWarning` to execute its corresponding logic. |
| 130 | `} catch (DatabaseException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 131 | `AlertUtil.showError("Database Error", e.getMessage());` | Calls the method `AlertUtil.showError` to execute its corresponding logic. |
| 132 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 133 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 134 | *Spacer* | Blank line used as a visual separator for code readability. |
| 135 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 136 | `* Query budget spent calculations for selected ComboBox dates.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 137 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 138 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 139 | `private void onCheckStatusClick() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 140 | `Integer month = monthComboBox.getValue();` | Declares a JavaFX ComboBox control to allow users to select from a dropdown list. |
| 141 | `Integer year = yearComboBox.getValue();` | Declares a JavaFX ComboBox control to allow users to select from a dropdown list. |
| 142 | *Spacer* | Blank line used as a visual separator for code readability. |
| 143 | `if (month == null \|\| year == null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 144 | `AlertUtil.showWarning("Period Required", "Please select both a Month and a Year to check budget status.");` | Calls the method `AlertUtil.showWarning` to execute its corresponding logic. |
| 145 | `return;` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 146 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 147 | *Spacer* | Blank line used as a visual separator for code readability. |
| 148 | `updateStatusDisplay(month, year);` | Calls the method `updateStatusDisplay` to execute its corresponding logic. |
| 149 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 150 | *Spacer* | Blank line used as a visual separator for code readability. |
| 151 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 152 | `* Delete selected budget.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 153 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 154 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 155 | `private void onDeleteBudgetClick() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 156 | `Budget selected = budgetTableView.getSelectionModel().getSelectedItem();` | Declares a JavaFX TableView control for displaying structured records in rows and columns. |
| 157 | `if (selected == null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 158 | `AlertUtil.showWarning("Selection Required", "Please select a budget plan to delete from the list.");` | Calls the method `AlertUtil.showWarning` to execute its corresponding logic. |
| 159 | `return;` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 160 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 161 | *Spacer* | Blank line used as a visual separator for code readability. |
| 162 | `boolean confirm = AlertUtil.showConfirmation("Confirm Deletion", "Are you sure you want to permanently delete this budget plan?");` | Assigns or computes a value for the variable/field `confirm`. |
| 163 | `if (confirm) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 164 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 165 | `budgetService.deleteBudget(selected.getBudgetId()); // delete standard ID` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 166 | `AlertUtil.showSuccess("Success", "Budget plan deleted successfully.");` | Calls the method `AlertUtil.showSuccess` to execute its corresponding logic. |
| 167 | `loadBudgets();` | Calls the method `loadBudgets` to execute its corresponding logic. |
| 168 | *Spacer* | Blank line used as a visual separator for code readability. |
| 169 | `// Clear query displays` | Single-line comment explaining: "Clear query displays" |
| 170 | `statusBudgetLabel.setText("0.00 ETB");` | Calls the method `statusBudgetLabel.setText` to execute its corresponding logic. |
| 171 | `statusSpentLabel.setText("0.00 ETB");` | Calls the method `statusSpentLabel.setText` to execute its corresponding logic. |
| 172 | `statusRemainingLabel.setText("0.00 ETB");` | Calls the method `statusRemainingLabel.setText` to execute its corresponding logic. |
| 173 | `statusRemainingLabel.setStyle("-fx-text-fill: black;");` | Calls the method `statusRemainingLabel.setStyle` to execute its corresponding logic. |
| 174 | `} catch (DatabaseException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 175 | `AlertUtil.showError("Database Error", "Failed to delete budget plan: " + e.getMessage());` | Calls the method `AlertUtil.showError` to execute its corresponding logic. |
| 176 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 177 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 178 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 179 | *Spacer* | Blank line used as a visual separator for code readability. |
| 180 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 181 | `* Update the query labels showing Total Budget, Spent, and Remaining amounts.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 182 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 183 | `private void updateStatusDisplay(int month, int year) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 184 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 185 | `int userId = currentUser.getUserId();` | Assigns or computes a value for the variable/field `userId`. |
| 186 | `Budget budget = budgetService.getBudgetForPeriod(userId, month, year);` | Assigns or computes a value for the variable/field `budget`. |
| 187 | *Spacer* | Blank line used as a visual separator for code readability. |
| 188 | `if (budget == null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 189 | `statusBudgetLabel.setText("0.00 ETB (Not Set)");` | Calls the method `statusBudgetLabel.setText` to execute its corresponding logic. |
| 190 | `double spent = budgetService.getSpentForPeriod(userId, month, year);` | Assigns or computes a value for the variable/field `spent`. |
| 191 | `statusSpentLabel.setText(String.format("%.2f ETB", spent));` | Calls the method `statusSpentLabel.setText` to execute its corresponding logic. |
| 192 | `statusRemainingLabel.setText(String.format("%.2f ETB", -spent));` | Calls the method `statusRemainingLabel.setText` to execute its corresponding logic. |
| 193 | `statusRemainingLabel.setStyle("-fx-text-fill: #e74c3c;"); // Red (no budget)` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 194 | `return;` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 195 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 196 | *Spacer* | Blank line used as a visual separator for code readability. |
| 197 | `double limit = budget.getAmount();` | Assigns or computes a value for the variable/field `limit`. |
| 198 | `double spent = budgetService.getSpentForPeriod(userId, month, year);` | Assigns or computes a value for the variable/field `spent`. |
| 199 | `double remaining = limit - spent;` | Assigns or computes a value for the variable/field `remaining`. |
| 200 | *Spacer* | Blank line used as a visual separator for code readability. |
| 201 | `statusBudgetLabel.setText(String.format("%.2f ETB", limit));` | Calls the method `statusBudgetLabel.setText` to execute its corresponding logic. |
| 202 | `statusSpentLabel.setText(String.format("%.2f ETB", spent));` | Calls the method `statusSpentLabel.setText` to execute its corresponding logic. |
| 203 | `statusRemainingLabel.setText(String.format("%.2f ETB", remaining));` | Calls the method `statusRemainingLabel.setText` to execute its corresponding logic. |
| 204 | *Spacer* | Blank line used as a visual separator for code readability. |
| 205 | `if (remaining < 0) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 206 | `statusRemainingLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-weight: bold;"); // Red (Overbudget!)` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 207 | `} else {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 208 | `statusRemainingLabel.setStyle("-fx-text-fill: #27ae60; -fx-font-weight: bold;"); // Green (Under budget!)` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 209 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 210 | *Spacer* | Blank line used as a visual separator for code readability. |
| 211 | `} catch (DatabaseException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 212 | `System.err.println("Error updating budget status query display: " + e.getMessage());` | Calls the method `System.err.println` to execute its corresponding logic. |
| 213 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 214 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 215 | *Spacer* | Blank line used as a visual separator for code readability. |
| 216 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 217 | `private void onBackClick() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 218 | `MainApplication.showDashboardScreen();` | Calls the method `MainApplication.showDashboardScreen` to execute its corresponding logic. |
| 219 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 220 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `BudgetController` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
- **Model-View-Controller (MVC) Pattern**: Performs controller view-binding tasks, isolating FXML controls, layout bindings, and visual handlers from computational services.
