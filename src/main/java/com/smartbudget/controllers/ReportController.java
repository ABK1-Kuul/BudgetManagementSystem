package com.smartbudget.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smartbudget.MainApplication;
import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.models.Expense;
import com.smartbudget.services.DashboardService;
import com.smartbudget.services.ExpenseService;
import com.smartbudget.session.UserSession;
import com.smartbudget.utils.AlertUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;

/**
 * Controller for Reporting and Charts.
 * Aggregates expense categories and renders a JavaFX PieChart.
 * Demonstrates MVC structure and simple sorting/mapping algorithms in OOP.
 */
public class ReportController {

    @FXML private Label reportIncomeLabel;
    @FXML private Label reportExpenseLabel;
    @FXML private Label reportSavingsLabel;
    @FXML private PieChart expensePieChart;

    private ExpenseService expenseService;
    private DashboardService dashboardService;
    private UserSession userSession;

    @FXML
    public void initialize() {
        expenseService = new ExpenseService();
        dashboardService = new DashboardService();
        userSession = UserSession.getInstance();

        if (!userSession.isLoggedIn()) {
            MainApplication.showLoginScreen();
            return;
        }

        loadReportData();
    }

    /**
     * Fetch records and populate chart slice data and numeric totals.
     */
    private void loadReportData() {
        try {
            int userId = userSession.getCurrentUserId();

            // 1. Fetch live metrics from dashboard service
            double incomeSum = dashboardService.getTotalIncome(userId);
            double expenseSum = dashboardService.getTotalExpenses(userId);
            double savings = incomeSum - expenseSum;

            reportIncomeLabel.setText(String.format("%.2f ETB", incomeSum));
            reportExpenseLabel.setText(String.format("%.2f ETB", expenseSum));
            reportSavingsLabel.setText(String.format("%.2f ETB", savings));

            if (savings < 0) {
                reportSavingsLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-weight: bold;"); // Deficit
            } else {
                reportSavingsLabel.setStyle("-fx-text-fill: #27ae60; -fx-font-weight: bold;"); // Surplus
            }

            // 2. Fetch expenses and aggregate them by category for the PieChart
            List<Expense> expenses = expenseService.getExpensesByUser(userId);
            Map<String, Double> categoryTotals = new HashMap<>();

            for (Expense expense : expenses) {
                String catName = "Other";
                if (expense.getCategory() != null) {
                    catName = expense.getCategory().getCategoryName();
                }
                
                categoryTotals.put(catName, categoryTotals.getOrDefault(catName, 0.0) + expense.getAmount());
            }

            // 3. Populate PieChart data slices
            ObservableList<PieChart.Data> chartData = FXCollections.observableArrayList();
            for (Map.Entry<String, Double> entry : categoryTotals.entrySet()) {
                chartData.add(new PieChart.Data(entry.getKey() + " (" + String.format("%.2f ETB", entry.getValue()) + ")", entry.getValue()));
            }

            expensePieChart.setData(chartData);

        } catch (DatabaseException e) {
            AlertUtil.showError("Database Error", "Failed to compile financial reports: " + e.getMessage());
        }
    }

    @FXML
    private void onBackClick() {
        MainApplication.showDashboardScreen();
    }
}
