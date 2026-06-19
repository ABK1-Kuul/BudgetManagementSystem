package com.smartbudget.services;

import com.smartbudget.models.Income;
import com.smartbudget.exceptions.ValidationException;

import java.util.List;


public interface IncomeService {
    // Validates earnings, throws exception on failure, otherwise saves via DAO
    void addIncome(Income income) throws ValidationException;

    // Deletes an income item by its unique database key
    void deleteIncome(int incomeId);

    // Retrieves all recorded revenue entries for a specific user profile
    List<Income> getIncomeByUser(int userId);

    // Pure business logic validation method signature
    void validateIncome(Income income) throws ValidationException;

}
