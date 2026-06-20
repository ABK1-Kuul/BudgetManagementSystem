package com.smartbudget.exceptions;

public class DatabaseException extends Exception {
    /**
     * Thrown if something breaks lower down in Member 1's DAO layer
     * (e.g., MySQL server connection drops).
     */
    public DatabaseException(String message) {
        super(message);
    }
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
