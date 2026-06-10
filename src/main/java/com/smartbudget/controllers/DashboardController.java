package com.smartbudget.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.smartbudget.session.UserSession;
import com.smartbudget.MainApplication;

/**
 * Controller for dashboard screen.
 */
public class DashboardController {
    
    @FXML
    private Label welcomeLabel;
    
    @FXML
    private Label totalIncomeLabel;
    
    @FXML
    private Label totalExpensesLabel;
    
    @FXML
    private Label balanceLabel;
    
    private UserSession userSession;
    
    /**
     * Initialize controller.
     */
    @FXML
    public void initialize() {
        userSession = UserSession.getInstance();
        
        // Check if user is logged in
        if (userSession.isLoggedIn()) {
            String username = userSession.getCurrentUsername();
            welcomeLabel.setText("Welcome, " + username + "!");
        } else {
            // Redirect to login if not logged in
            MainApplication.showLoginScreen();
        }
        
        // Load placeholder data
        loadDashboardData();
    }
    
    /**
     * Load dashboard data.
     */
    private void loadDashboardData() {
        // TODO: Load real data from DashboardService
        // For now, showing placeholder values
        totalIncomeLabel.setText("$0.00");
        totalExpensesLabel.setText("$0.00");
        balanceLabel.setText("$0.00");
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
