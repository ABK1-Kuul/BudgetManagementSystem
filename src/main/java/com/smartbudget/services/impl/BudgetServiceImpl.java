package com.smartbudget.services.impl;

import com.smartbudget.dao.BudgetDAO;
import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.models.Budget;
import com.smartbudget.models.User;
import com.smartbudget.services.BudgetService;

import java.util.List;

public class BudgetServiceImpl implements BudgetService {

    private final BudgetDAO budgetDAO;

    public BudgetServiceImpl(BudgetDAO budgetDAO) {
        this.budgetDAO = budgetDAO;
    }

    @Override
    public void setBudget(User user, int month, int year, double amount) throws ValidationException {
        Budget testBudget = new Budget(0, user, month, year, amount);
        validateBudget(testBudget);

        boolean saved = budgetDAO.addBudget(user.getUserId(), month, year, amount);
        if (!saved) {
            throw new ValidationException("Internal Database Error: Failed to commit target budget plan setup.");
        }
    }

    @Override
    public List<Budget> getBudgetsByUser(int userId) {
        return userId <= 0 ? List.of() : budgetDAO.getBudgetsByUser(userId);
    }

    @Override
    public Budget getBudgetForPeriod(int userId, int month, int year) {
        if (userId <= 0 || month < 1 || month > 12) return null;
        return budgetDAO.getBudgetForPeriod(userId, month, year);
    }

    @Override
    public double getSpentForPeriod(int userId, int month, int year) {
        if (userId <= 0 || month < 1 || month > 12) return 0.0;
        return budgetDAO.getSpentForPeriod(userId, month, year);
    }

    @Override
    public void deleteBudget(int budgetId) {
        if (budgetId > 0) {
            budgetDAO.deleteBudget(budgetId);
        }
    }

    @Override
    public void validateBudget(Budget budget) throws ValidationException {
        if (budget == null) {
            throw new ValidationException("Budget data block context cannot be empty.");
        }
        if (budget.getUser() == null || budget.getUser().getUserId() <= 0) {
            throw new ValidationException("Budget setup must be assigned to an active registered session user.");
        }
        if (budget.getMonth() < 1 || budget.getMonth() > 12) {
            throw new ValidationException("Invalid month parameters selected.");
        }
        if (budget.getYear() < 2020 || budget.getYear() > 2040) {
            throw new ValidationException("Target planning year selection falls out of scope limits.");
        }
        if (budget.getAmount() <= 0) {
            throw new ValidationException("Budget allocation limit must be greater than 0 ETB.");
        }
    }
}