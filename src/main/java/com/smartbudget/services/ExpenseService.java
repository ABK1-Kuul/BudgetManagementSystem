package com.smartbudget.services;

import com.smartbudget.models.Expense;
import com.smartbudget.exceptions.ValidationException;
import java.util.List;


public interface ExpenseService {
    // Validates inputs, throws custom exception on failure, otherwise saves via DAO
    void addExpense(Expense expense) throws ValidationException;
    // Deletes an expense item by its unique database key
    void deleteExpense(int expenseId);
    // Retreives all recorded expenditures for a specific user profile
    List<Expense> getExpensesByUser(int userId);
    // Pure business logic validation method signature
    void validateExpense(Expense expense) throws ValidationException;

}

