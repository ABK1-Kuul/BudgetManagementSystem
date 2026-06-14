# ReportController.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.controllers`  
**Component Type:** `Class`  
**Description:** UI controller rendering interactive reports, binding pie charts or bar charts with aggregated monthly metrics.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private ExpenseService expenseService;
private DashboardService dashboardService;
private UserSession userSession;
```

### Declared Methods & Constructors (Behaviors)
```java
public void initialize();
private void loadReportData();
private void onBackClick();
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `ReportController.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.controllers;` | Declares the package namespace `com.smartbudget.controllers` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import java.util.HashMap;` | Imports `java.util.HashMap` to make its classes and methods accessible within this file. |
| 4 | `import java.util.List;` | Imports `java.util.List` to make its classes and methods accessible within this file. |
| 5 | `import java.util.Map;` | Imports `java.util.Map` to make its classes and methods accessible within this file. |
| 6 | *Spacer* | Blank line used as a visual separator for code readability. |
| 7 | `import com.smartbudget.MainApplication;` | Imports `com.smartbudget.MainApplication` to make its classes and methods accessible within this file. |
| 8 | `import com.smartbudget.exceptions.DatabaseException;` | Imports `com.smartbudget.exceptions.DatabaseException` to make its classes and methods accessible within this file. |
| 9 | `import com.smartbudget.models.Expense;` | Imports `com.smartbudget.models.Expense` to make its classes and methods accessible within this file. |
| 10 | `import com.smartbudget.services.DashboardService;` | Imports `com.smartbudget.services.DashboardService` to make its classes and methods accessible within this file. |
| 11 | `import com.smartbudget.services.ExpenseService;` | Imports `com.smartbudget.services.ExpenseService` to make its classes and methods accessible within this file. |
| 12 | `import com.smartbudget.session.UserSession;` | Imports `com.smartbudget.session.UserSession` to make its classes and methods accessible within this file. |
| 13 | `import com.smartbudget.utils.AlertUtil;` | Imports `com.smartbudget.utils.AlertUtil` to make its classes and methods accessible within this file. |
| 14 | *Spacer* | Blank line used as a visual separator for code readability. |
| 15 | `import javafx.collections.FXCollections;` | Imports `javafx.collections.FXCollections` to make its classes and methods accessible within this file. |
| 16 | `import javafx.collections.ObservableList;` | Imports `javafx.collections.ObservableList` to make its classes and methods accessible within this file. |
| 17 | `import javafx.fxml.FXML;` | Imports `javafx.fxml.FXML` to make its classes and methods accessible within this file. |
| 18 | `import javafx.scene.chart.PieChart;` | Imports `javafx.scene.chart.PieChart` to make its classes and methods accessible within this file. |
| 19 | `import javafx.scene.control.Label;` | Imports `javafx.scene.control.Label` to make its classes and methods accessible within this file. |
| 20 | *Spacer* | Blank line used as a visual separator for code readability. |
| 21 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 22 | `* Controller for Reporting and Charts.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 23 | `* Aggregates expense categories and renders a JavaFX PieChart.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 24 | `* Demonstrates MVC structure and simple sorting/mapping algorithms in OOP.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 25 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 26 | `public class ReportController {` | Declares the public class `ReportController` as a main architectural component of the module. |
| 27 | *Spacer* | Blank line used as a visual separator for code readability. |
| 28 | `@FXML private Label reportIncomeLabel;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 29 | `@FXML private Label reportExpenseLabel;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 30 | `@FXML private Label reportSavingsLabel;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 31 | `@FXML private PieChart expensePieChart;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 32 | *Spacer* | Blank line used as a visual separator for code readability. |
| 33 | `private ExpenseService expenseService;` | Declares a private instance field `expenseService` of type `ExpenseService` to maintain state with strict encapsulation. |
| 34 | `private DashboardService dashboardService;` | Declares a private instance field `dashboardService` of type `DashboardService` to maintain state with strict encapsulation. |
| 35 | `private UserSession userSession;` | Declares a private instance field `userSession` of type `UserSession` to maintain state with strict encapsulation. |
| 36 | *Spacer* | Blank line used as a visual separator for code readability. |
| 37 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 38 | `public void initialize() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 39 | `expenseService = new ExpenseService();` | Assigns or computes a value for the variable/field `expenseService`. |
| 40 | `dashboardService = new DashboardService();` | Assigns or computes a value for the variable/field `dashboardService`. |
| 41 | `userSession = UserSession.getInstance();` | Assigns or computes a value for the variable/field `userSession`. |
| 42 | *Spacer* | Blank line used as a visual separator for code readability. |
| 43 | `if (!userSession.isLoggedIn()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 44 | `MainApplication.showLoginScreen();` | Calls the method `MainApplication.showLoginScreen` to execute its corresponding logic. |
| 45 | `return;` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 46 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 47 | *Spacer* | Blank line used as a visual separator for code readability. |
| 48 | `loadReportData();` | Calls the method `loadReportData` to execute its corresponding logic. |
| 49 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 50 | *Spacer* | Blank line used as a visual separator for code readability. |
| 51 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 52 | `* Fetch records and populate chart slice data and numeric totals.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 53 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 54 | `private void loadReportData() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 55 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 56 | `int userId = userSession.getCurrentUserId();` | Assigns or computes a value for the variable/field `userId`. |
| 57 | *Spacer* | Blank line used as a visual separator for code readability. |
| 58 | `// 1. Fetch live metrics from dashboard service` | Single-line comment explaining: "1. Fetch live metrics from dashboard service" |
| 59 | `double incomeSum = dashboardService.getTotalIncome(userId);` | Assigns or computes a value for the variable/field `incomeSum`. |
| 60 | `double expenseSum = dashboardService.getTotalExpenses(userId);` | Assigns or computes a value for the variable/field `expenseSum`. |
| 61 | `double savings = incomeSum - expenseSum;` | Assigns or computes a value for the variable/field `savings`. |
| 62 | *Spacer* | Blank line used as a visual separator for code readability. |
| 63 | `reportIncomeLabel.setText(String.format("%.2f ETB", incomeSum));` | Calls the method `reportIncomeLabel.setText` to execute its corresponding logic. |
| 64 | `reportExpenseLabel.setText(String.format("%.2f ETB", expenseSum));` | Calls the method `reportExpenseLabel.setText` to execute its corresponding logic. |
| 65 | `reportSavingsLabel.setText(String.format("%.2f ETB", savings));` | Calls the method `reportSavingsLabel.setText` to execute its corresponding logic. |
| 66 | *Spacer* | Blank line used as a visual separator for code readability. |
| 67 | `if (savings < 0) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 68 | `reportSavingsLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-weight: bold;"); // Deficit` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 69 | `} else {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 70 | `reportSavingsLabel.setStyle("-fx-text-fill: #27ae60; -fx-font-weight: bold;"); // Surplus` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 71 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 72 | *Spacer* | Blank line used as a visual separator for code readability. |
| 73 | `// 2. Fetch expenses and aggregate them by category for the PieChart` | Single-line comment explaining: "2. Fetch expenses and aggregate them by category for the PieChart" |
| 74 | `List<Expense> expenses = expenseService.getExpensesByUser(userId);` | Assigns or computes a value for the variable/field `expenses`. |
| 75 | `Map<String, Double> categoryTotals = new HashMap<>();` | Assigns or computes a value for the variable/field `categoryTotals`. |
| 76 | *Spacer* | Blank line used as a visual separator for code readability. |
| 77 | `for (Expense expense : expenses) {` | Loop statement iterating through a collection, array, or list of objects. |
| 78 | `String catName = "Other";` | Assigns or computes a value for the variable/field `catName`. |
| 79 | `if (expense.getCategory() != null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 80 | `catName = expense.getCategory().getCategoryName();` | Assigns or computes a value for the variable/field `catName`. |
| 81 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 82 | *Spacer* | Blank line used as a visual separator for code readability. |
| 83 | `categoryTotals.put(catName, categoryTotals.getOrDefault(catName, 0.0) + expense.getAmount());` | Calls the method `categoryTotals.put` to execute its corresponding logic. |
| 84 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 85 | *Spacer* | Blank line used as a visual separator for code readability. |
| 86 | `// 3. Populate PieChart data slices` | Single-line comment explaining: "3. Populate PieChart data slices" |
| 87 | `ObservableList<PieChart.Data> chartData = FXCollections.observableArrayList();` | Assigns or computes a value for the variable/field `chartData`. |
| 88 | `for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {` | Loop statement iterating through a collection, array, or list of objects. |
| 89 | `chartData.add(new PieChart.Data(entry.getKey() + " (" + String.format("%.2f ETB", entry.getValue()) + ")", entry.getValue()));` | Calls the method `chartData.add` to execute its corresponding logic. |
| 90 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 91 | *Spacer* | Blank line used as a visual separator for code readability. |
| 92 | `expensePieChart.setData(chartData);` | Calls the method `expensePieChart.setData` to execute its corresponding logic. |
| 93 | *Spacer* | Blank line used as a visual separator for code readability. |
| 94 | `} catch (DatabaseException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 95 | `AlertUtil.showError("Database Error", "Failed to compile financial reports: " + e.getMessage());` | Calls the method `AlertUtil.showError` to execute its corresponding logic. |
| 96 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 97 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 98 | *Spacer* | Blank line used as a visual separator for code readability. |
| 99 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 100 | `private void onBackClick() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 101 | `MainApplication.showDashboardScreen();` | Calls the method `MainApplication.showDashboardScreen` to execute its corresponding logic. |
| 102 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 103 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `ReportController` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
- **Model-View-Controller (MVC) Pattern**: Performs controller view-binding tasks, isolating FXML controls, layout bindings, and visual handlers from computational services.
