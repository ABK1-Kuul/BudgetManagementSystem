package com.smartbudget.controllers;

import com.smartbudget.MainApplication;
import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.services.DashboardService;
import com.smartbudget.session.UserSession;
import com.smartbudget.utils.AlertUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Controller for the Dashboard screen.
 * Displays overall financial summaries (total income, total expenses, net balance)
 * dynamically loaded from the database via DashboardService.
 * Demonstrates MVC coordination and clean session state retrieval.
 */
public class DashboardController {
    
    @FXML private Label welcomeLabel;
    @FXML private Label totalIncomeLabel;
    @FXML private Label totalExpensesLabel;
    @FXML private Label balanceLabel;
    
    private UserSession userSession;
    private DashboardService dashboardService;
    
    /**
     * Initialize controller.
     */
    @FXML
    public void initialize() {
        userSession = UserSession.getInstance();
        dashboardService = new DashboardService();
        
        // Check if user is logged in
        if (userSession.isLoggedIn()) {
            String username = userSession.getCurrentUsername();
            welcomeLabel.setText("Welcome, " + username + "!");
            
            // Load live dashboard metrics from the database
            loadDashboardData();
        } else {
            // Redirect to login if not logged in
            MainApplication.showLoginScreen();
        }
    }
    
    /**
     * Load live dashboard metrics from DashboardService.
     * Integrates database aggregations.
     */
    private void loadDashboardData() {
        try {
            int userId = userSession.getCurrentUserId();
            
            // 1. Fetch values
            double totalIncome = dashboardService.getTotalIncome(userId);
            double totalExpenses = dashboardService.getTotalExpenses(userId);
            double netBalance = dashboardService.getNetBalance(userId);
            
            // 2. Format as Currency
            totalIncomeLabel.setText(String.format("%.2f ETB", totalIncome));
            totalExpensesLabel.setText(String.format("%.2f ETB", totalExpenses));
            balanceLabel.setText(String.format("%.2f ETB", netBalance));
            
            // 3. Optional: apply color cues based on balance
            if (netBalance < 0) {
                balanceLabel.setStyle("-fx-text-fill: #e74c3c; -fx-font-size: 20; -fx-font-weight: bold;"); // Red for negative
            } else {
                balanceLabel.setStyle("-fx-text-fill: #9b59b6; -fx-font-size: 20; -fx-font-weight: bold;"); // Purple / Green for positive
            }
            
        } catch (DatabaseException e) {
            AlertUtil.showError("Database Error", "Failed to retrieve financial summary from the database: " + e.getMessage());
            totalIncomeLabel.setText("Error");
            totalExpensesLabel.setText("Error");
            balanceLabel.setText("Error");
        }
    }
    
    /**
     * Handle logout button click.
     */
    @FXML
    private void onLogoutClick() {
        userSession.logout();
        MainApplication.showLoginScreen();
    }
    
    /**
     * Handle expenses button click.
     */
    @FXML
    private void onExpensesClick() {
        MainApplication.showExpensesScreen();
    }
    
    /**
     * Handle budget button click.
     */
    @FXML
    private void onBudgetClick() {
        MainApplication.showBudgetScreen();
    }
    
    /**
     * Handle reports button click.
     */
    @FXML
    private void onReportsClick() {
        MainApplication.showReportsScreen();
    }
}
