package com.smartbudget.services;

import com.smartbudget.dao.UserDAO;
import com.smartbudget.models.User;
import com.smartbudget.utils.PasswordUtil;
import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.session.UserSession;

/**
 * Authentication service.
 * Handles user registration and login business logic.
 */
public class AuthService {
    
    private UserDAO userDAO;
    private UserSession userSession;
    
    public AuthService() {
        this.userDAO = new UserDAO();
        this.userSession = UserSession.getInstance();
    }
    
    /**
     * Register a new user.
     * @param username Username for new account
     * @param email Email address
     * @param password Plain text password
     * @param confirmPassword Password confirmation
     * @return Registered User object
     * @throws ValidationException if validation fails
     * @throws DatabaseException if database error occurs
     */
    public User register(String username, String email, String password, String confirmPassword) 
            throws ValidationException, DatabaseException {
        
        // Validate inputs
        validateRegistrationInput(username, email, password, confirmPassword);
        
        // Check if username already exists
        if (userDAO.usernameExists(username)) {
            throw new ValidationException("Username already taken. Please choose another.");
        }
        
        // Check if email already exists
        if (userDAO.emailExists(email)) {
            throw new ValidationException("Email already registered. Please use another.");
        }
        
        // Create user with hashed password
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(PasswordUtil.hashPassword(password));
        
        // Save to database
        User registeredUser = userDAO.register(newUser);
        
        if (registeredUser == null) {
            throw new DatabaseException("Failed to register user. Please try again.");
        }
        
        return registeredUser;
    }
    
    /**
     * Login user.
     * @param username Username
     * @param password Plain text password
     * @return Authenticated User object
     * @throws ValidationException if validation fails
     * @throws DatabaseException if database error occurs
     */
    public User login(String username, String password) 
            throws ValidationException, DatabaseException {
        
        // Validate inputs
        if (username == null || username.trim().isEmpty()) {
            throw new ValidationException("Username cannot be empty.");
        }
        if (password == null || password.isEmpty()) {
            throw new ValidationException("Password cannot be empty.");
        }
        
        // Find user by username
        User user = userDAO.findByUsername(username);
        if (user == null) {
            throw new ValidationException("Invalid username or password.");
        }
        
        // Verify password
        if (!PasswordUtil.verifyPassword(password, user.getPassword())) {
            throw new ValidationException("Invalid username or password.");
        }
        
        // Store in session
        userSession.setCurrentUser(user);
        
        return user;
    }
    
    /**
     * Logout current user.
     */
    public void logout() {
        userSession.logout();
    }
    
    /**
     * Get current logged-in user.
     * @return Current User object, or null if not logged in
     */
    public User getCurrentUser() {
        return userSession.getCurrentUser();
    }
    
    /**
     * Check if user is logged in.
     * @return true if logged in, false otherwise
     */
    public boolean isLoggedIn() {
        return userSession.isLoggedIn();
    }
    
    /**
     * Validate registration input.
     * @param username Username to validate
     * @param email Email to validate
     * @param password Password to validate
     * @param confirmPassword Password confirmation
     * @throws ValidationException if validation fails
     */
    private void validateRegistrationInput(String username, String email, String password, String confirmPassword) 
            throws ValidationException {
        
        // Check username
        if (username == null || username.trim().isEmpty()) {
            throw new ValidationException("Username cannot be empty.");
        }
        if (username.length() < 3) {
            throw new ValidationException("Username must be at least 3 characters long.");
        }
        if (username.length() > 50) {
            throw new ValidationException("Username cannot exceed 50 characters.");
        }
        
        // Check email
        if (email == null || email.trim().isEmpty()) {
            throw new ValidationException("Email cannot be empty.");
        }
        if (!isValidEmail(email)) {
            throw new ValidationException("Please enter a valid email address.");
        }
        
        // Check password
        if (password == null || password.isEmpty()) {
            throw new ValidationException("Password cannot be empty.");
        }
        if (!PasswordUtil.isValidPassword(password)) {
            throw new ValidationException("Password must be at least 6 characters long.");
        }
        
        // Check confirmation
        if (confirmPassword == null || confirmPassword.isEmpty()) {
            throw new ValidationException("Please confirm your password.");
        }
        if (!password.equals(confirmPassword)) {
            throw new ValidationException("Passwords do not match.");
        }
    }
    
    /**
     * Simple email validation.
     * @param email Email to validate
     * @return true if email format is valid, false otherwise
     */
    private boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
