# expenses.fxml - Detailed UI Explanation & Bindings

## 📌 Overview & Screen Role
**View Name:** `expenses.fxml`  
**Linked Controller:** `com.smartbudget.controllers.ExpenseController`  
**Description:** Visual layout template (FXML) defining the UI screen structure and bindings for the `expenses` view in the Budget Management System.

This FXML document designs the user-facing layouts, inputs, tables, and interaction points for this specific sub-view. It is styled with external CSS sheets and binds directly to the JavaFX controller class `com.smartbudget.controllers.ExpenseController` to bridge user events with Java services.

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
| 7 | `<BorderPane xmlns="http://javafx.com/javafx" xmlns:fx="http://javafx.com/fxml" fx:controller="com.smartbudget.controllers.ExpenseController" prefWidth="900" prefHeight="600">` | BorderPane layout container arranging content in five regions: top, bottom, left, right, and center. |
| 8 | `<!-- Top Nav Bar -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 9 | `<top>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 10 | `<HBox spacing="10" style="-fx-background-color: #2c3e50; -fx-padding: 15;" alignment="CENTER_LEFT">` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 11 | `<Label text="Transaction Management" style="-fx-text-fill: white; -fx-font-size: 18; -fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text 'Transaction Management'. |
| 12 | `<Region HBox.hgrow="ALWAYS" />` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 13 | `<Button text="Back to Dashboard" onAction="#onBackClick" style="-fx-font-size: 12; -fx-padding: 8; -fx-font-weight: bold; -fx-background-color: #34495e; -fx-text-fill: white;" />` | Renders an interactive Button component labeled 'Back to Dashboard' bound to trigger `onBackClick()`. |
| 14 | `</HBox>` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 15 | `</top>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 16 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 17 | `<!-- Main Content Area -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 18 | `<center>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 19 | `<TabPane tabClosingPolicy="UNAVAILABLE" style="-fx-background-color: white;">` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 20 | `<!-- Tab 1: Expense Log -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 21 | `<Tab text="Expenses">` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 22 | `<HBox spacing="20" style="-fx-padding: 20;">` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 23 | `<!-- Left: Form -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 24 | `<VBox spacing="15" style="-fx-background-color: #f8f9fa; -fx-padding: 20; -fx-border-color: #dee2e6; -fx-border-radius: 5; -fx-background-radius: 5;" minWidth="300" maxWidth="300">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 25 | `<Label text="Add New Expense" style="-fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: #2c3e50;" />` | Renders a standard read-only Label text label displaying text 'Add New Expense'. |
| 26 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 27 | `<!-- Category Input -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 28 | `<VBox spacing="5">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 29 | `<Label text="Category" style="-fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text 'Category'. |
| 30 | `<ComboBox fx:id="expenseCategoryComboBox" promptText="Select Category" style="-fx-max-width: Infinity;" />` | Defines a dropdown ComboBox component with prompt text 'Select Category'. |
| 31 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 32 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 33 | `<!-- Amount Input -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 34 | `<VBox spacing="5">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 35 | `<Label text="Amount (ETB)" style="-fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text 'Amount (ETB)'. |
| 36 | `<TextField fx:id="expenseAmountField" promptText="e.g. 24.50" />` | Renders a single-line TextField text input field with prompt text 'e.g. 24.50'. |
| 37 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 38 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 39 | `<!-- Description Input -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 40 | `<VBox spacing="5">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 41 | `<Label text="Description" style="-fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text 'Description'. |
| 42 | `<TextField fx:id="expenseDescriptionField" promptText="e.g. Weekly Groceries" />` | Renders a single-line TextField text input field with prompt text 'e.g. Weekly Groceries'. |
| 43 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 44 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 45 | `<!-- Date Input -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 46 | `<VBox spacing="5">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 47 | `<Label text="Date" style="-fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text 'Date'. |
| 48 | `<DatePicker fx:id="expenseDatePicker" style="-fx-max-width: Infinity;" />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 49 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 50 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 51 | `<Region VBox.vgrow="ALWAYS" />` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 52 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 53 | `<!-- Save Action -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 54 | `<Button text="Save Expense" onAction="#onSaveExpenseClick" style="-fx-max-width: Infinity; -fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10;" />` | Renders an interactive Button component labeled 'Save Expense' bound to trigger `onSaveExpenseClick()`. |
| 55 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 56 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 57 | `<!-- Right: Table View -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 58 | `<VBox spacing="10" HBox.hgrow="ALWAYS">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 59 | `<HBox alignment="CENTER_LEFT">` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 60 | `<Label text="Expense Records" style="-fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: #2c3e50;" />` | Renders a standard read-only Label text label displaying text 'Expense Records'. |
| 61 | `<Region HBox.hgrow="ALWAYS" />` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 62 | `<Button text="Delete Selected" onAction="#onDeleteExpenseClick" style="-fx-background-color: #95a5a6; -fx-text-fill: white; -fx-font-weight: bold;" />` | Renders an interactive Button component labeled 'Delete Selected' bound to trigger `onDeleteExpenseClick()`. |
| 63 | `</HBox>` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 64 | `<TableView fx:id="expenseTableView" VBox.vgrow="ALWAYS">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 65 | `<columns>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 66 | `<TableColumn fx:id="expenseIdCol" text="ID" prefWidth="50" />` | Defines a TableColumn grid column with header text 'ID'. |
| 67 | `<TableColumn fx:id="expenseCategoryCol" text="Category" prefWidth="120" />` | Defines a TableColumn grid column with header text 'Category'. |
| 68 | `<TableColumn fx:id="expenseAmountCol" text="Amount (ETB)" prefWidth="100" />` | Defines a TableColumn grid column with header text 'Amount (ETB)'. |
| 69 | `<TableColumn fx:id="expenseDescriptionCol" text="Description" prefWidth="200" />` | Defines a TableColumn grid column with header text 'Description'. |
| 70 | `<TableColumn fx:id="expenseDateCol" text="Date" prefWidth="100" />` | Defines a TableColumn grid column with header text 'Date'. |
| 71 | `</columns>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 72 | `<columnResizePolicy>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 73 | `<TableView fx:constant="CONSTRAINED_RESIZE_POLICY" />` | Defines a TableView component for visual rendering of structured tabular rows. |
| 74 | `</columnResizePolicy>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 75 | `</TableView>` | Defines a TableView component for visual rendering of structured tabular rows. |
| 76 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 77 | `</HBox>` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 78 | `</Tab>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 79 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 80 | `<!-- Tab 2: Income Log -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 81 | `<Tab text="Income">` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 82 | `<HBox spacing="20" style="-fx-padding: 20;">` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 83 | `<!-- Left: Form -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 84 | `<VBox spacing="15" style="-fx-background-color: #f8f9fa; -fx-padding: 20; -fx-border-color: #dee2e6; -fx-border-radius: 5; -fx-background-radius: 5;" minWidth="300" maxWidth="300">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 85 | `<Label text="Add New Income" style="-fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: #2c3e50;" />` | Renders a standard read-only Label text label displaying text 'Add New Income'. |
| 86 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 87 | `<!-- Amount Input -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 88 | `<VBox spacing="5">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 89 | `<Label text="Amount (ETB)" style="-fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text 'Amount (ETB)'. |
| 90 | `<TextField fx:id="incomeAmountField" promptText="e.g. 500.00" />` | Renders a single-line TextField text input field with prompt text 'e.g. 500.00'. |
| 91 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 92 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 93 | `<!-- Description Input -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 94 | `<VBox spacing="5">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 95 | `<Label text="Description" style="-fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text 'Description'. |
| 96 | `<TextField fx:id="incomeDescriptionField" promptText="e.g. Monthly Salary" />` | Renders a single-line TextField text input field with prompt text 'e.g. Monthly Salary'. |
| 97 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 98 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 99 | `<!-- Date Input -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 100 | `<VBox spacing="5">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 101 | `<Label text="Date" style="-fx-font-weight: bold;" />` | Renders a standard read-only Label text label displaying text 'Date'. |
| 102 | `<DatePicker fx:id="incomeDatePicker" style="-fx-max-width: Infinity;" />` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 103 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 104 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 105 | `<Region VBox.vgrow="ALWAYS" />` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 106 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 107 | `<!-- Save Action -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 108 | `<Button text="Save Income" onAction="#onSaveIncomeClick" style="-fx-max-width: Infinity; -fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10;" />` | Renders an interactive Button component labeled 'Save Income' bound to trigger `onSaveIncomeClick()`. |
| 109 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 110 | *Spacer* | Blank space to format and indent XML layouts for developer readability. |
| 111 | `<!-- Right: Table View -->` | XML comment explaining UI-specific layout features or grouping tags. |
| 112 | `<VBox spacing="10" HBox.hgrow="ALWAYS">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 113 | `<HBox alignment="CENTER_LEFT">` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 114 | `<Label text="Income Records" style="-fx-font-size: 16; -fx-font-weight: bold; -fx-text-fill: #2c3e50;" />` | Renders a standard read-only Label text label displaying text 'Income Records'. |
| 115 | `<Region HBox.hgrow="ALWAYS" />` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 116 | `<Button text="Delete Selected" onAction="#onDeleteIncomeClick" style="-fx-background-color: #95a5a6; -fx-text-fill: white; -fx-font-weight: bold;" />` | Renders an interactive Button component labeled 'Delete Selected' bound to trigger `onDeleteIncomeClick()`. |
| 117 | `</HBox>` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 118 | `<TableView fx:id="incomeTableView" VBox.vgrow="ALWAYS">` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 119 | `<columns>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 120 | `<TableColumn fx:id="incomeIdCol" text="ID" prefWidth="50" />` | Defines a TableColumn grid column with header text 'ID'. |
| 121 | `<TableColumn fx:id="incomeAmountCol" text="Amount (ETB)" prefWidth="120" />` | Defines a TableColumn grid column with header text 'Amount (ETB)'. |
| 122 | `<TableColumn fx:id="incomeDescriptionCol" text="Description" prefWidth="250" />` | Defines a TableColumn grid column with header text 'Description'. |
| 123 | `<TableColumn fx:id="incomeDateCol" text="Date" prefWidth="120" />` | Defines a TableColumn grid column with header text 'Date'. |
| 124 | `</columns>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 125 | `<columnResizePolicy>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 126 | `<TableView fx:constant="CONSTRAINED_RESIZE_POLICY" />` | Defines a TableView component for visual rendering of structured tabular rows. |
| 127 | `</columnResizePolicy>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 128 | `</TableView>` | Defines a TableView component for visual rendering of structured tabular rows. |
| 129 | `</VBox>` | VBox layout pane that stacks its child UI components in a single vertical column. |
| 130 | `</HBox>` | HBox layout pane that aligns its child UI components in a single horizontal row. |
| 131 | `</Tab>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 132 | `</TabPane>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 133 | `</center>` | Configures node layout constraints, margins, alignments, sizing ratios, or closing layout tags. |
| 134 | `</BorderPane>` | BorderPane layout container arranging content in five regions: top, bottom, left, right, and center. |


## 🎨 UI/UX Component & Design Standards

This design file represents standard enterprise-level desktop app UI patterns:

- **Separation of Concerns**: Declares the layout cleanly in XML format while leaving backing interactive calculations to its Java Controller, isolating view definitions from operational calculations.
- **Flexible Grid & Box Layouts**: Relies heavily on combinations of `VBox`, `HBox`, and `GridPane` containers to automatically size controls across different resolution screens.
- **Event Binding**: Connects interactive nodes (Buttons, ComboBoxes) directly to handler methods defined in the controller, maximizing thread execution flow control.
