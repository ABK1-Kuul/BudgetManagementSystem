package com.smartbudget.services;

import java.time.LocalDate;
import java.util.List;

import com.smartbudget.dao.CategoryDAO;
import com.smartbudget.dao.ExpenseDAO;
import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.models.Category;
import com.smartbudget.models.Expense;
import com.smartbudget.models.User;

/**
 * Service class for managing Expense transactions.
 * Coordinates between controller layer and DAO layer, implementing business validations.
 * Demonstrates the OOP concept of Separation of Concerns.
 */
public class ExpenseService {

    private final ExpenseDAO expenseDAO;
    private final CategoryDAO categoryDAO;

    public ExpenseService() {
        this.expenseDAO = new ExpenseDAO();
        this.categoryDAO = new CategoryDAO();
    }

    /**
     * Retrieve all available expense categories.
     */
    public List<Category> getCategories() throws DatabaseException {
        return categoryDAO.getAllCategories();
    }

    /**
     * Retrieve expenses associated with a specific user.
     */
    public List<Expense> getExpensesByUser(int userId) throws DatabaseException {
        return expenseDAO.findByUserId(userId);
    }

    /**
     * Validate and create a new Expense transaction.
     * Demonstrates strict Validation and Defensive Programming.
     */
    public Expense addExpense(User user, Category category, double amount, String description, LocalDate date) 
            throws ValidationException, DatabaseException {
        
        // Input Validations
        if (user == null) {
            throw new ValidationException("A valid user session is required to record an expense.");
        }
        if (category == null) {
            throw new ValidationException("Please select a transaction category.");
        }
        if (amount <= 0) {
            throw new ValidationException("Expense amount must be strictly greater than 0.00 ETB.");
        }
        if (date == null) {
            throw new ValidationException("Please select a valid date.");
        }
        if (date.isAfter(LocalDate.now())) {
            throw new ValidationException("Cannot record expenses for future dates.");
        }

        // Create and populate the polymorphic model object
        Expense expense = new Expense();
        expense.setUser(user);
        expense.setCategory(category);
        expense.setAmount(amount);
        expense.setDescription(description != null ? description.trim() : "");
        expense.setExpenseDate(date);

        // Persist via Data Access Layer
        boolean success = expenseDAO.insert(expense);
        if (!success) {
            throw new DatabaseException("Database error: Failed to record the expense entry.");
        }
        return expense;
    }

    /**
     * Delete an expense transaction by its unique identifier.
     */
    public boolean deleteExpense(int expenseId) throws DatabaseException {
        return expenseDAO.delete(expenseId);
    }
}
