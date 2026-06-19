package com.smartbudget.services;

import com.smartbudget.models.User;
import com.smartbudget.exceptions.ValidationException;

public interface AuthService {
    // Contract rule: Take a user object, validate it, and register it via DAO
    void register(User user) throws ValidationException;

    // Contract rule: Verify if a username and password match database records
    User login(String username, String password) throws ValidationException;
}