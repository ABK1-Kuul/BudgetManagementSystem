package com.smartbudget.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.smartbudget.database.DatabaseConnection;
import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.models.Category;

/**
 * Data Access Object for Category entity.
 * Handles database operations related to expense categories.
 * Demonstrates the implementation of the BaseDAO interface.
 */
public class CategoryDAO implements BaseDAO<Category> {

    private final DatabaseConnection dbConnection;

    public CategoryDAO() {
        this.dbConnection = DatabaseConnection.getInstance();
    }

    @Override
    public Category findById(int id) throws DatabaseException {
        String query = "SELECT category_id, category_name FROM categories WHERE category_id = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Category(rs.getInt("category_id"), rs.getString("category_name"));
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error retrieving category by ID: " + e.getMessage(), e);
        }
        return null;
    }

    /**
     * Retrieve all categories from the database.
     */
    public List<Category> getAllCategories() throws DatabaseException {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT category_id, category_name FROM categories";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                categories.add(new Category(rs.getInt("category_id"), rs.getString("category_name")));
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error retrieving categories: " + e.getMessage(), e);
        }
        return categories;
    }

    @Override
    public List<Category> findByUserId(int userId) throws DatabaseException {
        // Categories are global, so returning all categories
        return getAllCategories();
    }

    @Override
    public boolean insert(Category entity) throws DatabaseException {
        String query = "INSERT INTO categories (category_name) VALUES (?)";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, entity.getCategoryName());
            int affected = stmt.executeUpdate();
            if (affected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        entity.setCategoryId(generatedKeys.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting category: " + e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean update(Category entity) throws DatabaseException {
        String query = "UPDATE categories SET category_name = ? WHERE category_id = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, entity.getCategoryName());
            stmt.setInt(2, entity.getCategoryId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DatabaseException("Error updating category: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean delete(int id) throws DatabaseException {
        String query = "DELETE FROM categories WHERE category_id = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting category: " + e.getMessage(), e);
        }
    }
}
