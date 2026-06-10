package com.smartbudget.controllers;

import com.smartbudget.MainApplication;
import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.models.User;
import com.smartbudget.services.AuthService;
import com.smartbudget.utils.AlertUtil;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Controller for login screen.
 */
public class LoginController {
    
    @FXML
    private TextField usernameField;
    
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private Label errorLabel;
    
    @FXML
    private Button loginButton;
    
    private AuthService authService;
    
    /**
     * Initialize controller.
     */
    @FXML
    public void initialize() {
        authService = new AuthService();
        errorLabel.setText("");
    }
    
    /**
     * Handle login button click.
     */
    @FXML
    private void onLoginClick() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();
        
        // Clear previous errors
        errorLabel.setText("");
        
        // Validate inputs
        if (username.isEmpty()) {
            errorLabel.setText("Username cannot be empty.");
            return;
        }
        if (password.isEmpty()) {
            errorLabel.setText("Password cannot be empty.");
            return;
        }
        
        try {
            // Attempt login
            User user = authService.login(username, password);
            AlertUtil.showSuccess("Login Successful", "Welcome, " + user.getUsername() + "!");
            // Navigate to dashboard
            MainApplication.showDashboardScreen();
        } catch (ValidationException e) {
            errorLabel.setText(e.getMessage());
        } catch (DatabaseException e) {
            errorLabel.setText("Database error: " + e.getMessage());
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Handle register hyperlink click.
     */
    @FXML
    private void onRegisterClick() {
        MainApplication.showRegisterScreen();
    }
}
