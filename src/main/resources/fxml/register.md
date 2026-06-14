# register.fxml - Detailed UI Explanation & Bindings

## 📌 Overview & Screen Role
**View Name:** `register.fxml`  
**Linked Controller:** `com.smartbudget.controllers.RegisterController`  
**Description:** Visual layout template (FXML) defining the UI screen structure and bindings for the `register` view in the Budget Management System.

This FXML document designs the user-facing layouts, inputs, tables, and interaction points for this specific sub-view. It is styled with external CSS sheets and binds directly to the JavaFX controller class `com.smartbudget.controllers.RegisterController` to bridge user events with Java services.

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
| 8 | `<BorderPane xmlns="http://javafx.com/javafx" xmlns:fx="http://javafx.com/fxml" fx:controller="com.smartbudget.controllers.RegisterController" prefWidth="900" prefHeight="600">` | BorderPane layout container arranging content in five regions: top, bottom, left, right, and center. |
| 9 | `<center>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 10 | `<VBox alignment="TOP_CENTER" spacing="20" style="-fx-padding: 40;">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 11 | `<!-- Title -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 12 | `<Label text="Create New Account" style="-fx-font-size: 32; -fx-font-weight: bold; -fx-text-fill: #2c3e50;">` | Renders a standard read-only Label text label displaying text 'Create New Account'. |
| 13 | `<VBox.margin>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 14 | `<Insets bottom="20" />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 15 | `</VBox.margin>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 16 | `</Label>` | Renders a standard read-only Label text label. |
| 17 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 18 | `<!-- Registration Form -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 19 | `<VBox spacing="15" maxWidth="350" style="-fx-border-color: #ecf0f1; -fx-border-width: 1; -fx-border-radius: 5; -fx-padding: 30;">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 20 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 21 | `<!-- Username Field -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 22 | `<VBox spacing="5">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 23 | `<Label text="Username" style="-fx-font-weight: bold;">` | Renders a standard read-only Label text label displaying text 'Username'. |
| 24 | `<font>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 25 | `<Font size="12" />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 26 | `</font>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 27 | `</Label>` | Renders a standard read-only Label text label. |
| 28 | `<TextField fx:id="usernameField" promptText="Choose a username" />` | Renders a single-line TextField text input field with prompt text 'Choose a username'. |
| 29 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 30 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 31 | `<!-- Email Field -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 32 | `<VBox spacing="5">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 33 | `<Label text="Email" style="-fx-font-weight: bold;">` | Renders a standard read-only Label text label displaying text 'Email'. |
| 34 | `<font>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 35 | `<Font size="12" />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 36 | `</font>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 37 | `</Label>` | Renders a standard read-only Label text label. |
| 38 | `<TextField fx:id="emailField" promptText="Enter your email" />` | Renders a single-line TextField text input field with prompt text 'Enter your email'. |
| 39 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 40 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 41 | `<!-- Password Field -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 42 | `<VBox spacing="5">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 43 | `<Label text="Password" style="-fx-font-weight: bold;">` | Renders a standard read-only Label text label displaying text 'Password'. |
| 44 | `<font>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 45 | `<Font size="12" />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 46 | `</font>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 47 | `</Label>` | Renders a standard read-only Label text label. |
| 48 | `<PasswordField fx:id="passwordField" promptText="Create a password (min 6 chars)" />` | Renders a masked PasswordField input element for entering passwords securely with prompt text 'Create a password (min 6 chars)'. |
| 49 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 50 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 51 | `<!-- Confirm Password Field -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 52 | `<VBox spacing="5">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 53 | `<Label text="Confirm Password" style="-fx-font-weight: bold;">` | Renders a standard read-only Label text label displaying text 'Confirm Password'. |
| 54 | `<font>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 55 | `<Font size="12" />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 56 | `</font>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 57 | `</Label>` | Renders a standard read-only Label text label. |
| 58 | `<PasswordField fx:id="confirmPasswordField" promptText="Confirm your password" />` | Renders a masked PasswordField input element for entering passwords securely with prompt text 'Confirm your password'. |
| 59 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 60 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 61 | `<!-- Error Message -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 62 | `<Label fx:id="errorLabel" style="-fx-text-fill: #e74c3c;" wrapText="true">` | Renders a standard read-only Label text label. |
| 63 | `<VBox.margin>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 64 | `<Insets top="10" />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 65 | `</VBox.margin>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 66 | `</Label>` | Renders a standard read-only Label text label. |
| 67 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 68 | `<!-- Register Button -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 69 | `<Button fx:id="registerButton" text="Register" style="-fx-font-size: 14; -fx-padding: 10; -fx-font-weight: bold;" onAction="#onRegisterClick">` | Renders an interactive Button component labeled 'Register' bound to trigger `onRegisterClick()`. |
| 70 | `<VBox.margin>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 71 | `<Insets top="15" />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 72 | `</VBox.margin>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 73 | `</Button>` | Renders an interactive Button component. |
| 74 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 75 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 76 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 77 | `<!-- Back to Login Link -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 78 | `<HBox alignment="CENTER" spacing="5">` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 79 | `<Label text="Already have an account?" />` | Renders a standard read-only Label text label displaying text 'Already have an account?'. |
| 80 | `<Hyperlink text="Back to login" onAction="#onBackClick" style="-fx-font-size: 12;" />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 81 | `</HBox>` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 82 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 83 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 84 | `</center>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 85 | `</BorderPane>` | BorderPane layout container arranging content in five regions: top, bottom, left, right, and center. |
| 86 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |


## 🎨 UI/UX Component & Design Standards

This design file represents standard enterprise-level desktop app UI patterns:

- **Separation of Concerns**: Declares the layout cleanly in XML format while leaving backing interactive calculations to its Java Controller, isolating view definitions from operational calculations.
- **Flexible Grid & Box Layouts**: Relies heavily on combinations of `VBox`, `HBox`, and `GridPane` containers to automatically size controls across different resolution screens.
- **Event Binding**: Connects interactive nodes (Buttons, ComboBoxes) directly to handler methods defined in the controller, maximizing thread execution flow control.
