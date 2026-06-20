package com.smartbudget;

import javafx.application.Application;

/**
 * Entry point for the JavaFX application.
 * Delegates to MainApplication.main() to launch the app.
 */
public class Launcher {
    public static void main(String[] args) {
        Application.launch(MainApplication.class, args);
    }
}
