package com.smartbudget.dao;

import com.smartbudget.database.DatabaseConnection;
import com.smartbudget.models.Budget;
import com.smartbudget.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BudgetDAO {

    // ADD BUDGET
    public boolean addBudget(
            int userId,
            int month,
            int year,
            double amount
    ) {

        String sql =
                "INSERT INTO budgets(user_id, month, year, amount) VALUES(?,?,?,?)";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, userId);
            statement.setInt(2, month);
            statement.setInt(3, year);
            statement.setDouble(4, amount);

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    // GET USER BUDGET
    public double getBudget(
            int userId,
            int month,
            int year
    ) {

        String sql =
                "SELECT amount FROM budgets WHERE user_id = ? AND month = ? AND year = ?";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, userId);
            statement.setInt(2, month);
            statement.setInt(3, year);

            ResultSet rs =
                    statement.executeQuery();

            if (rs.next()) {

                return rs.getDouble("amount");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return 0;
    }

    // GET USER BUDGETS
    public List<Budget> getBudgetsByUser(int userId) {
        List<Budget> list = new ArrayList<>();
        String sql = "SELECT * FROM budgets WHERE user_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserId(userId);
                list.add(new Budget(
                        rs.getInt("budget_id"),
                        user,
                        rs.getInt("month"),
                        rs.getInt("year"),
                        rs.getDouble("amount")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // GET BUDGET FOR PERIOD
    public Budget getBudgetForPeriod(int userId, int month, int year) {
        String sql = "SELECT * FROM budgets WHERE user_id = ? AND month = ? AND year = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, month);
            ps.setInt(3, year);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(userId);
                return new Budget(
                        rs.getInt("budget_id"),
                        user,
                        rs.getInt("month"),
                        rs.getInt("year"),
                        rs.getDouble("amount")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // GET SPENT FOR PERIOD
    public double getSpentForPeriod(int userId, int month, int year) {
        String sql = "SELECT SUM(amount) FROM expenses WHERE user_id = ? AND MONTH(expense_date) = ? AND YEAR(expense_date) = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, month);
            ps.setInt(3, year);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    // DELETE BUDGET
    public boolean deleteBudget(int budgetId) {
        String sql = "DELETE FROM budgets WHERE budget_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, budgetId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}