package com.smartbudget.services;

import java.time.LocalDate;
import java.util.List;

import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.models.Category;
import com.smartbudget.models.Expense;
import com.smartbudget.models.User;

public interface ExpenseService {

    List<Category> getCategories() throws DatabaseException;

    List<Expense> getExpensesByUser(int userId) throws DatabaseException;

    Expense addExpense(User user, Category category, double amount, String description, LocalDate date)
            throws ValidationException, DatabaseException;

    boolean deleteExpense(int expenseId) throws DatabaseException;

    void validateExpense(Expense expense) throws ValidationException;
}
