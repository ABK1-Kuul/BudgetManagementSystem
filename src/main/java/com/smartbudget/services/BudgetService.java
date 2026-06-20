package com.smartbudget.services;

import java.util.List;

import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.models.Budget;
import com.smartbudget.models.User;

public interface BudgetService {

    List<Budget> getBudgetsByUser(int userId) throws DatabaseException;

    Budget getBudgetForPeriod(int userId, int month, int year) throws DatabaseException;

    Budget setBudget(User user, int month, int year, double amount)
            throws ValidationException, DatabaseException;

    double getSpentForPeriod(int userId, int month, int year) throws DatabaseException;

    double getRemainingBudget(int userId, int month, int year) throws DatabaseException;

    boolean deleteBudget(int budgetId) throws DatabaseException;

    void validateBudget(Budget budget) throws ValidationException;
}
