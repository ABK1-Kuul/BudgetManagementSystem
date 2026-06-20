package com.smartbudget.dao;

import com.smartbudget.database.DatabaseConnection;
import com.smartbudget.models.Expense;
import com.smartbudget.models.User;
import com.smartbudget.models.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {

    // ADD EXPENSE
    public boolean addExpense(int userId, int categoryId, double amount, String description, Date date) {

        String sql = "INSERT INTO expenses(user_id, category_id, amount, description, expense_date) VALUES(?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, categoryId);
            ps.setDouble(3, amount);
            ps.setString(4, description);
            ps.setDate(5, date);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // GET EXPENSES BY USER
    public List<Expense> getExpensesByUser(int userId) {

        List<Expense> list = new ArrayList<>();

        String sql = "SELECT * FROM expenses WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setUserId(userId);

                Category category = new Category();
                category.setCategoryId(rs.getInt("category_id"));

                Date expDate = rs.getDate("expense_date");
                java.time.LocalDate localDate = (expDate != null) ? expDate.toLocalDate() : null;

                Expense expense = new Expense(
                        rs.getInt("expense_id"),
                        user,
                        category,
                        rs.getDouble("amount"),
                        rs.getString("description"),
                        localDate
                );
                list.add(expense);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // DELETE EXPENSE
    public boolean deleteExpense(int expenseId) {

        String sql = "DELETE FROM expenses WHERE expense_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, expenseId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}