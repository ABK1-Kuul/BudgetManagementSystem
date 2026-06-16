package com.smartbudget.dao;

import com.smartbudget.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncomeDAO {

    // ADD INCOME
    public boolean addIncome(int userId, double amount, String description, Date date) {

        String sql = "INSERT INTO incomes(user_id, amount, description, income_date) VALUES(?,?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setDouble(2, amount);
            ps.setString(3, description);
            ps.setDate(4, date);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // GET INCOME BY USER
    public List<String> getIncomeByUser(int userId) {

        List<String> list = new ArrayList<>();

        String sql = "SELECT * FROM incomes WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(
                        "Amount: " + rs.getDouble("amount") +
                        " | Desc: " + rs.getString("description") +
                        " | Date: " + rs.getDate("income_date")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // DELETE INCOME
    public boolean deleteIncome(int incomeId) {

        String sql = "DELETE FROM incomes WHERE income_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, incomeId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}