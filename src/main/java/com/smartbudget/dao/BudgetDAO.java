package com.smartbudget.dao;

import com.smartbudget.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}