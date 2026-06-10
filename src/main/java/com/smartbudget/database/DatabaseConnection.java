package com.smartbudget.database;

import com.smartbudget.config.DatabaseConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Singleton database connection manager.
 * Handles pooled connections to MySQL database.
 */
public class DatabaseConnection {
    
    private static DatabaseConnection instance;
    private Connection connection;
    
    /**
     * Private constructor - prevents direct instantiation.
     */
    private DatabaseConnection() {}
    
    /**
     * Get singleton instance of DatabaseConnection.
     * @return DatabaseConnection instance
     */
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    
    /**
     * Get active database connection.
     * Creates new connection if current one is null or closed.
     * @return Active Connection object
     * @throws SQLException if connection fails
     */
    public Connection getConnection() throws SQLException {
        try {
            // Load MySQL driver
            Class.forName(DatabaseConfig.DB_DRIVER);
            
            // Create new connection
            connection = DriverManager.getConnection(
                DatabaseConfig.DB_URL,
                DatabaseConfig.DB_USER,
                DatabaseConfig.DB_PASSWORD
            );
            
            return connection;
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found: " + e.getMessage());
        }
    }
    
    /**
     * Close current connection.
     * @throws SQLException if close fails
     */
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            connection = null;
        }
    }
    
    /**
     * Test database connectivity.
     * Useful for debugging connection issues.
     * @return true if connection successful, false otherwise
     */
    public boolean testConnection() {
        try {
            Connection test = getConnection();
            if (test != null && !test.isClosed()) {
                System.out.println("✓ Database connection successful");
                return true;
            }
        } catch (SQLException e) {
            System.err.println("✗ Database connection failed: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
