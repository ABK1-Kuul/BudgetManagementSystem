# dashboard.fxml - Detailed UI Explanation & Bindings

## 📌 Overview & Screen Role
**View Name:** `dashboard.fxml`  
**Linked Controller:** `com.smartbudget.controllers.DashboardController`  
**Description:** Visual layout template (FXML) defining the UI screen structure and bindings for the `dashboard` view in the Budget Management System.

This FXML document designs the user-facing layouts, inputs, tables, and interaction points for this specific sub-view. It is styled with external CSS sheets and binds directly to the JavaFX controller class `com.smartbudget.controllers.DashboardController` to bridge user events with Java services.

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
| 8 | `<BorderPane xmlns="http://javafx.com/javafx" xmlns:fx="http://javafx.com/fxml" fx:controller="com.smartbudget.controllers.DashboardController" prefWidth="900" prefHeight="600">` | BorderPane layout container arranging content in five regions: top, bottom, left, right, and center. |
| 9 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 10 | `<!-- Top Bar -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 11 | `<top>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 12 | `<HBox spacing="20" style="-fx-background-color: #2c3e50; -fx-padding: 15;" alignment="CENTER_RIGHT">` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 13 | `<Label fx:id="welcomeLabel" text="Welcome!" style="-fx-text-fill: white; -fx-font-size: 14; -fx-font-weight: bold;" HBox.hgrow="ALWAYS" />` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 14 | `<Button text="Logout" onAction="#onLogoutClick" style="-fx-font-size: 12; -fx-padding: 8;" />` | Renders an interactive Button component labeled 'Logout' bound to trigger `onLogoutClick()`. |
| 15 | `</HBox>` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 16 | `</top>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 17 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 18 | `<!-- Left Navigation -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 19 | `<left>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 20 | `<VBox spacing="10" style="-fx-background-color: #ecf0f1; -fx-padding: 20; -fx-min-width: 150;" alignment="TOP_CENTER">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 21 | `<Label text="Menu" style="-fx-font-weight: bold; -fx-font-size: 14;">` | Renders a standard read-only Label text label displaying text 'Menu'. |
| 22 | `<VBox.margin>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 23 | `<Insets bottom="15" />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 24 | `</VBox.margin>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 25 | `</Label>` | Renders a standard read-only Label text label. |
| 26 | `<Button text="Dashboard" style="-fx-max-width: Infinity;" disable="true" />` | Renders an interactive Button component labeled 'Dashboard'. |
| 27 | `<Button text="Expenses" onAction="#onExpensesClick" style="-fx-max-width: Infinity;" />` | Renders an interactive Button component labeled 'Expenses' bound to trigger `onExpensesClick()`. |
| 28 | `<Button text="Budget" onAction="#onBudgetClick" style="-fx-max-width: Infinity;" />` | Renders an interactive Button component labeled 'Budget' bound to trigger `onBudgetClick()`. |
| 29 | `<Button text="Reports" onAction="#onReportsClick" style="-fx-max-width: Infinity;" />` | Renders an interactive Button component labeled 'Reports' bound to trigger `onReportsClick()`. |
| 30 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 31 | `</left>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 32 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 33 | `<!-- Main Content -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 34 | `<center>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 35 | `<ScrollPane fitToWidth="true" fitToHeight="true">` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 36 | `<VBox spacing="20" style="-fx-padding: 30;">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 37 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 38 | `<!-- Title -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 39 | `<Label text="Dashboard" style="-fx-font-size: 28; -fx-font-weight: bold; -fx-text-fill: #2c3e50;" />` | Renders a standard read-only Label text label displaying text 'Dashboard'. |
| 40 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 41 | `<!-- Summary Cards -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 42 | `<HBox spacing="20">` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 43 | `<!-- Total Income Card -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 44 | `<VBox spacing="10" style="-fx-border-color: #3498db; -fx-border-width: 1; -fx-border-radius: 5; -fx-padding: 20; -fx-max-width: 200;">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 45 | `<Label text="Total Income" style="-fx-font-weight: bold; -fx-text-fill: #2c3e50;" />` | Renders a standard read-only Label text label displaying text 'Total Income'. |
| 46 | `<Label fx:id="totalIncomeLabel" text="0.00" style="-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #27ae60;" />` | Renders a standard read-only Label text label displaying text '0.00'. |
| 47 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 48 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 49 | `<!-- Total Expenses Card -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 50 | `<VBox spacing="10" style="-fx-border-color: #e74c3c; -fx-border-width: 1; -fx-border-radius: 5; -fx-padding: 20; -fx-max-width: 200;">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 51 | `<Label text="Total Expenses" style="-fx-font-weight: bold; -fx-text-fill: #2c3e50;" />` | Renders a standard read-only Label text label displaying text 'Total Expenses'. |
| 52 | `<Label fx:id="totalExpensesLabel" text="0.00" style="-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #e74c3c;" />` | Renders a standard read-only Label text label displaying text '0.00'. |
| 53 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 54 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 55 | `<!-- Balance Card -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 56 | `<VBox spacing="10" style="-fx-border-color: #9b59b6; -fx-border-width: 1; -fx-border-radius: 5; -fx-padding: 20; -fx-max-width: 200;">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 57 | `<Label text="Balance" style="-fx-font-weight: bold; -fx-text-fill: #2c3e50;" />` | Renders a standard read-only Label text label displaying text 'Balance'. |
| 58 | `<Label fx:id="balanceLabel" text="0.00" style="-fx-font-size: 20; -fx-font-weight: bold; -fx-text-fill: #9b59b6;" />` | Renders a standard read-only Label text label displaying text '0.00'. |
| 59 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 60 | `</HBox>` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 61 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 62 | `<!-- Quick Info -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 63 | `<Label text="Overview information will appear here." style="-fx-font-size: 14; -fx-text-fill: #7f8c8d; -fx-padding: 20;" />` | Renders a standard read-only Label text label displaying text 'Overview information will appear here.'. |
| 64 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 65 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 66 | `</ScrollPane>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 67 | `</center>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 68 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 69 | `</BorderPane>` | BorderPane layout container arranging content in five regions: top, bottom, left, right, and center. |
| 70 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |


## 🎨 UI/UX Component & Design Standards

This design file represents standard enterprise-level desktop app UI patterns:

- **Separation of Concerns**: Declares the layout cleanly in XML format while leaving backing interactive calculations to its Java Controller, isolating view definitions from operational calculations.
- **Flexible Grid & Box Layouts**: Relies heavily on combinations of `VBox`, `HBox`, and `GridPane` containers to automatically size controls across different resolution screens.
- **Event Binding**: Connects interactive nodes (Buttons, ComboBoxes) directly to handler methods defined in the controller, maximizing thread execution flow control.
