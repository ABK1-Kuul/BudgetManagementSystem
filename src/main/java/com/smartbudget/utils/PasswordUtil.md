# PasswordUtil.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.utils`  
**Component Type:** `Class`  
**Description:** Security utility handling password hashing and secure verification (e.g., via SHA-256 or bcrypt) to enforce credential safety.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private static final int SALT_LENGTH = 16;
private static final String HASH_ALGORITHM = "SHA-256";
```

### Declared Methods & Constructors (Behaviors)
```java
public static String hashPassword(String plainPassword);
public static boolean verifyPassword(String plainPassword, String storedHash);
public static boolean isValidPassword(String password);
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `PasswordUtil.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.utils;` | Declares the package namespace `com.smartbudget.utils` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import java.security.MessageDigest;` | Imports `java.security.MessageDigest` to make its classes and methods accessible within this file. |
| 4 | `import java.security.NoSuchAlgorithmException;` | Imports `java.security.NoSuchAlgorithmException` to make its classes and methods accessible within this file. |
| 5 | `import java.security.SecureRandom;` | Imports `java.security.SecureRandom` to make its classes and methods accessible within this file. |
| 6 | `import java.util.Base64;` | Imports `java.util.Base64` to make its classes and methods accessible within this file. |
| 7 | *Spacer* | Blank line used as a visual separator for code readability. |
| 8 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 9 | `* Utility for password hashing and verification.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 10 | `* Uses SHA-256 with salt for secure password storage.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 11 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 12 | `public class PasswordUtil {` | Declares the public class `PasswordUtil` as a main architectural component of the module. |
| 13 | *Spacer* | Blank line used as a visual separator for code readability. |
| 14 | `private static final int SALT_LENGTH = 16;` | Declares a private immutable (final) class-level (static) instance field `SALT_LENGTH` of type `int` to maintain state with strict encapsulation. |
| 15 | `private static final String HASH_ALGORITHM = "SHA-256";` | Declares a private immutable (final) class-level (static) instance field `HASH_ALGORITHM` of type `String` to maintain state with strict encapsulation. |
| 16 | *Spacer* | Blank line used as a visual separator for code readability. |
| 17 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 18 | `* Hash a plain text password with generated salt.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 19 | `* @param plainPassword Plain text password` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 20 | `* @return Base64 encoded salt+hash (format: salt:hash)` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 21 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 22 | `public static String hashPassword(String plainPassword) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 23 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 24 | `// Generate random salt` | Single-line comment explaining: "Generate random salt" |
| 25 | `SecureRandom random = new SecureRandom();` | Assigns or computes a value for the variable/field `random`. |
| 26 | `byte[] salt = new byte[SALT_LENGTH];` | Assigns or computes a value for the variable/field `salt`. |
| 27 | `random.nextBytes(salt);` | Calls the method `random.nextBytes` to execute its corresponding logic. |
| 28 | *Spacer* | Blank line used as a visual separator for code readability. |
| 29 | `// Hash password with salt` | Single-line comment explaining: "Hash password with salt" |
| 30 | `MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);` | Assigns or computes a value for the variable/field `digest`. |
| 31 | `digest.update(salt);` | Calls the method `digest.update` to execute its corresponding logic. |
| 32 | `byte[] hash = digest.digest(plainPassword.getBytes());` | Assigns or computes a value for the variable/field `hash`. |
| 33 | *Spacer* | Blank line used as a visual separator for code readability. |
| 34 | `// Combine salt and hash, then encode to Base64` | Single-line comment explaining: "Combine salt and hash, then encode to Base64" |
| 35 | `String saltBase64 = Base64.getEncoder().encodeToString(salt);` | Assigns or computes a value for the variable/field `saltBase64`. |
| 36 | `String hashBase64 = Base64.getEncoder().encodeToString(hash);` | Assigns or computes a value for the variable/field `hashBase64`. |
| 37 | *Spacer* | Blank line used as a visual separator for code readability. |
| 38 | `return saltBase64 + ":" + hashBase64;  // Format: salt:hash` | Returns the expression/value `saltBase64 + ":" + hashBase64  // Format: salt:hash` to the calling method, completing this thread's execution. |
| 39 | `} catch (NoSuchAlgorithmException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 40 | `throw new RuntimeException("SHA-256 algorithm not available: " + e.getMessage());` | Calls the method `RuntimeException` to execute its corresponding logic. |
| 41 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 42 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 43 | *Spacer* | Blank line used as a visual separator for code readability. |
| 44 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 45 | `* Verify a plain text password against a stored hash.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 46 | `* @param plainPassword Plain text password to verify` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 47 | `* @param storedHash Stored hash in format salt:hash` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 48 | `* @return true if password matches, false otherwise` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 49 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 50 | `public static boolean verifyPassword(String plainPassword, String storedHash) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 51 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 52 | `// Split stored hash into salt and hash components` | Single-line comment explaining: "Split stored hash into salt and hash components" |
| 53 | `String[] parts = storedHash.split(":");` | Assigns or computes a value for the variable/field `parts`. |
| 54 | `if (parts.length != 2) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 55 | `return false;  // Invalid stored hash format` | Returns the expression/value `false  // Invalid stored hash format` to the calling method, completing this thread's execution. |
| 56 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 57 | *Spacer* | Blank line used as a visual separator for code readability. |
| 58 | `String saltBase64 = parts[0];` | Assigns or computes a value for the variable/field `saltBase64`. |
| 59 | `String hashBase64 = parts[1];` | Assigns or computes a value for the variable/field `hashBase64`. |
| 60 | *Spacer* | Blank line used as a visual separator for code readability. |
| 61 | `// Decode salt and hash from Base64` | Single-line comment explaining: "Decode salt and hash from Base64" |
| 62 | `byte[] salt = Base64.getDecoder().decode(saltBase64);` | Assigns or computes a value for the variable/field `salt`. |
| 63 | `byte[] storedHashBytes = Base64.getDecoder().decode(hashBase64);` | Assigns or computes a value for the variable/field `storedHashBytes`. |
| 64 | *Spacer* | Blank line used as a visual separator for code readability. |
| 65 | `// Hash the provided password using the same salt` | Single-line comment explaining: "Hash the provided password using the same salt" |
| 66 | `MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);` | Assigns or computes a value for the variable/field `digest`. |
| 67 | `digest.update(salt);` | Calls the method `digest.update` to execute its corresponding logic. |
| 68 | `byte[] computedHash = digest.digest(plainPassword.getBytes());` | Assigns or computes a value for the variable/field `computedHash`. |
| 69 | *Spacer* | Blank line used as a visual separator for code readability. |
| 70 | `// Compare computed hash with stored hash` | Single-line comment explaining: "Compare computed hash with stored hash" |
| 71 | `return MessageDigest.isEqual(computedHash, storedHashBytes);` | Returns the expression/value `MessageDigest.isEqual(computedHash, storedHashBytes)` to the calling method, completing this thread's execution. |
| 72 | `} catch (IllegalArgumentException \| NoSuchAlgorithmException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 73 | `System.err.println("Password verification error: " + e.getMessage());` | Calls the method `System.err.println` to execute its corresponding logic. |
| 74 | `return false;` | Returns the expression/value `false` to the calling method, completing this thread's execution. |
| 75 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 76 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 77 | *Spacer* | Blank line used as a visual separator for code readability. |
| 78 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 79 | `* Quick validation: check if password meets minimum requirements.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 80 | `* @param password Password to validate` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 81 | `* @return true if password meets requirements, false otherwise` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 82 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 83 | `public static boolean isValidPassword(String password) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 84 | `// Minimum 6 characters` | Single-line comment explaining: "Minimum 6 characters" |
| 85 | `return password != null && password.length() >= 6;` | Returns the expression/value `password != null && password.length() >= 6` to the calling method, completing this thread's execution. |
| 86 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 87 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `PasswordUtil` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
