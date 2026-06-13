package com.smartbudget.services;

import java.util.ArrayList;
import java.util.List;

import com.smartbudget.dao.ExpenseDAO;
import com.smartbudget.dao.IncomeDAO;
import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.models.Expense;
import com.smartbudget.models.Income;
import com.smartbudget.models.Transaction;

/**
 * Service class for Dashboard aggregation metrics.
 * Demonstrates the power of Polymorphism by managing subclass instances uniformly 
 * under a common parent superclass reference.
 */
public class DashboardService {

    private final ExpenseDAO expenseDAO;
    private final IncomeDAO incomeDAO;

    public DashboardService() {
        this.expenseDAO = new ExpenseDAO();
        this.incomeDAO = new IncomeDAO();
    }

    /**
     * Retrieve a polymorphic list of all transactions (Expenses and Incomes) for a user.
     * Demonstrates Polymorphism: treating subclasses (Expense, Income) as their parent (Transaction).
     */
    public List<Transaction> getAllTransactions(int userId) throws DatabaseException {
        List<Transaction> transactions = new ArrayList<>();
        
        // Load expenses (Subclass 1)
        List<Expense> expenses = expenseDAO.findByUserId(userId);
        transactions.addAll(expenses);
        
        // Load incomes (Subclass 2)
        List<Income> incomes = incomeDAO.findByUserId(userId);
        transactions.addAll(incomes);
        
        // Sort transactions by date descending (optional sorting using custom comparator or standard library)
        transactions.sort((t1, t2) -> {
            if (t1.getDate() == null || t2.getDate() == null) return 0;
            return t2.getDate().compareTo(t1.getDate());
        });
        
        return transactions;
    }

    /**
     * Compute total income recorded for a user.
     */
    public double getTotalIncome(int userId) throws DatabaseException {
        List<Income> incomes = incomeDAO.findByUserId(userId);
        double total = 0.00;
        for (Income income : incomes) {
            total += income.getAmount();
        }
        return total;
    }

    /**
     * Compute total expenses recorded for a user.
     */
    public double getTotalExpenses(int userId) throws DatabaseException {
        List<Expense> expenses = expenseDAO.findByUserId(userId);
        double total = 0.00;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }

    /**
     * Compute the remaining net balance for a user.
     * Demonstrates Polymorphism and Abstraction by invoking the overridden polymorphic 'getSignedAmount()' method.
     */
    public double getNetBalance(int userId) throws DatabaseException {
        List<Transaction> transactions = getAllTransactions(userId);
        double balance = 0.00;
        
        for (Transaction transaction : transactions) {
            // Polymorphic call: Expense returns negative, Income returns positive.
            balance += transaction.getSignedAmount();
        }
        return balance;
    }
}
