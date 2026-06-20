package com.smartbudget.models;

import java.time.LocalDate;

public class Income {
    private int incomeId;
    private User user;
    private double amount;
    private String description;
    private LocalDate incomeDate;

    // No-Args Constructor
    public Income() {}

    // All-Args Constructor
    public Income(int incomeId, User user, double amount, String description, LocalDate incomeDate) {
        this.incomeId = incomeId;
        this.user = user;
        this.amount = amount;
        this.description = description;
        this.incomeDate = incomeDate;
    }

    // Getters and Setters
    public int getIncomeId() { return incomeId; }
    public void setIncomeId(int incomeId) { this.incomeId = incomeId; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getIncomeDate() { return incomeDate; }
    public void setIncomeDate(LocalDate incomeDate) { this.incomeDate = incomeDate; }

    @Override
    public String toString() {
        return "Income{" + "incomeId=" + incomeId + ", user=" + (user != null ? user.getUsername() : "null") +
                ", amount=" + amount + ", description='" + description + '\'' + ", incomeDate=" + incomeDate + '}';
    }
}
