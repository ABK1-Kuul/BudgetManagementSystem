package com.smartbudget.models;

import java.time.LocalDate;

import com.smartbudget.exceptions.ValidationException;

/**
 * Class representing an Income transaction.
 * Demonstrates the OOP principle of Inheritance (extends Transaction).
 */
public class Income extends Transaction {

    // No-Args Constructor
    public Income() {
        super();
    }

    // Parameterized Constructor
    public Income(int incomeId, User user, double amount, String description, LocalDate incomeDate) throws ValidationException {
        // Call parent class constructor to initialize common fields
        super(incomeId, user, amount, description, incomeDate);
    }

    // Implement Abstraction contract: returns the transaction category type description
    @Override
    public String getTransactionType() {
        return "Income";
    }

    // Implement Polymorphic signed amount contract: Incomes are positive cash flows
    @Override
    public double getSignedAmount() {
        return amount;
    }

    // Backward compatibility delegates: map standard names to parent class Transaction fields
    public int getIncomeId() {
        return getId();
    }

    public void setIncomeId(int incomeId) {
        setId(incomeId);
    }

    public LocalDate getIncomeDate() {
        return getDate();
    }

    public void setIncomeDate(LocalDate incomeDate) {
        setDate(incomeDate);
    }

    @Override
    public String toString() {
        return "Income{" +
                "incomeId=" + getIncomeId() +
                ", user=" + (user != null ? user.getUsername() : "null") +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", incomeDate=" + getIncomeDate() +
                '}';
    }
}
