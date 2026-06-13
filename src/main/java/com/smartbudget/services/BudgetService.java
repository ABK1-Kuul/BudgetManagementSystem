package com.smartbudget.services;

import java.time.LocalDate;
import java.util.List;

import com.smartbudget.dao.BudgetDAO;
import com.smartbudget.dao.ExpenseDAO;
import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.models.Budget;
import com.smartbudget.models.Expense;
import com.smartbudget.models.User;

/**
 * Service class for managing monthly Budgets.
 * Demonstrates composition of data layers to perform complex calculations.
 */
public class BudgetService {

    private final BudgetDAO budgetDAO;
    private final ExpenseDAO expenseDAO;

    public BudgetService() {
        this.budgetDAO = new BudgetDAO();
        this.expenseDAO = new ExpenseDAO();
    }

    /**
     * Fetch a user's budget list.
     */
    public List<Budget> getBudgetsByUser(int userId) throws DatabaseException {
        return budgetDAO.findByUserId(userId);
    }

    /**
     * Get active budget for specific user during a specific month/year.
     */
    public Budget getBudgetForPeriod(int userId, int month, int year) throws DatabaseException {
        return budgetDAO.findByUserAndPeriod(userId, month, year);
    }

    /**
     * Save or update a monthly budget value.
     */
    public Budget setBudget(User user, int month, int year, double amount) 
            throws ValidationException, DatabaseException {
        
        if (user == null) {
            throw new ValidationException("User session is required to establish a budget.");
        }
        if (month < 1 || month > 12) {
            throw new ValidationException("Invalid month provided.");
        }
        if (year < 1900 || year > 2100) {
            throw new ValidationException("Invalid year provided.");
        }
        if (amount <= 0) {
            throw new ValidationException("Budget amount must be strictly greater than 0.00 ETB.");
        }

        // Check if budget already exists for this period
        Budget existing = budgetDAO.findByUserAndPeriod(user.getUserId(), month, year);
        if (existing != null) {
            existing.setAmount(amount);
            boolean success = budgetDAO.update(existing);
            if (!success) {
                throw new DatabaseException("Database error: Failed to update the budget record.");
            }
            return existing;
        } else {
            Budget budget = new Budget();
            budget.setUser(user);
            budget.setMonth(month);
            budget.setYear(year);
            budget.setAmount(amount);

            boolean success = budgetDAO.insert(budget);
            if (!success) {
                throw new DatabaseException("Database error: Failed to create the new budget entry.");
            }
            return budget;
        }
    }

    /**
     * Compute remaining budget balance for a given month and year.
     * Demonstrates Aggregation/Composition of Expense calculations.
     */
    public double getRemainingBudget(int userId, int month, int year) throws DatabaseException {
        Budget budget = getBudgetForPeriod(userId, month, year);
        if (budget == null) {
            return 0.00;
        }

        double totalBudget = budget.getAmount();
        double totalSpent = getSpentForPeriod(userId, month, year);

        return totalBudget - totalSpent;
    }

    /**
     * Calculate sum of expenses for a specific month and year.
     */
    public double getSpentForPeriod(int userId, int month, int year) throws DatabaseException {
        List<Expense> expenses = expenseDAO.findByUserId(userId);
        double totalSpent = 0.00;

        for (Expense expense : expenses) {
            LocalDate expDate = expense.getExpenseDate();
            if (expDate != null && expDate.getMonthValue() == month && expDate.getYear() == year) {
                totalSpent += expense.getAmount();
            }
        }
        return totalSpent;
    }

    /**
     * Delete a budget plan by its identifier.
     */
    public boolean deleteBudget(int budgetId) throws DatabaseException {
        return budgetDAO.delete(budgetId);
    }
}
