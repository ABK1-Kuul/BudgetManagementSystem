package com.smartbudget.services.impl;

import com.smartbudget.dao.IncomeDAO;
import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.services.IncomeService;
import com.smartbudget.models.Income;

import java.sql.Date;
import java.util.List;
/**
 * Concrete implementation for the IncomeService interface class where Member 2 manages income streams.
 * Fits right into our Week 2 Days 6-7 schedule!
 */

public class IncomeServiceImpl implements IncomeService{
    @Override
    public void addIncome(Income income) throws ValidationException{
        // Rule 1: Always validate before taking any action
        validateIncome(income);

        Date sqlDate = Date.valueOf(income.getIncomeDate());


        try{
            boolean saved = IncomeDAO.addIncome(
                    income.getUser().getUserId(),
                    income.getAmount(),
                    income.getDescription(),
                    sqlDate
            );

            if (!saved) {
                throw new ValidationException("Internal Database Error: Failed to save income entry.");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteIncome(int incomeId){
        // Guard check: Ensure we are dealing with a valid numeric ID reference
        if (incomeId > 0) {
            try{
                IncomeDAO.deleteIncome(incomeId);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    @Override
    public List<Income> getIncomeByUserId(int userId) {
        // Safe baseline fallback
        if (userId <= 0) {
            return List.of();
        }
        return IncomeDAO.getIncomeByUser(userId);

    }

    @Override
    public void validateIncome(Income income) throws ValidationException{
        // Guard Clause 1: Structural verification
        if (income == null) {
            throw new ValidationException("Income data package cannot be empty.");
        }

        // Guard Clause 2: Financial calculation check (No free or negative money allowed!)
        if (income.getAmount() <= 0) {
            throw new ValidationException("Income amount must be greater than 0.");
        }

        // Guard Clause 3: Description entry check
        if (income.getDescription() == null || income.getDescription().trim().isEmpty()) {
            throw new ValidationException("Source description cannot be left blank.");
        }

        // Guard Clause 4: User ownership association check
        if (income.getUser() == null || income.getUser().getUserId() <= 0) {
            throw new ValidationException("Income transaction must be linked to a valid registered user.");
        }
        // Guard Clause 5: Date selection check
        if (income.getIncomeDate() == null) {
            throw new ValidationException("Please choose a date for this income transaction.");
        }
    }
}



