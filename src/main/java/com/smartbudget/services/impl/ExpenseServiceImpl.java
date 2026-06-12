package com.smartbudget.services.impl;

import com.smartbudget.models.Expense;
import com.smartbudget.services.ExpenseService;
import com.smartbudget.exceptions.ValidationException;

import java.util.List;

/**
 * "implements ExpenseService" means we are signing the legal contract to provide code
 * for all the methods declared in the interface.
 */

public class ExpenseServiceImpl implements ExpenseService{
    @Override
    public void addExpense(Expense expense) throws ValidationException{
        // Step 1: Run our check rules first
        validateExpense(expense);
        // Step 2: (Days 3-5 objective) If it passes validation, print success to console
        System.out.println("Business Logic Passed! Ready for Member 1's DAO: " + expense);
    }

    @Override
    public void deleteExpense(int expenseId) {
        if (expenseId > 0) {
            System.out.println("Deleting expense entry with ID: " + expenseId);
        }
    }

    @Override
    public List<Expense> getExpensesByUserId(int userId) {
        if (userId <= 0) {
            return List.of(); // Return a safe empty array list if user ID is bad
        }
        return List.of(); // Temporary baseline empty list until Member 1 links DAO
    }

    @Override
    public void validateExpense(Expense expense) throws ValidationException {
        // Rule A: The object must exist
        if (expense == null) {
            throw new ValidationException("Expense data package cannot be empty.");
        }

        // Rule B: The Core Financial Calculation Check
        if (expense.getAmount() <= 0) {
            throw new ValidationException("Transaction amount must be greater than 0.");
        }

        // Rule C: Text entry checks
        if (expense.getDescription() == null || expense.getDescription().trim().isEmpty()) {
            throw new ValidationException("Description field cannot be left blank.");
        }

        // Rule D: Association checks
        if (expense.getUser() == null || expense.getUser().getUserId() <= 0) {
            throw new ValidationException("Transaction must belong to a valid registered user.");
        }

        if (expense.getCategory() == null) {
            throw new ValidationException("Please choose a budget category.");
        }
        if (expense.getExpenseDate() == null) {
            throw new ValidationException("A date must be selected for this transaction.");
        }
    }

}