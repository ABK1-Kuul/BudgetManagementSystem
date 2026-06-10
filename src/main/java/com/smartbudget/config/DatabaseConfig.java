package com.smartbudget.config;

/**
 * Centralized database configuration.
 * NOTE: Local development only — passwords should never be hardcoded in production.
 */
public class DatabaseConfig {
    
    // Database connection details
    public static final String DB_HOST = "localhost";
    public static final String DB_PORT = "3306";
    public static final String DB_NAME = "smart_budget";
    public static final String DB_USER = "root";
    public static final String DB_PASSWORD = "";  // Empty for root on localhost
    
    // Construct JDBC URL
    public static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME 
                                        + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    
    // MySQL driver class
    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    
    // Connection pool settings
    public static final int CONNECTION_POOL_SIZE = 5;
    public static final int CONNECTION_TIMEOUT = 30000;  // 30 seconds
}
