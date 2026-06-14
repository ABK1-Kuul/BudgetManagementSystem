# login.fxml - Detailed UI Explanation & Bindings

## 📌 Overview & Screen Role
**View Name:** `login.fxml`  
**Linked Controller:** `com.smartbudget.controllers.LoginController`  
**Description:** Visual layout template (FXML) defining the UI screen structure and bindings for the `login` view in the Budget Management System.

This FXML document designs the user-facing layouts, inputs, tables, and interaction points for this specific sub-view. It is styled with external CSS sheets and binds directly to the JavaFX controller class `com.smartbudget.controllers.LoginController` to bridge user events with Java services.

## 🔍 Line-by-Line Tag and Attribute Analysis

Below is a comprehensive tag-by-tag and attribute-by-attribute breakdown mapping each FXML design line to its visual layout purpose:

| Line # | FXML Design Line | Visual and Controller Binding Role |
| :--- | :--- | :--- |
| 1 | `<?xml version="1.0" encoding="UTF-8"?>` | Defines the XML version and document encoding (UTF-8) for compatibility parsing. |
| 2 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 3 | `<?import javafx.geometry.Insets?>` | Imports the `javafx.geometry.Insets` class into the FXML namespace, allowing the GUI runtime to instantiate it. |
| 4 | `<?import javafx.scene.control.*?>` | Imports the `javafx.scene.control.*` class into the FXML namespace, allowing the GUI runtime to instantiate it. |
| 5 | `<?import javafx.scene.layout.*?>` | Imports the `javafx.scene.layout.*` class into the FXML namespace, allowing the GUI runtime to instantiate it. |
| 6 | `<?import javafx.scene.text.Font?>` | Imports the `javafx.scene.text.Font` class into the FXML namespace, allowing the GUI runtime to instantiate it. |
| 7 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 8 | `<BorderPane xmlns="http://javafx.com/javafx" xmlns:fx="http://javafx.com/fxml" fx:controller="com.smartbudget.controllers.LoginController" prefWidth="900" prefHeight="600">` | BorderPane layout container arranging content in five regions: top, bottom, left, right, and center. |
| 9 | `<center>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 10 | `<VBox alignment="CENTER" spacing="20" style="-fx-padding: 50;">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 11 | `<!-- Title -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 12 | `<Label text="Smart Budget Manager" style="-fx-font-size: 32; -fx-font-weight: bold; -fx-text-fill: #2c3e50;">` | Renders a standard read-only Label text label displaying text 'Smart Budget Manager'. |
| 13 | `<VBox.margin>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 14 | `<Insets bottom="20" />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 15 | `</VBox.margin>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 16 | `</Label>` | Renders a standard read-only Label text label. |
| 17 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 18 | `<!-- Subtitle -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 19 | `<Label text="Login to your account" style="-fx-font-size: 14; -fx-text-fill: #7f8c8d;">` | Renders a standard read-only Label text label displaying text 'Login to your account'. |
| 20 | `<VBox.margin>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 21 | `<Insets bottom="30" />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 22 | `</VBox.margin>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 23 | `</Label>` | Renders a standard read-only Label text label. |
| 24 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 25 | `<!-- Login Form -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 26 | `<VBox spacing="15" maxWidth="350" style="-fx-border-color: #ecf0f1; -fx-border-width: 1; -fx-border-radius: 5; -fx-padding: 30; -fx-style-class: 'form-container';">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 27 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 28 | `<!-- Username Field -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 29 | `<VBox spacing="5">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 30 | `<Label text="Username" style="-fx-font-weight: bold;">` | Renders a standard read-only Label text label displaying text 'Username'. |
| 31 | `<font>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 32 | `<Font size="12" />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 33 | `</font>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 34 | `</Label>` | Renders a standard read-only Label text label. |
| 35 | `<TextField fx:id="usernameField" promptText="Enter your username" />` | Renders a single-line TextField text input field with prompt text 'Enter your username'. |
| 36 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 37 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 38 | `<!-- Password Field -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 39 | `<VBox spacing="5">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 40 | `<Label text="Password" style="-fx-font-weight: bold;">` | Renders a standard read-only Label text label displaying text 'Password'. |
| 41 | `<font>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 42 | `<Font size="12" />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 43 | `</font>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 44 | `</Label>` | Renders a standard read-only Label text label. |
| 45 | `<PasswordField fx:id="passwordField" promptText="Enter your password" />` | Renders a masked PasswordField input element for entering passwords securely with prompt text 'Enter your password'. |
| 46 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 47 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 48 | `<!-- Error Message -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 49 | `<Label fx:id="errorLabel" style="-fx-text-fill: #e74c3c;" wrapText="true">` | Renders a standard read-only Label text label. |
| 50 | `<VBox.margin>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 51 | `<Insets top="10" />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 52 | `</VBox.margin>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 53 | `</Label>` | Renders a standard read-only Label text label. |
| 54 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 55 | `<!-- Login Button -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 56 | `<Button fx:id="loginButton" text="Login" style="-fx-font-size: 14; -fx-padding: 10; -fx-font-weight: bold;" onAction="#onLoginClick">` | Renders an interactive Button component labeled 'Login' bound to trigger `onLoginClick()`. |
| 57 | `<VBox.margin>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 58 | `<Insets top="15" />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 59 | `</VBox.margin>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 60 | `</Button>` | Renders an interactive Button component. |
| 61 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 62 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 63 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 64 | `<!-- Register Link -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 65 | `<HBox alignment="CENTER" spacing="5">` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 66 | `<Label text="Don't have an account?" />` | Renders a standard read-only Label text label displaying text 'Don't have an account?'. |
| 67 | `<Hyperlink text="Register here" onAction="#onRegisterClick" style="-fx-font-size: 12;" />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 68 | `</HBox>` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 69 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 70 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 71 | `</center>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 72 | `</BorderPane>` | BorderPane layout container arranging content in five regions: top, bottom, left, right, and center. |
| 73 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |


## 🎨 UI/UX Component & Design Standards

This design file represents standard enterprise-level desktop app UI patterns:

- **Separation of Concerns**: Declares the layout cleanly in XML format while leaving backing interactive calculations to its Java Controller, isolating view definitions from operational calculations.
- **Flexible Grid & Box Layouts**: Relies heavily on combinations of `VBox`, `HBox`, and `GridPane` containers to automatically size controls across different resolution screens.
- **Event Binding**: Connects interactive nodes (Buttons, ComboBoxes) directly to handler methods defined in the controller, maximizing thread execution flow control.
