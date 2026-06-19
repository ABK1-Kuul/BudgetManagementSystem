package com.smartbudget.services.impl;

import com.smartbudget.services.AuthService;
import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.models.User;
import com.smartbudget.dao.UserDAO;

public class AuthServiceImpl implements AuthService {
    // Dependency Injection: We pull in Member 1's newly completed UserDAO
    private final UserDAO userDAO;

    // Constructor: The service layer demands the DAO to function
    public AuthServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void register(User user) throws ValidationException {
        // ---- 1. BUSINESS VALIDATIONS (Your Domain) ----
        if (user == null) {
            throw new ValidationException("User data cannot be null.");
        }
        if (user.getUsername() == null || user.getUsername().trim().length() < 3) {
            throw new ValidationException("Username must be at least 3 characters long.");
        }
        if (user.getEmail() == null || !user.getEmail().contains("@")) {
            throw new ValidationException("Please provide a valid email address.");
        }
        // Guard Clause 2: Passwords match check (Resolves Member 3's UI requirement)
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new ValidationException("Passwords do not match. Please verify.");
        }
        if (user.getPassword() == null || user.getPassword().length() < 4) {
            throw new ValidationException("Password must be at least 4 characters long.");
        }

        // ---- 2. UNIQUE DATABASE BUSINESS CHECK ----
        // Before calling the database insert, check if the username is already taken!
        if (userDAO.findByUsername(user.getUsername()) != null) {
            throw new ValidationException("Username '" + user.getUsername() + "' is already taken!");
        }

        // ---- 3. HANDOFF TO DAO LAYER ----
        // If all validation guard clauses pass, pass it to Member 1's code to run the SQL
        boolean isSaved = userDAO.createUser(user);
        if (!isSaved) {
            throw new ValidationException("Registration failed due to an internal system error.");
        }
        System.out.println("🎉 SUCCESS: User passed validation and was securely written to MySQL!");
    }

    @Override
    public User loginUser(String username, String password) throws ValidationException {
        if (username == null || username.trim().isEmpty() || password == null || password.isEmpty()) {
            throw new ValidationException("Username and password fields cannot be empty.");
        }
        // Search the database via Member 1's code
        User foundUser = userDAO.findByUsername(username);
        // Security check: If user doesn't exist or password doesn't match, block them!
        if (foundUser == null || !foundUser.getPassword().equals(password)) {
            throw new ValidationException("Invalid username or password.");
        }
        System.out.println("🔓 SUCCESS: User authenticated successfully! Welcome back, " + username);
        return foundUser;
    }
}