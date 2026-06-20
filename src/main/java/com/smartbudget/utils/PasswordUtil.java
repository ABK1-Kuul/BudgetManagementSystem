package com.smartbudget.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * Utility for password hashing and verification.
 * Uses SHA-256 with salt for secure password storage.
 */
public class PasswordUtil {
    
    private static final int SALT_LENGTH = 16;
    private static final String HASH_ALGORITHM = "SHA-256";
    
    /**
     * Hash a plain text password with generated salt.
     * @param plainPassword Plain text password
     * @return Base64 encoded salt+hash (format: salt:hash)
     */
    public static String hashPassword(String plainPassword) {
        try {
            // Generate random salt
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[SALT_LENGTH];
            random.nextBytes(salt);
            
            // Hash password with salt
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            digest.update(salt);
            byte[] hash = digest.digest(plainPassword.getBytes());
            
            // Combine salt and hash, then encode to Base64
            String saltBase64 = Base64.getEncoder().encodeToString(salt);
            String hashBase64 = Base64.getEncoder().encodeToString(hash);
            
            return saltBase64 + ":" + hashBase64;  // Format: salt:hash
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not available: " + e.getMessage());
        }
    }
    
    /**
     * Verify a plain text password against a stored hash.
     * @param plainPassword Plain text password to verify
     * @param storedHash Stored hash in format salt:hash
     * @return true if password matches, false otherwise
     */
    public static boolean verifyPassword(String plainPassword, String storedHash) {
        try {
            // Split stored hash into salt and hash components
            String[] parts = storedHash.split(":");
            if (parts.length != 2) {
                return false;  // Invalid stored hash format
            }
            
            String saltBase64 = parts[0];
            String hashBase64 = parts[1];
            
            // Decode salt and hash from Base64
            byte[] salt = Base64.getDecoder().decode(saltBase64);
            byte[] storedHashBytes = Base64.getDecoder().decode(hashBase64);
            
            // Hash the provided password using the same salt
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            digest.update(salt);
            byte[] computedHash = digest.digest(plainPassword.getBytes());
            
            // Compare computed hash with stored hash
            return MessageDigest.isEqual(computedHash, storedHashBytes);
        } catch (IllegalArgumentException | NoSuchAlgorithmException e) {
            System.err.println("Password verification error: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Quick validation: check if password meets minimum requirements.
     * @param password Password to validate
     * @return true if password meets requirements, false otherwise
     */
    public static boolean isValidPassword(String password) {
        // Minimum 6 characters
        return password != null && password.length() >= 6;
    }
}
