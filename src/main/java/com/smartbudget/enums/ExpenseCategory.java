package com.smartbudget.enums;

/**
 * Enumeration representing standard categories of transactions.
 * Demonstrates how Java enums are full-featured classes with constructors, fields, and methods.
 */
public enum ExpenseCategory {
    FOOD("Food & Dining"),
    UTILITIES("Utilities & Bills"),
    RENT("Rent & Housing"),
    ENTERTAINMENT("Entertainment & Leisure"),
    SALARY("Salary & Income"),
    OTHER("Other Miscellaneous");

    private final String displayName;

    ExpenseCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    /**
     * Helper to find enum value by its string name or display name.
     * Demonstrates Polymorphic behavior / Method searching.
     */
    public static ExpenseCategory fromString(String text) {
        for (ExpenseCategory category : ExpenseCategory.values()) {
            if (category.name().equalsIgnoreCase(text) || category.getDisplayName().equalsIgnoreCase(text)) {
                return category;
            }
        }
        return OTHER;
    }
}
