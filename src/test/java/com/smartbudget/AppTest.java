package com.smartbudget;

import com.smartbudget.dao.UserDAO;
import com.smartbudget.dao.ExpenseDAO;
import com.smartbudget.dao.IncomeDAO;
import com.smartbudget.dao.CategoryDAO;
import com.smartbudget.dao.BudgetDAO;
import com.smartbudget.models.User;

import java.sql.Date;

public class AppTest {

    public static void main(String[] args) {

        // =========================
        // USER TEST
        // =========================
        System.out.println("=== USER TEST ===");

        UserDAO userDAO = new UserDAO();

        String username = "test_" + System.currentTimeMillis();
        String email = username + "@gmail.com";

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword("1234");

        boolean created = userDAO.createUser(user);
        System.out.println("User created: " + created);

        User found = userDAO.findByUsername(username);

        if (found != null) {
            System.out.println("User found: " + found.getUsername());
        } else {
            System.out.println("User NOT found");
        }

        int userId = (found != null) ? found.getUserId() : 1;

        // =========================
        // EXPENSE TEST
        // =========================
        System.out.println("\n=== EXPENSE TEST ===");

        ExpenseDAO expenseDAO = new ExpenseDAO();

        boolean expenseAdded = expenseDAO.addExpense(
                userId,
                1,
                100.0,
                "Food Test",
                new Date(System.currentTimeMillis())
        );

        System.out.println("Expense added: " + expenseAdded);

        // =========================
        // INCOME TEST
        // =========================
        System.out.println("\n=== INCOME TEST ===");

        IncomeDAO incomeDAO = new IncomeDAO();

        boolean incomeAdded = incomeDAO.addIncome(
                userId,
                500.0,
                "Salary Test",
                new Date(System.currentTimeMillis())
        );

        System.out.println("Income added: " + incomeAdded);

        // =========================
        // CATEGORY TEST
        // =========================
        System.out.println("\n=== CATEGORY TEST ===");

        CategoryDAO categoryDAO = new CategoryDAO();

        String categoryName = "Food_" + System.currentTimeMillis();

        boolean categoryAdded = categoryDAO.addCategory(categoryName);
        System.out.println("Category added: " + categoryAdded);

        System.out.println("All categories:");

        for (String c : categoryDAO.getAllCategories()) {
            System.out.println("- " + c);
        }

        // =========================
        // BUDGET TEST
        // =========================
        System.out.println("\n=== BUDGET TEST ===");

        BudgetDAO budgetDAO = new BudgetDAO();

        boolean budgetAdded = budgetDAO.addBudget(
                userId,
                6,
                2026,
                5000.0
        );

        System.out.println("Budget added: " + budgetAdded);

        double budget = budgetDAO.getBudget(
                userId,
                6,
                2026
        );

        System.out.println("Retrieved Budget: " + budget);

        // =========================
        // DONE
        // =========================
        System.out.println("\n=== TEST COMPLETED ===");
    }
}