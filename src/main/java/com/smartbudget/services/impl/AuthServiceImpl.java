package com.smartbudget.services.impl;

import com.smartbudget.dao.UserDAO;
import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.models.User;
import com.smartbudget.services.AuthService;
import com.smartbudget.session.UserSession;
import com.smartbudget.utils.PasswordUtil;

public class AuthServiceImpl implements AuthService {

    private final UserDAO userDAO;
    private final UserSession userSession;

    public AuthServiceImpl() {
        this(new UserDAO());
    }

    public AuthServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
        this.userSession = UserSession.getInstance();
    }

    @Override
    public User register(String username, String email, String password, String confirmPassword)
            throws ValidationException, DatabaseException {

        validateRegistrationInput(username, email, password, confirmPassword);

        if (userDAO.usernameExists(username)) {
            throw new ValidationException("Username already taken. Please choose another.");
        }
        if (userDAO.emailExists(email)) {
            throw new ValidationException("Email already registered. Please use another.");
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setPassword(PasswordUtil.hashPassword(password));

        User registeredUser = userDAO.register(newUser);
        if (registeredUser == null) {
            throw new DatabaseException("Failed to register user. Please try again.");
        }
        return registeredUser;
    }

    @Override
    public User login(String username, String password) throws ValidationException, DatabaseException {
        if (username == null || username.trim().isEmpty()) {
            throw new ValidationException("Username cannot be empty.");
        }
        if (password == null || password.isEmpty()) {
            throw new ValidationException("Password cannot be empty.");
        }

        User user = userDAO.findByUsername(username);
        if (user == null || !PasswordUtil.verifyPassword(password, user.getPassword())) {
            throw new ValidationException("Invalid username or password.");
        }

        userSession.setCurrentUser(user);
        return user;
    }

    @Override
    public void logout() {
        userSession.logout();
    }

    @Override
    public User getCurrentUser() {
        return userSession.getCurrentUser();
    }

    @Override
    public boolean isLoggedIn() {
        return userSession.isLoggedIn();
    }

    private void validateRegistrationInput(String username, String email, String password, String confirmPassword)
            throws ValidationException {

        if (username == null || username.trim().isEmpty()) {
            throw new ValidationException("Username cannot be empty.");
        }
        if (username.length() < 3) {
            throw new ValidationException("Username must be at least 3 characters long.");
        }
        if (username.length() > 50) {
            throw new ValidationException("Username cannot exceed 50 characters.");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new ValidationException("Email cannot be empty.");
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new ValidationException("Please enter a valid email address.");
        }
        if (password == null || password.isEmpty()) {
            throw new ValidationException("Password cannot be empty.");
        }
        if (!PasswordUtil.isValidPassword(password)) {
            throw new ValidationException("Password must be at least 6 characters long.");
        }
        if (confirmPassword == null || confirmPassword.isEmpty()) {
            throw new ValidationException("Please confirm your password.");
        }
        if (!password.equals(confirmPassword)) {
            throw new ValidationException("Passwords do not match.");
        }
    }
}
