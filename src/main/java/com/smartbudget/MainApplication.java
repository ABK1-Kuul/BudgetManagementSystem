package com.smartbudget;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main JavaFX application.
 * Initializes the window, loads the login screen, and manages scene navigation.
 */
public class MainApplication extends Application {
    
    private static Stage primaryStage;
    private static final String APP_TITLE = "Smart Budget Management System";
    private static final int WINDOW_WIDTH = 900;
    private static final int WINDOW_HEIGHT = 600;
    
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        
        // Set window properties
        primaryStage.setTitle(APP_TITLE);
        primaryStage.setWidth(WINDOW_WIDTH);
        primaryStage.setHeight(WINDOW_HEIGHT);
        primaryStage.setResizable(true);
        primaryStage.setOnCloseRequest(e -> {
            System.out.println("Application closing...");
            System.exit(0);
        });
        
        // Load and display login screen
        showLoginScreen();
        
        primaryStage.show();
        System.out.println("✓ Application started");
    }
    
    /**
     * Show login screen.
     */
    public static void showLoginScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/fxml/login.fxml"));
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(MainApplication.class.getResource("/css/app.css").toExternalForm());
            primaryStage.setScene(scene);
        } catch (IOException e) {
            System.err.println("Error loading login screen: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Show register screen.
     */
    public static void showRegisterScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/fxml/register.fxml"));
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(MainApplication.class.getResource("/css/app.css").toExternalForm());
            primaryStage.setScene(scene);
        } catch (IOException e) {
            System.err.println("Error loading register screen: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Show dashboard screen.
     */
    public static void showDashboardScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/fxml/dashboard.fxml"));
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(MainApplication.class.getResource("/css/app.css").toExternalForm());
            primaryStage.setScene(scene);
        } catch (IOException e) {
            System.err.println("Error loading dashboard screen: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Show expenses screen.
     */
    public static void showExpensesScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/fxml/expenses.fxml"));
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(MainApplication.class.getResource("/css/app.css").toExternalForm());
            primaryStage.setScene(scene);
        } catch (IOException e) {
            System.err.println("Error loading expenses screen: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Show budget screen.
     */
    public static void showBudgetScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/fxml/budget.fxml"));
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(MainApplication.class.getResource("/css/app.css").toExternalForm());
            primaryStage.setScene(scene);
        } catch (IOException e) {
            System.err.println("Error loading budget screen: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Show reports screen.
     */
    public static void showReportsScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("/fxml/reports.fxml"));
            Scene scene = new Scene(loader.load());
            scene.getStylesheets().add(MainApplication.class.getResource("/css/app.css").toExternalForm());
            primaryStage.setScene(scene);
        } catch (IOException e) {
            System.err.println("Error loading reports screen: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Get primary stage for custom operations.
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}
