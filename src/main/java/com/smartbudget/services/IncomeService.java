package com.smartbudget.services;

import java.time.LocalDate;
import java.util.List;

import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.models.Income;
import com.smartbudget.models.User;

public interface IncomeService {

    List<Income> getIncomesByUser(int userId) throws DatabaseException;

    Income addIncome(User user, double amount, String description, LocalDate date)
            throws ValidationException, DatabaseException;

    boolean deleteIncome(int incomeId) throws DatabaseException;

    void validateIncome(Income income) throws ValidationException;
}
