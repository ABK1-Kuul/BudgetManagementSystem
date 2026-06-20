package com.smartbudget.dao;

import com.smartbudget.database.DatabaseConnection;
import com.smartbudget.models.Income;
import com.smartbudget.models.User;

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
    public List<Income> getIncomeByUser(int userId) {

        List<Income> list = new ArrayList<>();

        String sql = "SELECT * FROM incomes WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setUserId(userId);

                Date incDate = rs.getDate("income_date");
                java.time.LocalDate localDate = (incDate != null) ? incDate.toLocalDate() : null;

                Income income = new Income(
                        rs.getInt("income_id"),
                        user,
                        rs.getDouble("amount"),
                        rs.getString("description"),
                        localDate
                );
                list.add(income);
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