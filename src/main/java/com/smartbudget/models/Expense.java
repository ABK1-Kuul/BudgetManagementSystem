package com.smartbudget.models;

import java.time.LocalDate;

import com.smartbudget.exceptions.ValidationException;

/**
 * Class representing an Expense transaction.
 * Demonstrates the OOP principles of Inheritance (extends Transaction) and
 * Aggregation (has-a Category relationship, where Category lives independently of Expense).
 */
public class Expense extends Transaction {
    private Category category; // Aggregation relationship

    // No-Args Constructor
    public Expense() {
        super();
    }

    // Parameterized Constructor
    public Expense(int expenseId, User user, Category category, double amount, String description, LocalDate expenseDate) throws ValidationException {
        // Call parent class constructor to initialize common fields
        super(expenseId, user, amount, description, expenseDate);
        this.category = category;
    }

    // Implement Abstraction contract: returns the transaction category type description
    @Override
    public String getTransactionType() {
        return "Expense";
    }

    // Implement Polymorphic signed amount contract: Expenses are negative cash flows
    @Override
    public double getSignedAmount() {
        return -amount;
    }

    // Getter and Setter for Category (demonstrating encapsulation and aggregation)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // Backward compatibility delegates: map standard names to parent class Transaction fields
    public int getExpenseId() {
        return getId();
    }

    public void setExpenseId(int expenseId) {
        setId(expenseId);
    }

    public LocalDate getExpenseDate() {
        return getDate();
    }

    public void setExpenseDate(LocalDate expenseDate) {
        setDate(expenseDate);
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + getExpenseId() +
                ", user=" + (user != null ? user.getUsername() : "null") +
                ", category=" + (category != null ? category.getCategoryName() : "null") +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", expenseDate=" + getExpenseDate() +
                '}';
    }
}
