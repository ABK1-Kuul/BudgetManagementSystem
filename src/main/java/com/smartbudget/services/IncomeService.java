package com.smartbudget.services;

import java.time.LocalDate;
import java.util.List;

import com.smartbudget.dao.IncomeDAO;
import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.models.Income;
import com.smartbudget.models.User;

/**
 * Service class for managing Income transactions.
 * Coordinates between controller layer and DAO layer, implementing business validations.
 * Demonstrates the OOP concept of Separation of Concerns.
 */
public class IncomeService {

    private final IncomeDAO incomeDAO;

    public IncomeService() {
        this.incomeDAO = new IncomeDAO();
    }

    /**
     * Retrieve incomes associated with a specific user.
     */
    public List<Income> getIncomesByUser(int userId) throws DatabaseException {
        return incomeDAO.findByUserId(userId);
    }

    /**
     * Validate and create a new Income transaction.
     * Demonstrates strict Validation and Defensive Programming.
     */
    public Income addIncome(User user, double amount, String description, LocalDate date) 
            throws ValidationException, DatabaseException {
        
        // Input Validations
        if (user == null) {
            throw new ValidationException("A valid user session is required to record income.");
        }
        if (amount <= 0) {
            throw new ValidationException("Income amount must be strictly greater than 0.00 ETB.");
        }
        if (date == null) {
            throw new ValidationException("Please select a valid date.");
        }
        if (date.isAfter(LocalDate.now())) {
            throw new ValidationException("Cannot record income for future dates.");
        }

        // Create and populate the polymorphic model object
        Income income = new Income();
        income.setUser(user);
        income.setAmount(amount);
        income.setDescription(description != null ? description.trim() : "");
        income.setIncomeDate(date);

        // Persist via Data Access Layer
        boolean success = incomeDAO.insert(income);
        if (!success) {
            throw new DatabaseException("Database error: Failed to record the income entry.");
        }
        return income;
    }

    /**
     * Delete an income transaction by its unique identifier.
     */
    public boolean deleteIncome(int incomeId) throws DatabaseException {
        return incomeDAO.delete(incomeId);
    }
}
