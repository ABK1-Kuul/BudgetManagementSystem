package com.smartbudget;

import com.smartbudget.dao.BudgetDAO;
import com.smartbudget.dao.CategoryDAO;
import com.smartbudget.dao.ExpenseDAO;
import com.smartbudget.dao.IncomeDAO;
import com.smartbudget.dao.UserDAO;
import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.models.Budget;
import com.smartbudget.models.Category;
import com.smartbudget.models.Expense;
import com.smartbudget.models.Income;
import com.smartbudget.models.User;

import java.time.LocalDate;

/**
 * Manual integration runner for DAO layer (requires running MySQL with schema applied).
 */
public class MainTestRunner {

    public static void main(String[] args) throws DatabaseException, ValidationException {
        System.out.println("=== USER TEST ===");
        UserDAO userDAO = new UserDAO();

        String username = "test_" + System.currentTimeMillis();
        User user = new User();
        user.setUsername(username);
        user.setEmail(username + "@gmail.com");
        user.setPassword("123456");

        User created = userDAO.register(user);
        System.out.println("User created: " + (created != null));

        User found = userDAO.findByUsername(username);
        if (found == null) {
            System.out.println("User NOT found — stopping tests.");
            return;
        }
        System.out.println("User found: " + found.getUsername());
        int userId = found.getUserId();

        System.out.println("\n=== EXPENSE TEST ===");
        ExpenseDAO expenseDAO = new ExpenseDAO();
        Category category = new CategoryDAO().getAllCategories().get(0);

        Expense expense = new Expense();
        expense.setUser(found);
        expense.setCategory(category);
        expense.setAmount(100.0);
        expense.setDescription("Food Test");
        expense.setExpenseDate(LocalDate.now());
        System.out.println("Expense added: " + expenseDAO.insert(expense));

        System.out.println("\n=== INCOME TEST ===");
        IncomeDAO incomeDAO = new IncomeDAO();
        Income income = new Income();
        income.setUser(found);
        income.setAmount(500.0);
        income.setDescription("Salary Test");
        income.setIncomeDate(LocalDate.now());
        System.out.println("Income added: " + incomeDAO.insert(income));

        System.out.println("\n=== CATEGORY TEST ===");
        CategoryDAO categoryDAO = new CategoryDAO();
        System.out.println("All categories:");
        for (Category c : categoryDAO.getAllCategories()) {
            System.out.println("- " + c.getCategoryName());
        }

        System.out.println("\n=== BUDGET TEST ===");
        BudgetDAO budgetDAO = new BudgetDAO();
        Budget budget = new Budget();
        budget.setUser(found);
        budget.setMonth(LocalDate.now().getMonthValue());
        budget.setYear(LocalDate.now().getYear());
        budget.setAmount(5000.0);
        System.out.println("Budget added: " + budgetDAO.insert(budget));

        Budget saved = budgetDAO.findByUserAndPeriod(userId, budget.getMonth(), budget.getYear());
        System.out.println("Retrieved Budget: " + (saved != null ? saved.getAmount() : 0));

        System.out.println("\n=== TEST COMPLETED ===");
    }
}
