# MainApplication.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget`  
**Component Type:** `Class`  
**Description:** Main JavaFX application class loading the login view, setting stylesheets, and bootstrapping the primary stage.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private static Stage primaryStage;
private static final String APP_TITLE = "Smart Budget Management System";
private static final int WINDOW_WIDTH = 900;
private static final int WINDOW_HEIGHT = 600;
```

### Declared Methods & Constructors (Behaviors)
```java
public void start(Stage stage) throws IOException;
public static void showLoginScreen();
public static void showRegisterScreen();
public static void showDashboardScreen();
public static void showExpensesScreen();
public static void showBudgetScreen();
public static void showReportsScreen();
public static Stage getPrimaryStage();
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `MainApplication.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget;` | Declares the package namespace `com.smartbudget` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import java.io.IOException;` | Imports `java.io.IOException` to make its classes and methods accessible within this file. |
| 4 | *Spacer* | Blank line used as a visual separator for code readability. |
| 5 | `import javafx.application.Application;` | Imports `javafx.application.Application` to make its classes and methods accessible within this file. |
| 6 | `import javafx.fxml.FXMLLoader;` | Imports `javafx.fxml.FXMLLoader` to make its classes and methods accessible within this file. |
| 7 | `import javafx.scene.Scene;` | Imports `javafx.scene.Scene` to make its classes and methods accessible within this file. |
| 8 | `import javafx.stage.Stage;` | Imports `javafx.stage.Stage` to make its classes and methods accessible within this file. |
| 9 | *Spacer* | Blank line used as a visual separator for code readability. |
| 10 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 11 | `* Main JavaFX application.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 12 | `* Initializes the window, loads the login screen, and manages scene navigation.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 13 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 14 | `public class MainApplication extends Application {` | Declares the public class `MainApplication` extending `Application` as a main architectural component of the module. |
| 15 | *Spacer* | Blank line used as a visual separator for code readability. |
| 16 | `private static Stage primaryStage;` | Declares a private class-level (static) instance field `primaryStage` of type `Stage` to maintain state with strict encapsulation. |
| 17 | `private static final String APP_TITLE = "Smart Budget Management System";` | Declares a private immutable (final) class-level (static) instance field `APP_TITLE` of type `String` to maintain state with strict encapsulation. |
| 18 | `private static final int WINDOW_WIDTH = 900;` | Declares a private immutable (final) class-level (static) instance field `WINDOW_WIDTH` of type `int` to maintain state with strict encapsulation. |
| 19 | `private static final int WINDOW_HEIGHT = 600;` | Declares a private immutable (final) class-level (static) instance field `WINDOW_HEIGHT` of type `int` to maintain state with strict encapsulation. |
| 20 | *Spacer* | Blank line used as a visual separator for code readability. |
| 21 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 22 | `public void start(Stage stage) throws IOException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 23 | `primaryStage = stage;` | Assigns or computes a value for the variable/field `primaryStage`. |
| 24 | *Spacer* | Blank line used as a visual separator for code readability. |
| 25 | `// Set window properties` | Single-line comment explaining: "Set window properties" |
| 26 | `primaryStage.setTitle(APP_TITLE);` | Calls the method `primaryStage.setTitle` to execute its corresponding logic. |
| 27 | `primaryStage.setWidth(WINDOW_WIDTH);` | Calls the method `primaryStage.setWidth` to execute its corresponding logic. |
| 28 | `primaryStage.setHeight(WINDOW_HEIGHT);` | Calls the method `primaryStage.setHeight` to execute its corresponding logic. |
| 29 | `primaryStage.setResizable(true);` | Calls the method `primaryStage.setResizable` to execute its corresponding logic. |
| 30 | `primaryStage.setOnCloseRequest(e -> {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 31 | `System.out.println("Application closing...");` | Calls the method `System.out.println` to execute its corresponding logic. |
| 32 | `System.exit(0);` | Calls the method `System.exit` to execute its corresponding logic. |
| 33 | `});` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 34 | *Spacer* | Blank line used as a visual separator for code readability. |
| 35 | `// Load and display login screen` | Single-line comment explaining: "Load and display login screen" |
| 36 | `showLoginScreen();` | Calls the method `showLoginScreen` to execute its corresponding logic. |
| 37 | *Spacer* | Blank line used as a visual separator for code readability. |
| 38 | `primaryStage.show();` | Calls the method `primaryStage.show` to execute its corresponding logic. |
| 39 | `System.out.println("✓ Application started");` | Calls the method `System.out.println` to execute its corresponding logic. |
| 40 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 41 | *Spacer* | Blank line used as a visual separator for code readability. |
| 42 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 43 | `* Show login screen.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 44 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 45 | `public static void showLoginScreen() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 46 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 47 | `FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/fxml/login.fxml"));` | Assigns or computes a value for the variable/field `loader`. |
| 48 | `Scene scene = new Scene(loader.load());` | Assigns or computes a value for the variable/field `scene`. |
| 49 | `scene.getStylesheets().add(MainApplication.class.getResource("/css/app.css").toExternalForm());` | Calls the method `scene.getStylesheets` to execute its corresponding logic. |
| 50 | `primaryStage.setScene(scene);` | Calls the method `primaryStage.setScene` to execute its corresponding logic. |
| 51 | `} catch (IOException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 52 | `System.err.println("Error loading login screen: " + e.getMessage());` | Calls the method `System.err.println` to execute its corresponding logic. |
| 53 | `e.printStackTrace();` | Calls the method `e.printStackTrace` to execute its corresponding logic. |
| 54 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 55 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 56 | *Spacer* | Blank line used as a visual separator for code readability. |
| 57 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 58 | `* Show register screen.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 59 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 60 | `public static void showRegisterScreen() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 61 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 62 | `FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/fxml/register.fxml"));` | Assigns or computes a value for the variable/field `loader`. |
| 63 | `Scene scene = new Scene(loader.load());` | Assigns or computes a value for the variable/field `scene`. |
| 64 | `scene.getStylesheets().add(MainApplication.class.getResource("/css/app.css").toExternalForm());` | Calls the method `scene.getStylesheets` to execute its corresponding logic. |
| 65 | `primaryStage.setScene(scene);` | Calls the method `primaryStage.setScene` to execute its corresponding logic. |
| 66 | `} catch (IOException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 67 | `System.err.println("Error loading register screen: " + e.getMessage());` | Calls the method `System.err.println` to execute its corresponding logic. |
| 68 | `e.printStackTrace();` | Calls the method `e.printStackTrace` to execute its corresponding logic. |
| 69 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 70 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 71 | *Spacer* | Blank line used as a visual separator for code readability. |
| 72 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 73 | `* Show dashboard screen.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 74 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 75 | `public static void showDashboardScreen() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 76 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 77 | `FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/fxml/dashboard.fxml"));` | Assigns or computes a value for the variable/field `loader`. |
| 78 | `Scene scene = new Scene(loader.load());` | Assigns or computes a value for the variable/field `scene`. |
| 79 | `scene.getStylesheets().add(MainApplication.class.getResource("/css/app.css").toExternalForm());` | Calls the method `scene.getStylesheets` to execute its corresponding logic. |
| 80 | `primaryStage.setScene(scene);` | Calls the method `primaryStage.setScene` to execute its corresponding logic. |
| 81 | `} catch (IOException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 82 | `System.err.println("Error loading dashboard screen: " + e.getMessage());` | Calls the method `System.err.println` to execute its corresponding logic. |
| 83 | `e.printStackTrace();` | Calls the method `e.printStackTrace` to execute its corresponding logic. |
| 84 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 85 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 86 | *Spacer* | Blank line used as a visual separator for code readability. |
| 87 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 88 | `* Show expenses screen.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 89 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 90 | `public static void showExpensesScreen() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 91 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 92 | `FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/fxml/expenses.fxml"));` | Assigns or computes a value for the variable/field `loader`. |
| 93 | `Scene scene = new Scene(loader.load());` | Assigns or computes a value for the variable/field `scene`. |
| 94 | `scene.getStylesheets().add(MainApplication.class.getResource("/css/app.css").toExternalForm());` | Calls the method `scene.getStylesheets` to execute its corresponding logic. |
| 95 | `primaryStage.setScene(scene);` | Calls the method `primaryStage.setScene` to execute its corresponding logic. |
| 96 | `} catch (IOException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 97 | `System.err.println("Error loading expenses screen: " + e.getMessage());` | Calls the method `System.err.println` to execute its corresponding logic. |
| 98 | `e.printStackTrace();` | Calls the method `e.printStackTrace` to execute its corresponding logic. |
| 99 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 100 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 101 | *Spacer* | Blank line used as a visual separator for code readability. |
| 102 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 103 | `* Show budget screen.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 104 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 105 | `public static void showBudgetScreen() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 106 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 107 | `FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/fxml/budget.fxml"));` | Assigns or computes a value for the variable/field `loader`. |
| 108 | `Scene scene = new Scene(loader.load());` | Assigns or computes a value for the variable/field `scene`. |
| 109 | `scene.getStylesheets().add(MainApplication.class.getResource("/css/app.css").toExternalForm());` | Calls the method `scene.getStylesheets` to execute its corresponding logic. |
| 110 | `primaryStage.setScene(scene);` | Calls the method `primaryStage.setScene` to execute its corresponding logic. |
| 111 | `} catch (IOException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 112 | `System.err.println("Error loading budget screen: " + e.getMessage());` | Calls the method `System.err.println` to execute its corresponding logic. |
| 113 | `e.printStackTrace();` | Calls the method `e.printStackTrace` to execute its corresponding logic. |
| 114 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 115 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 116 | *Spacer* | Blank line used as a visual separator for code readability. |
| 117 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 118 | `* Show reports screen.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 119 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 120 | `public static void showReportsScreen() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 121 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 122 | `FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/fxml/reports.fxml"));` | Assigns or computes a value for the variable/field `loader`. |
| 123 | `Scene scene = new Scene(loader.load());` | Assigns or computes a value for the variable/field `scene`. |
| 124 | `scene.getStylesheets().add(MainApplication.class.getResource("/css/app.css").toExternalForm());` | Calls the method `scene.getStylesheets` to execute its corresponding logic. |
| 125 | `primaryStage.setScene(scene);` | Calls the method `primaryStage.setScene` to execute its corresponding logic. |
| 126 | `} catch (IOException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 127 | `System.err.println("Error loading reports screen: " + e.getMessage());` | Calls the method `System.err.println` to execute its corresponding logic. |
| 128 | `e.printStackTrace();` | Calls the method `e.printStackTrace` to execute its corresponding logic. |
| 129 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 130 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 131 | *Spacer* | Blank line used as a visual separator for code readability. |
| 132 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 133 | `* Get primary stage for custom operations.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 134 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 135 | `public static Stage getPrimaryStage() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 136 | `return primaryStage;` | Returns the expression/value `primaryStage` to the calling method, completing this thread's execution. |
| 137 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 138 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `MainApplication` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
