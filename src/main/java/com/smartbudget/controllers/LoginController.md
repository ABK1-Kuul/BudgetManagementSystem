# LoginController.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.controllers`  
**Component Type:** `Class`  
**Description:** UI controller handling the login screen, authenticating user input against AuthService, and coordinating screen navigation.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private TextField usernameField;
private PasswordField passwordField;
private Label errorLabel;
private Button loginButton;
private AuthService authService;
```

### Declared Methods & Constructors (Behaviors)
```java
public void initialize();
private void onLoginClick();
private void onRegisterClick();
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `LoginController.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.controllers;` | Declares the package namespace `com.smartbudget.controllers` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import com.smartbudget.MainApplication;` | Imports `com.smartbudget.MainApplication` to make its classes and methods accessible within this file. |
| 4 | `import com.smartbudget.exceptions.DatabaseException;` | Imports `com.smartbudget.exceptions.DatabaseException` to make its classes and methods accessible within this file. |
| 5 | `import com.smartbudget.exceptions.ValidationException;` | Imports `com.smartbudget.exceptions.ValidationException` to make its classes and methods accessible within this file. |
| 6 | `import com.smartbudget.models.User;` | Imports `com.smartbudget.models.User` to make its classes and methods accessible within this file. |
| 7 | `import com.smartbudget.services.AuthService;` | Imports `com.smartbudget.services.AuthService` to make its classes and methods accessible within this file. |
| 8 | `import com.smartbudget.utils.AlertUtil;` | Imports `com.smartbudget.utils.AlertUtil` to make its classes and methods accessible within this file. |
| 9 | *Spacer* | Blank line used as a visual separator for code readability. |
| 10 | `import javafx.fxml.FXML;` | Imports `javafx.fxml.FXML` to make its classes and methods accessible within this file. |
| 11 | `import javafx.scene.control.Button;` | Imports `javafx.scene.control.Button` to make its classes and methods accessible within this file. |
| 12 | `import javafx.scene.control.Label;` | Imports `javafx.scene.control.Label` to make its classes and methods accessible within this file. |
| 13 | `import javafx.scene.control.PasswordField;` | Imports `javafx.scene.control.PasswordField` to make its classes and methods accessible within this file. |
| 14 | `import javafx.scene.control.TextField;` | Imports `javafx.scene.control.TextField` to make its classes and methods accessible within this file. |
| 15 | *Spacer* | Blank line used as a visual separator for code readability. |
| 16 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 17 | `* Controller for login screen.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 18 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 19 | `public class LoginController {` | Declares the public class `LoginController` as a main architectural component of the module. |
| 20 | *Spacer* | Blank line used as a visual separator for code readability. |
| 21 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 22 | `private TextField usernameField;` | Declares a private instance field `usernameField` of type `TextField` to maintain state with strict encapsulation. |
| 23 | *Spacer* | Blank line used as a visual separator for code readability. |
| 24 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 25 | `private PasswordField passwordField;` | Declares a private instance field `passwordField` of type `PasswordField` to maintain state with strict encapsulation. |
| 26 | *Spacer* | Blank line used as a visual separator for code readability. |
| 27 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 28 | `private Label errorLabel;` | Declares a private instance field `errorLabel` of type `Label` to maintain state with strict encapsulation. |
| 29 | *Spacer* | Blank line used as a visual separator for code readability. |
| 30 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 31 | `private Button loginButton;` | Declares a private instance field `loginButton` of type `Button` to maintain state with strict encapsulation. |
| 32 | *Spacer* | Blank line used as a visual separator for code readability. |
| 33 | `private AuthService authService;` | Declares a private instance field `authService` of type `AuthService` to maintain state with strict encapsulation. |
| 34 | *Spacer* | Blank line used as a visual separator for code readability. |
| 35 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 36 | `* Initialize controller.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 37 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 38 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 39 | `public void initialize() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 40 | `authService = new AuthService();` | Assigns or computes a value for the variable/field `authService`. |
| 41 | `errorLabel.setText("");` | Calls the method `errorLabel.setText` to execute its corresponding logic. |
| 42 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 43 | *Spacer* | Blank line used as a visual separator for code readability. |
| 44 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 45 | `* Handle login button click.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 46 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 47 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 48 | `private void onLoginClick() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 49 | `String username = usernameField.getText().trim();` | Assigns or computes a value for the variable/field `username`. |
| 50 | `String password = passwordField.getText();` | Assigns or computes a value for the variable/field `password`. |
| 51 | *Spacer* | Blank line used as a visual separator for code readability. |
| 52 | `// Clear previous errors` | Single-line comment explaining: "Clear previous errors" |
| 53 | `errorLabel.setText("");` | Calls the method `errorLabel.setText` to execute its corresponding logic. |
| 54 | *Spacer* | Blank line used as a visual separator for code readability. |
| 55 | `// Validate inputs` | Single-line comment explaining: "Validate inputs" |
| 56 | `if (username.isEmpty()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 57 | `errorLabel.setText("Username cannot be empty.");` | Calls the method `errorLabel.setText` to execute its corresponding logic. |
| 58 | `return;` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 59 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 60 | `if (password.isEmpty()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 61 | `errorLabel.setText("Password cannot be empty.");` | Calls the method `errorLabel.setText` to execute its corresponding logic. |
| 62 | `return;` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 63 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 64 | *Spacer* | Blank line used as a visual separator for code readability. |
| 65 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 66 | `// Attempt login` | Single-line comment explaining: "Attempt login" |
| 67 | `User user = authService.login(username, password);` | Assigns or computes a value for the variable/field `user`. |
| 68 | `AlertUtil.showSuccess("Login Successful", "Welcome, " + user.getUsername() + "!");` | Calls the method `AlertUtil.showSuccess` to execute its corresponding logic. |
| 69 | `// Navigate to dashboard` | Single-line comment explaining: "Navigate to dashboard" |
| 70 | `MainApplication.showDashboardScreen();` | Calls the method `MainApplication.showDashboardScreen` to execute its corresponding logic. |
| 71 | `} catch (ValidationException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 72 | `errorLabel.setText(e.getMessage());` | Calls the method `errorLabel.setText` to execute its corresponding logic. |
| 73 | `} catch (DatabaseException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 74 | `errorLabel.setText("Database error: " + e.getMessage());` | Calls the method `errorLabel.setText` to execute its corresponding logic. |
| 75 | `System.err.println(e.getMessage());` | Calls the method `System.err.println` to execute its corresponding logic. |
| 76 | `e.printStackTrace();` | Calls the method `e.printStackTrace` to execute its corresponding logic. |
| 77 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 78 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 79 | *Spacer* | Blank line used as a visual separator for code readability. |
| 80 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 81 | `* Handle register hyperlink click.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 82 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 83 | `@FXML` | JavaFX FXML annotation marking this component as linked to a visual component defined in the UI layout file. |
| 84 | `private void onRegisterClick() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 85 | `MainApplication.showRegisterScreen();` | Calls the method `MainApplication.showRegisterScreen` to execute its corresponding logic. |
| 86 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 87 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `LoginController` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
- **Model-View-Controller (MVC) Pattern**: Performs controller view-binding tasks, isolating FXML controls, layout bindings, and visual handlers from computational services.
