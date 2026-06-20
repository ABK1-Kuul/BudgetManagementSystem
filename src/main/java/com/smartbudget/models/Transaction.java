package com.smartbudget.models;

import java.time.LocalDate;

import com.smartbudget.exceptions.ValidationException;

/**
 * Abstract class representing a general financial transaction.
 * Demonstrates the OOP principles of Abstraction, Inheritance, and Encapsulation.
 */
public abstract class Transaction {
    protected int id;
    protected User user;           // Aggregation: User exists independently of Transaction
    protected double amount;
    protected String description;
    protected LocalDate date;

    // Default No-Args Constructor
    public Transaction() {}

    // Parameterized Constructor
    public Transaction(int id, User user, double amount, String description, LocalDate date) throws ValidationException {
        this.id = id;
        this.user = user;
        setAmount(amount); // Demonstrates encapsulation: checking validation rules during construction
        this.description = description;
        this.date = date;
    }

    // Abstract method: Demonstrates Abstraction and forces subclasses to override behavior
    public abstract String getTransactionType();

    // Polymorphic method: Returns positive or negative depending on transaction category
    public abstract double getSignedAmount();

    // Setters and Getters with strict Encapsulation (Validation rules)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    /**
     * Set amount with safe validation logic.
     * Demonstrates Encapsulation (Information Hiding and Data Guarding).
     */
    public void setAmount(double amount) throws ValidationException {
        if (amount <= 0) {
            throw new ValidationException("Transaction amount must be strictly positive.");
        }
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", user=" + (user != null ? user.getUsername() : "null") +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }
}
