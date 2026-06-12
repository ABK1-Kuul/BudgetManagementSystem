package com.smartbudget.exceptions;

public class ValidationException extends Exception {
    /**
     * Thrown when business rules are violated (e.g., negative amounts, empty fields).
     */
    public ValidationException(String message) {
        super(message);
    }
}
