# AlertUtil.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.utils`  
**Component Type:** `Class`  
**Description:** UI helper utility wrapping JavaFX Alert APIs to display clean info, warning, and error dialogues uniformly across the system.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Methods & Constructors (Behaviors)
```java
public static void showInfo(String title, String message);
public static void showSuccess(String title, String message);
public static void showError(String title, String message);
public static void showWarning(String title, String message);
public static boolean showConfirmation(String title, String message);
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `AlertUtil.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.utils;` | Declares the package namespace `com.smartbudget.utils` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import javafx.scene.control.Alert;` | Imports `javafx.scene.control.Alert` to make its classes and methods accessible within this file. |
| 4 | `import javafx.scene.control.Alert.AlertType;` | Imports `javafx.scene.control.Alert.AlertType` to make its classes and methods accessible within this file. |
| 5 | `import javafx.scene.control.ButtonType;` | Imports `javafx.scene.control.ButtonType` to make its classes and methods accessible within this file. |
| 6 | `import java.util.Optional;` | Imports `java.util.Optional` to make its classes and methods accessible within this file. |
| 7 | *Spacer* | Blank line used as a visual separator for code readability. |
| 8 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 9 | `* Utility for displaying JavaFX alert dialogs.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 10 | `* Provides convenient methods for showing success, error, warning, and confirmation alerts.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 11 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 12 | `public class AlertUtil {` | Declares the public class `AlertUtil` as a main architectural component of the module. |
| 13 | *Spacer* | Blank line used as a visual separator for code readability. |
| 14 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 15 | `* Show an information alert.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 16 | `* @param title Alert title` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 17 | `* @param message Alert message` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 18 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 19 | `public static void showInfo(String title, String message) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 20 | `Alert alert = new Alert(AlertType.INFORMATION);` | Assigns or computes a value for the variable/field `alert`. |
| 21 | `alert.setTitle(title);` | Calls the method `alert.setTitle` to execute its corresponding logic. |
| 22 | `alert.setHeaderText(null);` | Calls the method `alert.setHeaderText` to execute its corresponding logic. |
| 23 | `alert.setContentText(message);` | Calls the method `alert.setContentText` to execute its corresponding logic. |
| 24 | `alert.showAndWait();` | Calls the method `alert.showAndWait` to execute its corresponding logic. |
| 25 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 26 | *Spacer* | Blank line used as a visual separator for code readability. |
| 27 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 28 | `* Show a success alert.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 29 | `* @param title Alert title` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 30 | `* @param message Success message` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 31 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 32 | `public static void showSuccess(String title, String message) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 33 | `Alert alert = new Alert(AlertType.INFORMATION);` | Assigns or computes a value for the variable/field `alert`. |
| 34 | `alert.setTitle(title);` | Calls the method `alert.setTitle` to execute its corresponding logic. |
| 35 | `alert.setHeaderText("Success");` | Calls the method `alert.setHeaderText` to execute its corresponding logic. |
| 36 | `alert.setContentText(message);` | Calls the method `alert.setContentText` to execute its corresponding logic. |
| 37 | `alert.showAndWait();` | Calls the method `alert.showAndWait` to execute its corresponding logic. |
| 38 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 39 | *Spacer* | Blank line used as a visual separator for code readability. |
| 40 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 41 | `* Show an error alert.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 42 | `* @param title Alert title` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 43 | `* @param message Error message` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 44 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 45 | `public static void showError(String title, String message) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 46 | `Alert alert = new Alert(AlertType.ERROR);` | Assigns or computes a value for the variable/field `alert`. |
| 47 | `alert.setTitle(title);` | Calls the method `alert.setTitle` to execute its corresponding logic. |
| 48 | `alert.setHeaderText("Error");` | Calls the method `alert.setHeaderText` to execute its corresponding logic. |
| 49 | `alert.setContentText(message);` | Calls the method `alert.setContentText` to execute its corresponding logic. |
| 50 | `alert.showAndWait();` | Calls the method `alert.showAndWait` to execute its corresponding logic. |
| 51 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 52 | *Spacer* | Blank line used as a visual separator for code readability. |
| 53 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 54 | `* Show a warning alert.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 55 | `* @param title Alert title` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 56 | `* @param message Warning message` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 57 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 58 | `public static void showWarning(String title, String message) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 59 | `Alert alert = new Alert(AlertType.WARNING);` | Assigns or computes a value for the variable/field `alert`. |
| 60 | `alert.setTitle(title);` | Calls the method `alert.setTitle` to execute its corresponding logic. |
| 61 | `alert.setHeaderText("Warning");` | Calls the method `alert.setHeaderText` to execute its corresponding logic. |
| 62 | `alert.setContentText(message);` | Calls the method `alert.setContentText` to execute its corresponding logic. |
| 63 | `alert.showAndWait();` | Calls the method `alert.showAndWait` to execute its corresponding logic. |
| 64 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 65 | *Spacer* | Blank line used as a visual separator for code readability. |
| 66 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 67 | `* Show a confirmation dialog.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 68 | `* @param title Dialog title` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 69 | `* @param message Confirmation message` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 70 | `* @return true if user clicked OK/Yes, false otherwise` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 71 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 72 | `public static boolean showConfirmation(String title, String message) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 73 | `Alert alert = new Alert(AlertType.CONFIRMATION);` | Assigns or computes a value for the variable/field `alert`. |
| 74 | `alert.setTitle(title);` | Calls the method `alert.setTitle` to execute its corresponding logic. |
| 75 | `alert.setHeaderText(null);` | Calls the method `alert.setHeaderText` to execute its corresponding logic. |
| 76 | `alert.setContentText(message);` | Calls the method `alert.setContentText` to execute its corresponding logic. |
| 77 | *Spacer* | Blank line used as a visual separator for code readability. |
| 78 | `Optional<ButtonType> result = alert.showAndWait();` | Assigns or computes a value for the variable/field `result`. |
| 79 | `return result.isPresent() && result.get() == ButtonType.OK;` | Returns the expression/value `result.isPresent() && result.get() == ButtonType.OK` to the calling method, completing this thread's execution. |
| 80 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 81 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `AlertUtil` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
