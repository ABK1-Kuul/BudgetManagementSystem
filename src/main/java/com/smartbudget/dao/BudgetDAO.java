package com.smartbudget.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smartbudget.database.DatabaseConnection;
import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.models.Budget;
import com.smartbudget.models.User;

/**
 * Data Access Object for Budget entity.
 */
public class BudgetDAO implements BaseDAO<Budget> {

    private final DatabaseConnection dbConnection;
    private final UserDAO userDAO;

    public BudgetDAO() {
        this.dbConnection = DatabaseConnection.getInstance();
        this.userDAO = new UserDAO();
    }

    @Override
    public Budget findById(int id) throws DatabaseException {
        String query = "SELECT budget_id, user_id, month, year, amount FROM budgets WHERE budget_id = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToBudget(rs);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding budget by ID: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Budget> findByUserId(int userId) throws DatabaseException {
        List<Budget> budgets = new ArrayList<>();
        String query = "SELECT budget_id, user_id, month, year, amount FROM budgets WHERE user_id = ? ORDER BY year DESC, month DESC";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    budgets.add(mapResultSetToBudget(rs));
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding budgets by User ID: " + e.getMessage(), e);
        }
        return budgets;
    }

    public Budget findByUserAndPeriod(int userId, int month, int year) throws DatabaseException {
        String query = "SELECT budget_id, user_id, month, year, amount FROM budgets WHERE user_id = ? AND month = ? AND year = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, month);
            stmt.setInt(3, year);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToBudget(rs);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding budget by period: " + e.getMessage(), e);
        }
        return null;
    }

    /**
     * Sum expenses for a user in a given month/year (used by budget status).
     */
    public double getSpentForPeriod(int userId, int month, int year) throws DatabaseException {
        String query = "SELECT COALESCE(SUM(amount), 0) FROM expenses WHERE user_id = ? AND MONTH(expense_date) = ? AND YEAR(expense_date) = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, month);
            stmt.setInt(3, year);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble(1);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error calculating spent amount: " + e.getMessage(), e);
        }
        return 0.0;
    }

    @Override
    public boolean insert(Budget entity) throws DatabaseException {
        String query = "INSERT INTO budgets (user_id, month, year, amount) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, entity.getUser().getUserId());
            stmt.setInt(2, entity.getMonth());
            stmt.setInt(3, entity.getYear());
            stmt.setDouble(4, entity.getAmount());

            int affected = stmt.executeUpdate();
            if (affected > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        entity.setBudgetId(rs.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting budget: " + e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean update(Budget entity) throws DatabaseException {
        String query = "UPDATE budgets SET user_id = ?, month = ?, year = ?, amount = ? WHERE budget_id = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, entity.getUser().getUserId());
            stmt.setInt(2, entity.getMonth());
            stmt.setInt(3, entity.getYear());
            stmt.setDouble(4, entity.getAmount());
            stmt.setInt(5, entity.getBudgetId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DatabaseException("Error updating budget: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(int id) throws DatabaseException {
        String query = "DELETE FROM budgets WHERE budget_id = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting budget: " + e.getMessage(), e);
        }
    }

    private Budget mapResultSetToBudget(ResultSet rs) throws SQLException, DatabaseException {
        int userId = rs.getInt("user_id");
        User user = userDAO.findById(userId);

        Budget budget = new Budget();
        budget.setBudgetId(rs.getInt("budget_id"));
        budget.setUser(user);
        budget.setMonth(rs.getInt("month"));
        budget.setYear(rs.getInt("year"));
        budget.setAmount(rs.getDouble("amount"));
        return budget;
    }
}
