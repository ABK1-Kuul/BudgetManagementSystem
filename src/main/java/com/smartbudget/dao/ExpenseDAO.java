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
import com.smartbudget.models.Category;
import com.smartbudget.models.Expense;
import com.smartbudget.models.User;

/**
 * Data Access Object for Expense entity.
 * Handles database operations related to tracking user expenses.
 * Demonstrates the implementation of BaseDAO with object composition/aggregation.
 */
public class ExpenseDAO implements BaseDAO<Expense> {

    private final DatabaseConnection dbConnection;
    private final UserDAO userDAO;
    private final CategoryDAO categoryDAO;

    public ExpenseDAO() {
        this.dbConnection = DatabaseConnection.getInstance();
        this.userDAO = new UserDAO();
        this.categoryDAO = new CategoryDAO();
    }

    @Override
    public Expense findById(int id) throws DatabaseException {
        String query = "SELECT expense_id, user_id, category_id, amount, description, expense_date FROM expenses WHERE expense_id = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToExpense(rs);
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding expense by ID: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Expense> findByUserId(int userId) throws DatabaseException {
        List<Expense> expenses = new ArrayList<>();
        String query = "SELECT expense_id, user_id, category_id, amount, description, expense_date " +
                       "FROM expenses WHERE user_id = ? ORDER BY expense_date DESC";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    expenses.add(mapResultSetToExpense(rs));
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding expenses by User ID: " + e.getMessage(), e);
        }
        return expenses;
    }

    @Override
    public boolean insert(Expense entity) throws DatabaseException {
        String query = "INSERT INTO expenses (user_id, category_id, amount, description, expense_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            stmt.setInt(1, entity.getUser().getUserId());
            stmt.setInt(2, entity.getCategory().getCategoryId());
            stmt.setDouble(3, entity.getAmount());
            stmt.setString(4, entity.getDescription());
            stmt.setDate(5, Date.valueOf(entity.getExpenseDate()));
            
            int affected = stmt.executeUpdate();
            if (affected > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        entity.setExpenseId(rs.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting expense: " + e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean update(Expense entity) throws DatabaseException {
        String query = "UPDATE expenses SET user_id = ?, category_id = ?, amount = ?, description = ?, expense_date = ? WHERE expense_id = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, entity.getUser().getUserId());
            stmt.setInt(2, entity.getCategory().getCategoryId());
            stmt.setDouble(3, entity.getAmount());
            stmt.setString(4, entity.getDescription());
            stmt.setDate(5, Date.valueOf(entity.getExpenseDate()));
            stmt.setInt(6, entity.getExpenseId());
            
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DatabaseException("Error updating expense: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(int id) throws DatabaseException {
        String query = "DELETE FROM expenses WHERE expense_id = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting expense: " + e.getMessage(), e);
        }
    }

    /**
     * Map ResultSet row to Expense object.
     * Demonstrates Object Composition/Aggregation by loading User and Category objects.
     */
    private Expense mapResultSetToExpense(ResultSet rs) throws SQLException, DatabaseException {
        int userId = rs.getInt("user_id");
        int categoryId = rs.getInt("category_id");
        
        // Retrieve associated aggregated objects
        User user = userDAO.findById(userId);
        Category category = categoryDAO.findById(categoryId);
        
        try {
            Expense expense = new Expense();
            expense.setExpenseId(rs.getInt("expense_id"));
            expense.setUser(user);
            expense.setCategory(category);
            expense.setAmount(rs.getDouble("amount"));
            expense.setDescription(rs.getString("description"));
            
            Date date = rs.getDate("expense_date");
            if (date != null) {
                expense.setExpenseDate(date.toLocalDate());
            }
            return expense;
        } catch (Exception e) {
            throw new DatabaseException("Failed to construct Expense model: " + e.getMessage(), e);
        }
    }
}
