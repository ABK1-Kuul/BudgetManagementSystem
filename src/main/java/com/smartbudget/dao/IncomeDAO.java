package com.smartbudget.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smartbudget.database.DatabaseConnection;
import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.models.Income;
import com.smartbudget.models.User;

/**
 * Data Access Object for Income entity.
 */
public class IncomeDAO implements BaseDAO<Income> {

    private final DatabaseConnection dbConnection;
    private final UserDAO userDAO;

    public IncomeDAO() {
        this.dbConnection = DatabaseConnection.getInstance();
        this.userDAO = new UserDAO();
    }

    @Override
    public Income findById(int id) throws DatabaseException {
        String query = "SELECT income_id, user_id, amount, description, income_date FROM incomes WHERE income_id = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToIncome(rs);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding income by ID: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Income> findByUserId(int userId) throws DatabaseException {
        List<Income> incomes = new ArrayList<>();
        String query = "SELECT income_id, user_id, amount, description, income_date "
                + "FROM incomes WHERE user_id = ? ORDER BY income_date DESC";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    incomes.add(mapResultSetToIncome(rs));
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding incomes by User ID: " + e.getMessage(), e);
        }
        return incomes;
    }

    @Override
    public boolean insert(Income entity) throws DatabaseException {
        String query = "INSERT INTO incomes (user_id, amount, description, income_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, entity.getUser().getUserId());
            stmt.setDouble(2, entity.getAmount());
            stmt.setString(3, entity.getDescription());
            stmt.setDate(4, Date.valueOf(entity.getIncomeDate()));

            int affected = stmt.executeUpdate();
            if (affected > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        entity.setIncomeId(rs.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting income: " + e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean update(Income entity) throws DatabaseException {
        String query = "UPDATE incomes SET user_id = ?, amount = ?, description = ?, income_date = ? WHERE income_id = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, entity.getUser().getUserId());
            stmt.setDouble(2, entity.getAmount());
            stmt.setString(3, entity.getDescription());
            stmt.setDate(4, Date.valueOf(entity.getIncomeDate()));
            stmt.setInt(5, entity.getIncomeId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DatabaseException("Error updating income: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(int id) throws DatabaseException {
        String query = "DELETE FROM incomes WHERE income_id = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting income: " + e.getMessage(), e);
        }
    }

    private Income mapResultSetToIncome(ResultSet rs) throws SQLException, DatabaseException {
        int userId = rs.getInt("user_id");
        User user = userDAO.findById(userId);

        try {
            Income income = new Income();
            income.setIncomeId(rs.getInt("income_id"));
            income.setUser(user);
            income.setAmount(rs.getDouble("amount"));
            income.setDescription(rs.getString("description"));

            Date date = rs.getDate("income_date");
            if (date != null) {
                income.setIncomeDate(date.toLocalDate());
            }
            return income;
        } catch (Exception e) {
            throw new DatabaseException("Failed to construct Income model: " + e.getMessage(), e);
        }
    }
}
