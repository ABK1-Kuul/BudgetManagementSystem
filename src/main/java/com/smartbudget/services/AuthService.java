package com.smartbudget.services;

import com.smartbudget.exceptions.DatabaseException;
import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.models.User;

public interface AuthService {

    User register(String username, String email, String password, String confirmPassword)
            throws ValidationException, DatabaseException;

    User login(String username, String password) throws ValidationException, DatabaseException;

    void logout();

    User getCurrentUser();

    boolean isLoggedIn();
}
