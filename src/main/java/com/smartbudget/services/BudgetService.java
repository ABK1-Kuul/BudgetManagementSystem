package com.smartbudget.services;

import com.smartbudget.models.Budget;
import com.smartbudget.models.User;
import com.smartbudget.exceptions.ValidationException;
import java.util.List;

public interface BudgetService {
    void setBudget(User user, int month, int year, double amount) throws ValidationException;
    List<Budget> getBudgetsByUser(int userId);
    Budget getBudgetForPeriod(int userId, int month, int year);
    double getSpentForPeriod(int userId, int month, int year);
    void deleteBudget(int budgetId);
    void validateBudget(Budget budget) throws ValidationException;
}