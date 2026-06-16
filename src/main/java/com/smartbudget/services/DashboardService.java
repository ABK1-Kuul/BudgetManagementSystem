package com.smartbudget.services;

import java.util.Map;

public interface DashboardService {

    // Sums every single income transaction ever recorded by the user
    double getTotalIncome(int userId);

    // Sums every single expense transaction ever recorded by the user
    double getTotalExpenses(int userId);

    // Calculates net cash position: (Total Income - Total Expenses)
    double getNetBalance(int userId);

    // Aggregates spending by group categories, ideal for chart rendering later
    // Returns data grouped like: {"Food" -> 450.00, "Rent" -> 1200.00}
    Map<String, Double> getExpenseDistributionByCategory(int userId);
}