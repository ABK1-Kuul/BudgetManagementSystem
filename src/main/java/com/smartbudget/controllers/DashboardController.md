# DashboardController.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.controllers`  
**Component Type:** `Class`  
**Description:** UI controller binding dashboard.fxml. Dynamically displays high-level financial breakdowns, charts, and system status metrics.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private UserSession userSession;
private DashboardService dashboardService;
```

### Declared Methods & Constructors (Behaviors)
```java
public void initialize();
private void loadDashboardData();
private void onLogoutClick();
private void onExpensesClick();
private void onBudgetClick();
private void onReportsClick();
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `DashboardController.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.controllers;` | Declares the package namespace `com.smartbudget.controllers` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import com.smartbudget.MainApplication;` | Imports `com.smartbudget.MainApplication` to make its classes and methods accessible within this file. |
| 4 | `import com.smartbudget.exceptions.DatabaseException;` | Imports `com.smartbudget.exceptions.DatabaseException` to make its classes and methods accessible within this file. |
| 5 | `import com.smartbudget.services.DashboardService;` | Imports `com.smartbudget.services.DashboardService` to make its classes and methods accessible within this file. |
| 6 | `import com.smartbudget.session.UserSession;` | Imports `com.smartbudget.session.UserSession` to make its classes and methods accessible within this file. |
| 7 | `import com.smartbudget.utils.AlertUtil;` | Imports `com.smartbudget.utils.AlertUtil` to make its classes and methods accessible within this file. |
| 8 | *Spacer* | Blank line used as a visual separator for code readability. |
| 9 | `import javafx.fxml.FXML;` | Imports `javafx.fxml.FXML` to make its classes and methods accessible within this file. |
| 10 | `import javafx.scene.control.Label;` | Imports `javafx.scene.control.Label` to make its classes and methods accessible within this file. |
| 11 | *Spacer* | Blank line used as a visual separator for code readability. |
| 12 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 13 | `* Controller for the Dashboard screen.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 14 | `* Displays overall financial summaries (total income, total expenses, net balance)` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 15 | `* dynamically loaded from the database via DashboardService.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 16 | `* Demonstrates MVC coordination and clean session state retrieval.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 17 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 18 | `public class DashboardController {` | Declares the public class `DashboardController` as a main architectural component of the module. |
| 19 | *Spacer* | Blank line used as a visual separator for code readability. |
| 20 | `@FXML private Label welcomeLabel;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 21 | `@FXML private Label totalIncomeLabel;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 22 | `@FXML private Label totalExpensesLabel;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 23 | `@FXML private Label balanceLabel;` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 24 | *Spacer* | Blank line used as a visual separator for code readability. |
| 25 | `private UserSession userSession;` | Declares a private instance field `userSession` of type `UserSession` to maintain state with strict encapsulation. |
| 26 | `private DashboardService dashboardService;` | Declares a private instance field `dashboardService` of type `DashboardService` to maintain state with strict encapsulation. |
| 27 | *Spacer* | Blank line used as a visual separator for code readability. |
| 28 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 29 | `* Initialize controller.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 30 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 31 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 32 | `public void initialize() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 33 | `userSession = UserSession.getInstance();` | Assigns or computes a value for the variable/field `userSession`. |
| 34 | `dashboardService = new DashboardService();` | Assigns or computes a value for the variable/field `dashboardService`. |
| 35 | *Spacer* | Blank line used as a visual separator for code readability. |
| 36 | `// Check if user is logged in` | Single-line comment explaining: "Check if user is logged in" |
| 37 | `if (userSession.isLoggedIn()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 38 | `String username = userSession.getCurrentUsername();` | Assigns or computes a value for the variable/field `username`. |
| 39 | `welcomeLabel.setText("Welcome, " + username + "!");` | Calls the method `welcomeLabel.setText` to execute its corresponding logic. |
| 40 | *Spacer* | Blank line used as a visual separator for code readability. |
| 41 | `// Load live dashboard metrics from the database` | Single-line comment explaining: "Load live dashboard metrics from the database" |
| 42 | `loadDashboardData();` | Calls the method `loadDashboardData` to execute its corresponding logic. |
| 43 | `} else {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 44 | `// Redirect to login if not logged in` | Single-line comment explaining: "Redirect to login if not logged in" |
| 45 | `MainApplication.showLoginScreen();` | Calls the method `MainApplication.showLoginScreen` to execute its corresponding logic. |
| 46 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 47 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 48 | *Spacer* | Blank line used as a visual separator for code readability. |
| 49 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 50 | `* Load live dashboard metrics from DashboardService.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 51 | `* Integrates database aggregations.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 52 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 53 | `private void loadDashboardData() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 54 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 55 | `int userId = userSession.getCurrentUserId();` | Assigns or computes a value for the variable/field `userId`. |
| 56 | *Spacer* | Blank line used as a visual separator for code readability. |
| 57 | `// 1. Fetch values` | Single-line comment explaining: "1. Fetch values" |
| 58 | `double totalIncome = dashboardService.getTotalIncome(userId);` | Assigns or computes a value for the variable/field `totalIncome`. |
| 59 | `double totalExpenses = dashboardService.getTotalExpenses(userId);` | Assigns or computes a value for the variable/field `totalExpenses`. |
| 60 | `double netBalance = dashboardService.getNetBalance(userId);` | Assigns or computes a value for the variable/field `netBalance`. |
| 61 | *Spacer* | Blank line used as a visual separator for code readability. |
| 62 | `// 2. Format as Currency` | Single-line comment explaining: "2. Format as Currency" |
| 63 | `totalIncomeLabel.setText(String.format("%.2f ETB", totalIncome));` | Calls the method `totalIncomeLabel.setText` to execute its corresponding logic. |
| 64 | `totalExpensesLabel.setText(String.format("%.2f ETB", totalExpenses));` | Calls the method `totalExpensesLabel.setText` to execute its corresponding logic. |
| 65 | `balanceLabel.setText(String.format("%.2f ETB", netBalance));` | Calls the method `balanceLabel.setText` to execute its corresponding logic. |
| 66 | *Spacer* | Blank line used as a visual separator for code readability. |
| 67 | `// 3. Optional: apply color cues based on balance` | Single-line comment explaining: "3. Optional: apply color cues based on balance" |
| 68 | `if (netBalance < 0) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 69 | `balanceLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-size: 20; -fx-font-weight: bold;"); // Red for negative` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 70 | `} else {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 71 | `balanceLabel.setStyle("-fx-text-fill: #9b59b6; -fx-font-size: 20; -fx-font-weight: bold;"); // Purple / Green for positive` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 72 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 73 | *Spacer* | Blank line used as a visual separator for code readability. |
| 74 | `} catch (DatabaseException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 75 | `AlertUtil.showError("Database Error", "Failed to retrieve financial summary from the database: " + e.getMessage());` | Calls the method `AlertUtil.showError` to execute its corresponding logic. |
| 76 | `totalIncomeLabel.setText("Error");` | Calls the method `totalIncomeLabel.setText` to execute its corresponding logic. |
| 77 | `totalExpensesLabel.setText("Error");` | Calls the method `totalExpensesLabel.setText` to execute its corresponding logic. |
| 78 | `balanceLabel.setText("Error");` | Calls the method `balanceLabel.setText` to execute its corresponding logic. |
| 79 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 80 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 81 | *Spacer* | Blank line used as a visual separator for code readability. |
| 82 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 83 | `* Handle logout button click.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 84 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 85 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 86 | `private void onLogoutClick() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 87 | `userSession.logout();` | Calls the method `userSession.logout` to execute its corresponding logic. |
| 88 | `MainApplication.showLoginScreen();` | Calls the method `MainApplication.showLoginScreen` to execute its corresponding logic. |
| 89 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 90 | *Spacer* | Blank line used as a visual separator for code readability. |
| 91 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 92 | `* Handle expenses button click.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 93 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 94 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 95 | `private void onExpensesClick() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 96 | `MainApplication.showExpensesScreen();` | Calls the method `MainApplication.showExpensesScreen` to execute its corresponding logic. |
| 97 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 98 | *Spacer* | Blank line used as a visual separator for code readability. |
| 99 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 100 | `* Handle budget button click.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 101 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 102 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 103 | `private void onBudgetClick() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 104 | `MainApplication.showBudgetScreen();` | Calls the method `MainApplication.showBudgetScreen` to execute its corresponding logic. |
| 105 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 106 | *Spacer* | Blank line used as a visual separator for code readability. |
| 107 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 108 | `* Handle reports button click.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 109 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 110 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 111 | `private void onReportsClick() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 112 | `MainApplication.showReportsScreen();` | Calls the method `MainApplication.showReportsScreen` to execute its corresponding logic. |
| 113 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 114 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `DashboardController` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
- **Model-View-Controller (MVC) Pattern**: Performs controller view-binding tasks, isolating FXML controls, layout bindings, and visual handlers from computational services.
