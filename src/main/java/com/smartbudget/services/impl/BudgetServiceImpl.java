package com.smartbudget.services.impl;

import java.util.List;

import com.smartbudget.dao.BudgetDAO;
import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.models.Budget;
import com.smartbudget.models.User;
import com.smartbudget.services.BudgetService;

public class BudgetServiceImpl implements BudgetService {

    private final BudgetDAO budgetDAO;

    public BudgetServiceImpl() {
        this(new BudgetDAO());
    }

    public BudgetServiceImpl(BudgetDAO budgetDAO) {
        this.budgetDAO = budgetDAO;
    }

    @Override
    public List<Budget> getBudgetsByUser(int userId) throws DatabaseException {
        if (userId <= 0) {
            return List.of();
        }
        return budgetDAO.findByUserId(userId);
    }

    @Override
    public Budget getBudgetForPeriod(int userId, int month, int year) throws DatabaseException {
        if (userId <= 0 || month < 1 || month > 12) {
            return null;
        }
        return budgetDAO.findByUserAndPeriod(userId, month, year);
    }

    @Override
    public Budget setBudget(User user, int month, int year, double amount)
            throws ValidationException, DatabaseException {

        Budget budget = new Budget();
        budget.setUser(user);
        budget.setMonth(month);
        budget.setYear(year);
        budget.setAmount(amount);
        validateBudget(budget);

        Budget existing = budgetDAO.findByUserAndPeriod(user.getUserId(), month, year);
        if (existing != null) {
            existing.setAmount(amount);
            if (!budgetDAO.update(existing)) {
                throw new DatabaseException("Database error: Failed to update the budget record.");
            }
            return existing;
        }

        if (!budgetDAO.insert(budget)) {
            throw new DatabaseException("Database error: Failed to create the new budget entry.");
        }
        return budget;
    }

    @Override
    public double getSpentForPeriod(int userId, int month, int year) throws DatabaseException {
        if (userId <= 0 || month < 1 || month > 12) {
            return 0.0;
        }
        return budgetDAO.getSpentForPeriod(userId, month, year);
    }

    @Override
    public double getRemainingBudget(int userId, int month, int year) throws DatabaseException {
        Budget budget = getBudgetForPeriod(userId, month, year);
        if (budget == null) {
            return 0.0;
        }
        return budget.getAmount() - getSpentForPeriod(userId, month, year);
    }

    @Override
    public boolean deleteBudget(int budgetId) throws DatabaseException {
        if (budgetId <= 0) {
            return false;
        }
        return budgetDAO.delete(budgetId);
    }

    @Override
    public void validateBudget(Budget budget) throws ValidationException {
        if (budget == null) {
            throw new ValidationException("Budget data cannot be empty.");
        }
        if (budget.getUser() == null) {
            throw new ValidationException("User session is required to establish a budget.");
        }
        if (budget.getMonth() < 1 || budget.getMonth() > 12) {
            throw new ValidationException("Invalid month provided.");
        }
        if (budget.getYear() < 1900 || budget.getYear() > 2100) {
            throw new ValidationException("Invalid year provided.");
        }
        if (budget.getAmount() <= 0) {
            throw new ValidationException("Budget amount must be strictly greater than 0.00 ETB.");
        }
    }
}
