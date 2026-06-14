# budget.fxml - Detailed UI Explanation & Bindings

## 📌 Overview & Screen Role
**View Name:** `budget.fxml`  
**Linked Controller:** `com.smartbudget.controllers.BudgetController`  
**Description:** Visual layout template (FXML) defining the UI screen structure and bindings for the `budget` view in the Budget Management System.

This FXML document designs the user-facing layouts, inputs, tables, and interaction points for this specific sub-view. It is styled with external CSS sheets and binds directly to the JavaFX controller class `com.smartbudget.controllers.BudgetController` to bridge user events with Java services.

## 🔍 Line-by-Line Tag and Attribute Analysis

Below is a comprehensive tag-by-tag and attribute-by-attribute breakdown mapping each FXML design line to its visual layout purpose:

| Line # | FXML Design Line | Visual and Controller Binding Role |
| :--- | :--- | :--- |
| 1 | `<?xml version="1.0" encoding="UTF-8"?>` | Defines the XML version and document encoding (UTF-8) for compatibility parsing. |
| 2 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 3 | `<?import javafx.geometry.Insets?>` | Imports the `javafx.geometry.Insets` class into the FXML namespace, allowing the GUI runtime to instantiate it. |
| 4 | `<?import javafx.scene.control.*?>` | Imports the `javafx.scene.control.*` class into the FXML namespace, allowing the GUI runtime to instantiate it. |
| 5 | `<?import javafx.scene.layout.*?>` | Imports the `javafx.scene.layout.*` class into the FXML namespace, allowing the GUI runtime to instantiate it. |
| 6 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 7 | `<BorderPane xmlns="http://javafx.com/javafx" xmlns:fx="http://javafx.com/fxml" fx:controller="com.smartbudget.controllers.BudgetController" prefWidth="900" prefHeight="600">` | BorderPane layout container arranging content in five regions: top, bottom, left, right, and center. |
| 8 | `<!-- Top Nav Bar -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 9 | `<top>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 10 | `<HBox spacing="10" style="-fx-background-color: #2c3e50; -fx-padding: 15;" alignment="CENTER_LEFT">` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 11 | `<Label text="Monthly Budgeting" style="-fx-text-fill: white; -fx-font-size: 18; -fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text 'Monthly Budgeting'. |
| 12 | `<Region HBox.hgrow="ALWAYS" />` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 13 | `<Button text="Back to Dashboard" onAction="#onBackClick" style="-fx-font-size: 12; -fx-padding: 8; -fx-font-weight: bold; -fx-background-color: #34495e; -fx-text-fill: white;" />` | Renders an interactive Button component labeled 'Back to Dashboard' bound to trigger `onBackClick()`. |
| 14 | `</HBox>` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 15 | `</top>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 16 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 17 | `<!-- Main Content -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 18 | `<center>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 19 | `<HBox spacing="20" style="-fx-padding: 20; -fx-background-color: white;">` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 20 | `<!-- Left Panel: Budget Form -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 21 | `<VBox spacing="15" style="-fx-background-color: #f8f9fa; -fx-padding: 20; -fx-border-color: #dee2e6; -fx-border-radius: 5; -fx-background-radius: 5;" minWidth="320" maxWidth="320">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 22 | `<Label text="Set Monthly Budget" style="-fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: #2c3e50;" />` | Renders a standard read-only Label text label displaying text 'Set Monthly Budget'. |
| 23 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 24 | `<!-- Year Select -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 25 | `<VBox spacing="5">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 26 | `<Label text="Year" style="-fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text 'Year'. |
| 27 | `<ComboBox fx:id="yearComboBox" promptText="Select Year" style="-fx-max-width: Infinity;" />` | Defines a dropdown ComboBox component with prompt text 'Select Year'. |
| 28 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 29 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 30 | `<!-- Month Select -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 31 | `<VBox spacing="5">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 32 | `<Label text="Month" style="-fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text 'Month'. |
| 33 | `<ComboBox fx:id="monthComboBox" promptText="Select Month" style="-fx-max-width: Infinity;" />` | Defines a dropdown ComboBox component with prompt text 'Select Month'. |
| 34 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 35 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 36 | `<!-- Amount Input -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 37 | `<VBox spacing="5">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 38 | `<Label text="Budget Amount (ETB)" style="-fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text 'Budget Amount (ETB)'. |
| 39 | `<TextField fx:id="budgetAmountField" promptText="e.g. 500.00" />` | Renders a single-line TextField text input field with prompt text 'e.g. 500.00'. |
| 40 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 41 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 42 | `<Button text="Save Budget Plan" onAction="#onSaveBudgetClick" style="-fx-max-width: Infinity; -fx-background-color: #2980b9; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10;" />` | Renders an interactive Button component labeled 'Save Budget Plan' bound to trigger `onSaveBudgetClick()`. |
| 43 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 44 | `<Separator />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 45 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 46 | `<!-- Live Budget Status Calculator -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 47 | `<Label text="Budget Status Query" style="-fx-font-size: 14; -fx-font-weight: bold; -fx-text-fill: #2c3e50;" />` | Renders a standard read-only Label text label displaying text 'Budget Status Query'. |
| 48 | `<Button text="Check Status for Selection" onAction="#onCheckStatusClick" style="-fx-max-width: Infinity; -fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8;" />` | Renders an interactive Button component labeled 'Check Status for Selection' bound to trigger `onCheckStatusClick()`. |
| 49 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 50 | `<VBox spacing="10" style="-fx-background-color: #e8f4f8; -fx-padding: 15; -fx-border-color: #bce1ec; -fx-border-radius: 3;">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 51 | `<HBox spacing="10">` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 52 | `<Label text="Total Budget:" style="-fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text 'Total Budget:'. |
| 53 | `<Label fx:id="statusBudgetLabel" text="0.00" />` | Renders a standard read-only Label text label displaying text '0.00'. |
| 54 | `</HBox>` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 55 | `<HBox spacing="10">` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 56 | `<Label text="Total Spent:" style="-fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text 'Total Spent:'. |
| 57 | `<Label fx:id="statusSpentLabel" text="0.00" />` | Renders a standard read-only Label text label displaying text '0.00'. |
| 58 | `</HBox>` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 59 | `<HBox spacing="10">` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 60 | `<Label text="Remaining:" style="-fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text 'Remaining:'. |
| 61 | `<Label fx:id="statusRemainingLabel" text="0.00" />` | Renders a standard read-only Label text label displaying text '0.00'. |
| 62 | `</HBox>` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 63 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 64 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 65 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 66 | `<!-- Right Panel: Budget List Table -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 67 | `<VBox spacing="10" HBox.hgrow="ALWAYS">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 68 | `<HBox alignment="CENTER_LEFT">` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 69 | `<Label text="Active Budget Plans" style="-fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: #2c3e50;" />` | Renders a standard read-only Label text label displaying text 'Active Budget Plans'. |
| 70 | `<Region HBox.hgrow="ALWAYS" />` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 71 | `<Button text="Delete Selected Plan" onAction="#onDeleteBudgetClick" style="-fx-background-color: #95a5a6; -fx-text-fill: white; -fx-font-weight: bold;" />` | Renders an interactive Button component labeled 'Delete Selected Plan' bound to trigger `onDeleteBudgetClick()`. |
| 72 | `</HBox>` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 73 | `<TableView fx:id="budgetTableView" VBox.vgrow="ALWAYS">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 74 | `<columns>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 75 | `<TableColumn fx:id="budgetIdCol" text="ID" prefWidth="50" />` | Defines a TableColumn grid column with header text 'ID'. |
| 76 | `<TableColumn fx:id="budgetYearCol" text="Year" prefWidth="100" />` | Defines a TableColumn grid column with header text 'Year'. |
| 77 | `<TableColumn fx:id="budgetMonthCol" text="Month" prefWidth="120" />` | Defines a TableColumn grid column with header text 'Month'. |
| 78 | `<TableColumn fx:id="budgetAmountCol" text="Budget Amount (ETB)" prefWidth="150" />` | Defines a TableColumn grid column with header text 'Budget Amount (ETB)'. |
| 79 | `</columns>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 80 | `<columnResizePolicy>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 81 | `<TableView fx:constant="CONSTRAINED_RESIZE_POLICY" />` | Defines a TableView component for visual rendering of structured tabular rows. |
| 82 | `</columnResizePolicy>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 83 | `</TableView>` | Defines a TableView component for visual rendering of structured tabular rows. |
| 84 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 85 | `</HBox>` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 86 | `</center>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 87 | `</BorderPane>` | BorderPane layout container arranging content in five regions: top, bottom, left, right, and center. |


## 🎨 UI/UX Component & Design Standards

This design file represents standard enterprise-level desktop app UI patterns:

- **Separation of Concerns**: Declares the layout cleanly in XML format while leaving backing interactive calculations to its Java Controller, isolating view definitions from operational calculations.
- **Flexible Grid & Box Layouts**: Relies heavily on combinations of `VBox`, `HBox`, and `GridPane` containers to automatically size controls across different resolution screens.
- **Event Binding**: Connects interactive nodes (Buttons, ComboBoxes) directly to handler methods defined in the controller, maximizing thread execution flow control.
