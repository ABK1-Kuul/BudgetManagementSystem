package com.smartbudget.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smartbudget.dao.ExpenseDAO;
import com.smartbudget.dao.IncomeDAO;
import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.models.Expense;
import com.smartbudget.models.Income;
import com.smartbudget.services.DashboardService;

public class DashboardServiceImpl implements DashboardService {

    private final ExpenseDAO expenseDAO;
    private final IncomeDAO incomeDAO;

    public DashboardServiceImpl() {
        this(new ExpenseDAO(), new IncomeDAO());
    }

    public DashboardServiceImpl(ExpenseDAO expenseDAO, IncomeDAO incomeDAO) {
        this.expenseDAO = expenseDAO;
        this.incomeDAO = incomeDAO;
    }

    @Override
    public double getTotalIncome(int userId) throws DatabaseException {
        List<Income> incomes = incomeDAO.findByUserId(userId);
        double total = 0.0;
        for (Income income : incomes) {
            total += income.getAmount();
        }
        return total;
    }

    @Override
    public double getTotalExpenses(int userId) throws DatabaseException {
        List<Expense> expenses = expenseDAO.findByUserId(userId);
        double total = 0.0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }

    @Override
    public double getNetBalance(int userId) throws DatabaseException {
        return getTotalIncome(userId) - getTotalExpenses(userId);
    }

    @Override
    public Map<String, Double> getExpenseDistributionByCategory(int userId) throws DatabaseException {
        List<Expense> expenses = expenseDAO.findByUserId(userId);
        Map<String, Double> distribution = new HashMap<>();

        for (Expense expense : expenses) {
            if (expense.getCategory() == null) {
                continue;
            }
            String categoryName = expense.getCategory().getCategoryName();
            distribution.merge(categoryName, expense.getAmount(), Double::sum);
        }
        return distribution;
    }
}
