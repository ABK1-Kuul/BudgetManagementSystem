package com.smartbudget.services.impl;

import java.time.LocalDate;
import java.util.List;

import com.smartbudget.dao.IncomeDAO;
import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.models.Income;
import com.smartbudget.models.User;
import com.smartbudget.services.IncomeService;

public class IncomeServiceImpl implements IncomeService {

    private final IncomeDAO incomeDAO;

    public IncomeServiceImpl() {
        this(new IncomeDAO());
    }

    public IncomeServiceImpl(IncomeDAO incomeDAO) {
        this.incomeDAO = incomeDAO;
    }

    @Override
    public List<Income> getIncomesByUser(int userId) throws DatabaseException {
        if (userId <= 0) {
            return List.of();
        }
        return incomeDAO.findByUserId(userId);
    }

    @Override
    public Income addIncome(User user, double amount, String description, LocalDate date)
            throws ValidationException, DatabaseException {

        Income income = new Income();
        income.setUser(user);
        income.setAmount(amount);
        income.setDescription(description != null ? description.trim() : "");
        income.setIncomeDate(date);

        validateIncome(income);

        if (!incomeDAO.insert(income)) {
            throw new DatabaseException("Database error: Failed to record the income entry.");
        }
        return income;
    }

    @Override
    public boolean deleteIncome(int incomeId) throws DatabaseException {
        if (incomeId <= 0) {
            return false;
        }
        return incomeDAO.delete(incomeId);
    }

    @Override
    public void validateIncome(Income income) throws ValidationException {
        if (income == null) {
            throw new ValidationException("Income data cannot be empty.");
        }
        if (income.getUser() == null) {
            throw new ValidationException("A valid user session is required to record income.");
        }
        if (income.getAmount() <= 0) {
            throw new ValidationException("Income amount must be strictly greater than 0.00 ETB.");
        }
        if (income.getIncomeDate() == null) {
            throw new ValidationException("Please select a valid date.");
        }
        if (income.getIncomeDate().isAfter(LocalDate.now())) {
            throw new ValidationException("Cannot record income for future dates.");
        }
    }
}
