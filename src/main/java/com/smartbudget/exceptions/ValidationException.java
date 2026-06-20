package com.smartbudget.exceptions;

/**
 * Custom exception for validation-related errors.
 * Thrown when business rules are violated (e.g., negative amounts, empty fields).
 */
public class ValidationException extends Exception {

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
