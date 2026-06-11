package com.smartbudget.enums;

/**
 * Enumeration representing user access roles.
 * Demonstrates the OOP concept of Type Safety and Enumerated Types.
 */
public enum UserRole {
    STANDARD("Standard User"),
    ADMIN("Administrator");

    private final String displayName;

    UserRole(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
