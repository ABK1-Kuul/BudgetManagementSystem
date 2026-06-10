package com.smartbudget.models;

import java.time.LocalDate;

public class Expense {
    private int expenseId;
    private User user;          // Object relationship instead of raw int id
    private Category category;          // Object relationship instead of raw int id
    private double amount;
    private String description;
    private LocalDate expenseDate;

    // No-Args Constructor
    public Expense() {}

    // All-Args Constructor
    public Expense(int expenseId, User user, Category category, double amount, String description, LocalDate expenseDate) {
        this.expenseId = expenseId;
        this.user = user;
        this.category = category;
        this.amount = amount;
        this.description = description;
        this.expenseDate = expenseDate;
    }

    // Getters and Setters
    public int getExpenseId() { return expenseId; }
    public void setExpenseId(int expenseId) { this.expenseId = expenseId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getExpenseDate() { return expenseDate; }
    public void setExpenseDate(LocalDate expenseDate) { this.expenseDate = expenseDate; }

    @Override
    public String toString() {
        return "Expense{" + "expenseId=" + expenseId + ", user=" + (user != null ? user.getUsername() : "null") +
                ", category=" + (category != null ? category.getCategoryName() : "null") +
                ", amount=" + amount + ", description='" + description + '\'' + ", expenseDate=" + expenseDate + '}';
    }
}
