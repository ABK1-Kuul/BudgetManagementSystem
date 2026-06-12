package com.smartbudget.services;

import com.smartbudget.dao.UserDAO;
import com.smartbudget.models.User;

public class AuthService {

    private UserDAO userDAO;

    public AuthService() {

        userDAO = new UserDAO();
    }

    public boolean register(
            String username,
            String email,
            String password) {

        User user = new User();

        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        return userDAO.createUser(user);
    }

    public boolean login(
            String username,
            String password) {

        User user =
                userDAO.findByUsername(username);

        if (user == null) {
            return false;
        }

        return user.getPassword()
                .equals(password);
    }
}