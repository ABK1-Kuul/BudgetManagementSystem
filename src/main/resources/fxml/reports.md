# reports.fxml - Detailed UI Explanation & Bindings

## 📌 Overview & Screen Role
**View Name:** `reports.fxml`  
**Linked Controller:** `com.smartbudget.controllers.ReportController`  
**Description:** Visual layout template (FXML) defining the UI screen structure and bindings for the `reports` view in the Budget Management System.

This FXML document designs the user-facing layouts, inputs, tables, and interaction points for this specific sub-view. It is styled with external CSS sheets and binds directly to the JavaFX controller class `com.smartbudget.controllers.ReportController` to bridge user events with Java services.

## 🔍 Line-by-Line Tag and Attribute Analysis

Below is a comprehensive tag-by-tag and attribute-by-attribute breakdown mapping each FXML design line to its visual layout purpose:

| Line # | FXML Design Line | Visual and Controller Binding Role |
| :--- | :--- | :--- |
| 1 | `<?xml version="1.0" encoding="UTF-8"?>` | Defines the XML version and document encoding (UTF-8) for compatibility parsing. |
| 2 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 3 | `<?import javafx.geometry.Insets?>` | Imports the `javafx.geometry.Insets` class into the FXML namespace, allowing the GUI runtime to instantiate it. |
| 4 | `<?import javafx.scene.chart.PieChart?>` | Imports the `javafx.scene.chart.PieChart` class into the FXML namespace, allowing the GUI runtime to instantiate it. |
| 5 | `<?import javafx.scene.control.*?>` | Imports the `javafx.scene.control.*` class into the FXML namespace, allowing the GUI runtime to instantiate it. |
| 6 | `<?import javafx.scene.layout.*?>` | Imports the `javafx.scene.layout.*` class into the FXML namespace, allowing the GUI runtime to instantiate it. |
| 7 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 8 | `<BorderPane xmlns="http://javafx.com/javafx" xmlns:fx="http://javafx.com/fxml" fx:controller="com.smartbudget.controllers.ReportController" prefWidth="900" prefHeight="600">` | BorderPane layout container arranging content in five regions: top, bottom, left, right, and center. |
| 9 | `<!-- Top Nav Bar -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 10 | `<top>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 11 | `<HBox spacing="10" style="-fx-background-color: #2c3e50; -fx-padding: 15;" alignment="CENTER_LEFT">` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 12 | `<Label text="Financial Reports" style="-fx-text-fill: white; -fx-font-size: 18; -fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text 'Financial Reports'. |
| 13 | `<Region HBox.hgrow="ALWAYS" />` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 14 | `<Button text="Back to Dashboard" onAction="#onBackClick" style="-fx-font-size: 12; -fx-padding: 8; -fx-font-weight: bold; -fx-background-color: #34495e; -fx-text-fill: white;" />` | Renders an interactive Button component labeled 'Back to Dashboard' bound to trigger `onBackClick()`. |
| 15 | `</HBox>` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 16 | `</top>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 17 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 18 | `<!-- Main Content Area -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 19 | `<center>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 20 | `<SplitPane dividerPositions="0.4" style="-fx-background-color: white;">` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 21 | `<!-- Left Side: Summary Metrics -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 22 | `<items>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 23 | `<VBox spacing="20" style="-fx-padding: 30; -fx-background-color: #f8f9fa;">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 24 | `<Label text="Report Summary" style="-fx-font-size: 18; -fx-font-weight: bold; -fx-text-fill: #2c3e50;" />` | Renders a standard read-only Label text label displaying text 'Report Summary'. |
| 25 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 26 | `<Separator />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 27 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 28 | `<VBox spacing="10">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 29 | `<Label text="Income vs. Spending" style="-fx-font-weight: bold; -fx-font-size: 14; -fx-text-fill: #7f8c8d;" />` | Renders a standard read-only Label text label displaying text 'Income vs. Spending'. |
| 30 | `<HBox alignment="CENTER_LEFT" spacing="10">` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 31 | `<Label text="Total Income:" prefWidth="120" style="-fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text 'Total Income:'. |
| 32 | `<Label fx:id="reportIncomeLabel" text="0.00" style="-fx-text-fill: #27ae60; -fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text '0.00'. |
| 33 | `</HBox>` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 34 | `<HBox alignment="CENTER_LEFT" spacing="10">` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 35 | `<Label text="Total Spending:" prefWidth="120" style="-fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text 'Total Spending:'. |
| 36 | `<Label fx:id="reportExpenseLabel" text="0.00" style="-fx-text-fill: #e74c3c; -fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text '0.00'. |
| 37 | `</HBox>` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 38 | `<HBox alignment="CENTER_LEFT" spacing="10">` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 39 | `<Label text="Net Savings:" prefWidth="120" style="-fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text 'Net Savings:'. |
| 40 | `<Label fx:id="reportSavingsLabel" text="0.00" style="-fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text '0.00'. |
| 41 | `</HBox>` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 42 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 43 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 44 | `<Separator />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 45 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 46 | `<VBox spacing="10" VBox.vgrow="ALWAYS">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 47 | `<Label text="Academic OOP Highlight" style="-fx-font-weight: bold; -fx-font-size: 14; -fx-text-fill: #2980b9;" />` | Renders a standard read-only Label text label displaying text 'Academic OOP Highlight'. |
| 48 | `<TextArea editable="false" wrapText="true" style="-fx-font-size: 11; -fx-text-fill: #555;" VBox.vgrow="ALWAYS" text="This reporting engine demonstrates several core OOP concepts:&#10;&#10;1. POLYMORPHISM: It aggregates custom transaction entities (Expense, Income) polymorphically into a single list and calls overridden methods.&#10;&#10;2. ENCAPSULATION: Models are fully encapsulated, exposing data securely through getters and guarding properties using validated setters." />` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 49 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 50 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 51 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 52 | `<!-- Right Side: Pie Chart representation of Expenses -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 53 | `<VBox spacing="10" style="-fx-padding: 20;" alignment="CENTER">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 54 | `<Label text="Expense Breakdown by Category" style="-fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: #2c3e50;" />` | Renders a standard read-only Label text label displaying text 'Expense Breakdown by Category'. |
| 55 | `<PieChart fx:id="expensePieChart" legendSide="BOTTOM" VBox.vgrow="ALWAYS" />` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 56 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 57 | `</items>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 58 | `</SplitPane>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 59 | `</center>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 60 | `</BorderPane>` | BorderPane layout container arranging content in five regions: top, bottom, left, right, and center. |


## 🎨 UI/UX Component & Design Standards

This design file represents standard enterprise-level desktop app UI patterns:

- **Separation of Concerns**: Declares the layout cleanly in XML format while leaving backing interactive calculations to its Java Controller, isolating view definitions from operational calculations.
- **Flexible Grid & Box Layouts**: Relies heavily on combinations of `VBox`, `HBox`, and `GridPane` containers to automatically size controls across different resolution screens.
- **Event Binding**: Connects interactive nodes (Buttons, ComboBoxes) directly to handler methods defined in the controller, maximizing thread execution flow control.
