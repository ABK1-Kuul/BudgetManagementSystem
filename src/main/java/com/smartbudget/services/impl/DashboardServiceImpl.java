package com.smartbudget.services.impl;

import com.smartbudget.models.Expense;
import com.smartbudget.models.Income;
import com.smartbudget.services.DashboardService;
import com.smartbudget.services.ExpenseService;
import com.smartbudget.services.IncomeService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DashboardServiceImpl implements DashboardService {

    private final ExpenseService expenseService;
    private final IncomeService incomeService;

    // Constructor Injection to link our transaction services
    public DashboardServiceImpl(ExpenseService expenseService, IncomeService incomeService) {
        this.expenseService = expenseService;
        this.incomeService = incomeService;
    }

    @Override
    public double getTotalIncome(int userId) {
        List<Income> incomes = incomeService.getIncomesByUser(userId);

        // ASSEMBLY LINE: Turn list to stream -> extract amounts -> sum them up!
        return incomes.stream()
                .mapToDouble(income -> income.getAmount())
                .sum();
    }

    @Override
    public double getTotalExpenses(int userId) {
        List<Expense> expenses = expenseService.getExpensesByUser(userId);

        // ASSEMBLY LINE: Stream -> extract amounts -> sum them up!
        return expenses.stream()
                .mapToDouble(expense -> expense.getAmount())
                .sum();
    }

    @Override
    public double getNetBalance(int userId) {
        // Business Calculation: Net cash flow position
        return getTotalIncome(userId) - getTotalExpenses(userId);
    }

    @Override
    public Map<String, Double> getExpenseDistributionByCategory(int userId) {
        List<Expense> expenses = expenseService.getExpensesByUser(userId);

        // Advanced Stream: Groups items by their Category Name and sums up the total money per group
        return expenses.stream()
                .filter(e -> e.getCategory() != null)
                .collect(Collectors.groupingBy(
                        expense -> expense.getCategory().getCategoryName(),
                        Collectors.summingDouble(expense -> expense.getAmount())
                ));
    }
}