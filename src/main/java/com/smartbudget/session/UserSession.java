package com.smartbudget.session;

import com.smartbudget.models.User;

/**
 * Singleton session manager for storing current logged-in user.
 * Used across controllers to access user context without passing parameters.
 */
public class UserSession {
    
    private static UserSession instance;
    private User currentUser;
    
    /**
     * Private constructor - prevents direct instantiation.
     */
    private UserSession() {
        this.currentUser = null;
    }
    
    /**
     * Get singleton instance of UserSession.
     * @return UserSession instance
     */
    public static synchronized UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }
    
    /**
     * Get current logged-in user.
     * @return Current User object, or null if not logged in
     */
    public User getCurrentUser() {
        return currentUser;
    }
    
    /**
     * Set current logged-in user (called after successful login).
     * @param user User object to set as current
     */
    public void setCurrentUser(User user) {
        this.currentUser = user;
    }
    
    /**
     * Get current user ID.
     * @return User ID, or -1 if not logged in
     */
    public int getCurrentUserId() {
        return currentUser != null ? currentUser.getUserId() : -1;
    }
    
    /**
     * Get current username.
     * @return Username, or null if not logged in
     */
    public String getCurrentUsername() {
        return currentUser != null ? currentUser.getUsername() : null;
    }
    
    /**
     * Check if user is logged in.
     * @return true if user is logged in, false otherwise
     */
    public boolean isLoggedIn() {
        return currentUser != null;
    }
    
    /**
     * Clear session (called on logout).
     */
    public void logout() {
        this.currentUser = null;
    }
    
    /**
     * Get session info for debugging.
     * @return Session state string
     */
    @Override
    public String toString() {
        return "UserSession{" + "currentUser=" + (currentUser != null ? currentUser.getUsername() : "null") + '}';  
    }
}
