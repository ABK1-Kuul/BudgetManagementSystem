package com.smartbudget.services.impl;

import java.time.LocalDate;
import java.util.List;

import com.smartbudget.dao.CategoryDAO;
import com.smartbudget.dao.ExpenseDAO;
import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.models.Category;
import com.smartbudget.models.Expense;
import com.smartbudget.models.User;
import com.smartbudget.services.ExpenseService;

public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseDAO expenseDAO;
    private final CategoryDAO categoryDAO;

    public ExpenseServiceImpl() {
        this(new ExpenseDAO(), new CategoryDAO());
    }

    public ExpenseServiceImpl(ExpenseDAO expenseDAO, CategoryDAO categoryDAO) {
        this.expenseDAO = expenseDAO;
        this.categoryDAO = categoryDAO;
    }

    @Override
    public List<Category> getCategories() throws DatabaseException {
        return categoryDAO.getAllCategories();
    }

    @Override
    public List<Expense> getExpensesByUser(int userId) throws DatabaseException {
        if (userId <= 0) {
            return List.of();
        }
        return expenseDAO.findByUserId(userId);
    }

    @Override
    public Expense addExpense(User user, Category category, double amount, String description, LocalDate date)
            throws ValidationException, DatabaseException {

        Expense expense = new Expense();
        expense.setUser(user);
        expense.setCategory(category);
        expense.setAmount(amount);
        expense.setDescription(description != null ? description.trim() : "");
        expense.setExpenseDate(date);

        validateExpense(expense);

        if (!expenseDAO.insert(expense)) {
            throw new DatabaseException("Database error: Failed to record the expense entry.");
        }
        return expense;
    }

    @Override
    public boolean deleteExpense(int expenseId) throws DatabaseException {
        if (expenseId <= 0) {
            return false;
        }
        return expenseDAO.delete(expenseId);
    }

    @Override
    public void validateExpense(Expense expense) throws ValidationException {
        if (expense == null) {
            throw new ValidationException("Expense data cannot be empty.");
        }
        if (expense.getUser() == null) {
            throw new ValidationException("A valid user session is required to record an expense.");
        }
        if (expense.getCategory() == null) {
            throw new ValidationException("Please select a transaction category.");
        }
        if (expense.getAmount() <= 0) {
            throw new ValidationException("Expense amount must be strictly greater than 0.00 ETB.");
        }
        if (expense.getExpenseDate() == null) {
            throw new ValidationException("Please select a valid date.");
        }
        if (expense.getExpenseDate().isAfter(LocalDate.now())) {
            throw new ValidationException("Cannot record expenses for future dates.");
        }
    }
}
