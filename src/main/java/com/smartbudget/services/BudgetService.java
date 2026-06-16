package com.smartbudget.services;

import com.smartbudget.models.Budget;
import com.smartbudget.exceptions.ValidationException;
import java.util.List;

public interface BudgetService {

    // Sets a spending limit cap for a category (e.g., $300 max for "Food")
    void setBudgetLimit(Budget budget) throws ValidationException;

    // Retrieves a specific category budget setup for a user
    Budget getBudgetByCategory(int userId, int categoryId);

    // Retrieves all active category limits set up by a specific user
    List<Budget> getBudgetsByUserId(int userId);

    // Checks if a new layout setup violates basic logic parameters
    void validateBudget(Budget budget) throws ValidationException;
}