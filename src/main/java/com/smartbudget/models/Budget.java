package com.smartbudget.models;

public class Budget {
    private int budgetId;
    private User user;
    private int month;
    private int year;
    private double amount;

    // No-Args Constructor
    public Budget() {}

    // All-Args Constructor
    public Budget(int budgetId, User user, int month, int year, double amount) {
        this.budgetId = budgetId;
        this.user = user;
        this.month = month;
        this.year = year;
        this.amount = amount;
    }

    // Getters and Setters
    public int getBudgetId() { return budgetId; }
    public void setBudgetId(int budgetId) { this.budgetId = budgetId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    @Override
    public String toString() {
        return "Budget{" + "budgetId=" + budgetId + ", user=" + (user != null ? user.getUsername() : "null") +
                ", month=" + month + ", year=" + year + ", amount=" + amount + '}';
    }
}
