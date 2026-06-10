package com.smartbudget.dao;

import com.smartbudget.database.DatabaseConnection;
import com.smartbudget.models.User;
import com.smartbudget.exceptions.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Data Access Object for User entity.
 * Handles all database operations related to users.
 */
public class UserDAO {
    
    private DatabaseConnection dbConnection;
    
    public UserDAO() {
        this.dbConnection = DatabaseConnection.getInstance();
    }
    
    /**
     * Find user by username.
     * @param username Username to search for
     * @return User object if found, null otherwise
     * @throws DatabaseException if database error occurs
     */
    public User findByUsername(String username) throws DatabaseException {
        String query = "SELECT user_id, username, email, password, created_at FROM users WHERE username = ?";
        
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapResultSetToUser(rs);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding user by username: " + e.getMessage());
        }
        return null;
    }
    
    /**
     * Find user by ID.
     * @param userId User ID to search for
     * @return User object if found, null otherwise
     * @throws DatabaseException if database error occurs
     */
    public User findById(int userId) throws DatabaseException {
        String query = "SELECT user_id, username, email, password, created_at FROM users WHERE user_id = ?";
        
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return mapResultSetToUser(rs);
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error finding user by ID: " + e.getMessage());
        }
        return null;
    }
    
    /**
     * Register a new user.
     * @param user User object with username, email, password (hashed)
     * @return User object with generated ID, or null if registration failed
     * @throws DatabaseException if database error occurs
     */
    public User register(User user) throws DatabaseException {
        String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
        
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());  // Already hashed by AuthService
            
            int rowsInserted = stmt.executeUpdate();
            
            if (rowsInserted > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int generatedId = (int) generatedKeys.getLong(1);
                        user.setUserId(generatedId);
                        user.setCreatedAt(LocalDateTime.now());
                        return user;
                    }
                }
            }
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                throw new DatabaseException("Username or email already exists");
            }
            throw new DatabaseException("Error registering user: " + e.getMessage());
        }
        return null;
    }
    
    /**
     * Update existing user.
     * @param user User object with updated fields
     * @return true if update successful, false otherwise
     * @throws DatabaseException if database error occurs
     */
    public boolean update(User user) throws DatabaseException {
        String query = "UPDATE users SET username = ?, email = ?, password = ? WHERE user_id = ?";
        
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getUserId());
            
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            throw new DatabaseException("Error updating user: " + e.getMessage());
        }
    }
    
    /**
     * Delete user by ID.
     * @param userId User ID to delete
     * @return true if delete successful, false otherwise
     * @throws DatabaseException if database error occurs
     */
    public boolean delete(int userId) throws DatabaseException {
        String query = "DELETE FROM users WHERE user_id = ?";
        
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            
            stmt.setInt(1, userId);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            throw new DatabaseException("Error deleting user: " + e.getMessage());
        }
    }
    
    /**
     * Check if username already exists.
     * @param username Username to check
     * @return true if username exists, false otherwise
     * @throws DatabaseException if database error occurs
     */
    public boolean usernameExists(String username) throws DatabaseException {
        return findByUsername(username) != null;
    }
    
    /**
     * Check if email already exists.
     * @param email Email to check
     * @return true if email exists, false otherwise
     * @throws DatabaseException if database error occurs
     */
    public boolean emailExists(String email) throws DatabaseException {
        String query = "SELECT user_id FROM users WHERE email = ?";
        
        try (Connection connection = dbConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new DatabaseException("Error checking email existence: " + e.getMessage());
        }
    }
    
    /**
     * Map ResultSet row to User object.
     * @param rs ResultSet containing user data
     * @return User object
     * @throws SQLException if database error occurs
     */
    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        
        Timestamp createdAt = rs.getTimestamp("created_at");
        if (createdAt != null) {
            user.setCreatedAt(createdAt.toLocalDateTime());
        }
        
        return user;
    }
}
