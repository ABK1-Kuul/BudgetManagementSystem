# AuthService.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.services`  
**Component Type:** `Class`  
**Description:** Business service coordinating authentication, checking credentials, handling user registration, and managing user sessions securely.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private UserDAO userDAO;
private UserSession userSession;
```

### Declared Methods & Constructors (Behaviors)
```java
public AuthService();
public void logout();
public User getCurrentUser();
public boolean isLoggedIn();
private boolean isValidEmail(String email);
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `AuthService.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.services;` | Declares the package namespace `com.smartbudget.services` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import com.smartbudget.dao.UserDAO;` | Imports `com.smartbudget.dao.UserDAO` to make its classes and methods accessible within this file. |
| 4 | `import com.smartbudget.models.User;` | Imports `com.smartbudget.models.User` to make its classes and methods accessible within this file. |
| 5 | `import com.smartbudget.utils.PasswordUtil;` | Imports `com.smartbudget.utils.PasswordUtil` to make its classes and methods accessible within this file. |
| 6 | `import com.smartbudget.exceptions.DatabaseException;` | Imports `com.smartbudget.exceptions.DatabaseException` to make its classes and methods accessible within this file. |
| 7 | `import com.smartbudget.exceptions.ValidationException;` | Imports `com.smartbudget.exceptions.ValidationException` to make its classes and methods accessible within this file. |
| 8 | `import com.smartbudget.session.UserSession;` | Imports `com.smartbudget.session.UserSession` to make its classes and methods accessible within this file. |
| 9 | *Spacer* | Blank line used as a visual separator for code readability. |
| 10 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 11 | `* Authentication service.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 12 | `* Handles user registration and login business logic.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 13 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 14 | `public class AuthService {` | Declares the public class `AuthService` as a main architectural component of the module. |
| 15 | *Spacer* | Blank line used as a visual separator for code readability. |
| 16 | `private UserDAO userDAO;` | Declares a private instance field `userDAO` of type `UserDAO` to maintain state with strict encapsulation. |
| 17 | `private UserSession userSession;` | Declares a private instance field `userSession` of type `UserSession` to maintain state with strict encapsulation. |
| 18 | *Spacer* | Blank line used as a visual separator for code readability. |
| 19 | `public AuthService() {` | Defines the constructor for `AuthService` to initialize class dependencies, field values, or configuration states. |
| 20 | `this.userDAO = new UserDAO();` | Assigns or computes a value for the variable/field `this.userDAO`. |
| 21 | `this.userSession = UserSession.getInstance();` | Assigns or computes a value for the variable/field `this.userSession`. |
| 22 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 23 | *Spacer* | Blank line used as a visual separator for code readability. |
| 24 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 25 | `* Register a new user.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 26 | `* @param username Username for new account` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 27 | `* @param email Email address` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 28 | `* @param password Plain text password` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 29 | `* @param confirmPassword Password confirmation` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 30 | `* @return Registered User object` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 31 | `* @throws ValidationException if validation fails` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 32 | `* @throws DatabaseException if database error occurs` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 33 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 34 | `public User register(String username, String email, String password, String confirmPassword)` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 35 | `throws ValidationException, DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 36 | *Spacer* | Blank line used as a visual separator for code readability. |
| 37 | `// Validate inputs` | Single-line comment explaining: "Validate inputs" |
| 38 | `validateRegistrationInput(username, email, password, confirmPassword);` | Calls the method `validateRegistrationInput` to execute its corresponding logic. |
| 39 | *Spacer* | Blank line used as a visual separator for code readability. |
| 40 | `// Check if username already exists` | Single-line comment explaining: "Check if username already exists" |
| 41 | `if (userDAO.usernameExists(username)) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 42 | `throw new ValidationException("Username already taken. Please choose another.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 43 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 44 | *Spacer* | Blank line used as a visual separator for code readability. |
| 45 | `// Check if email already exists` | Single-line comment explaining: "Check if email already exists" |
| 46 | `if (userDAO.emailExists(email)) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 47 | `throw new ValidationException("Email already registered. Please use another.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 48 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 49 | *Spacer* | Blank line used as a visual separator for code readability. |
| 50 | `// Create user with hashed password` | Single-line comment explaining: "Create user with hashed password" |
| 51 | `User newUser = new User();` | Assigns or computes a value for the variable/field `newUser`. |
| 52 | `newUser.setUsername(username);` | Calls the method `newUser.setUsername` to execute its corresponding logic. |
| 53 | `newUser.setEmail(email);` | Calls the method `newUser.setEmail` to execute its corresponding logic. |
| 54 | `newUser.setPassword(PasswordUtil.hashPassword(password));` | Calls the method `newUser.setPassword` to execute its corresponding logic. |
| 55 | *Spacer* | Blank line used as a visual separator for code readability. |
| 56 | `// Save to database` | Single-line comment explaining: "Save to database" |
| 57 | `User registeredUser = userDAO.register(newUser);` | Assigns or computes a value for the variable/field `registeredUser`. |
| 58 | *Spacer* | Blank line used as a visual separator for code readability. |
| 59 | `if (registeredUser == null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 60 | `throw new DatabaseException("Failed to register user. Please try again.");` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 61 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 62 | *Spacer* | Blank line used as a visual separator for code readability. |
| 63 | `return registeredUser;` | Returns the expression/value `registeredUser` to the calling method, completing this thread's execution. |
| 64 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 65 | *Spacer* | Blank line used as a visual separator for code readability. |
| 66 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 67 | `* Login user.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 68 | `* @param username Username` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 69 | `* @param password Plain text password` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 70 | `* @return Authenticated User object` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 71 | `* @throws ValidationException if validation fails` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 72 | `* @throws DatabaseException if database error occurs` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 73 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 74 | `public User login(String username, String password)` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 75 | `throws ValidationException, DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 76 | *Spacer* | Blank line used as a visual separator for code readability. |
| 77 | `// Validate inputs` | Single-line comment explaining: "Validate inputs" |
| 78 | `if (username == null \|\| username.trim().isEmpty()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 79 | `throw new ValidationException("Username cannot be empty.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 80 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 81 | `if (password == null \|\| password.isEmpty()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 82 | `throw new ValidationException("Password cannot be empty.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 83 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 84 | *Spacer* | Blank line used as a visual separator for code readability. |
| 85 | `// Find user by username` | Single-line comment explaining: "Find user by username" |
| 86 | `User user = userDAO.findByUsername(username);` | Assigns or computes a value for the variable/field `user`. |
| 87 | `if (user == null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 88 | `throw new ValidationException("Invalid username or password.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 89 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 90 | *Spacer* | Blank line used as a visual separator for code readability. |
| 91 | `// Verify password` | Single-line comment explaining: "Verify password" |
| 92 | `if (!PasswordUtil.verifyPassword(password, user.getPassword())) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 93 | `throw new ValidationException("Invalid username or password.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 94 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 95 | *Spacer* | Blank line used as a visual separator for code readability. |
| 96 | `// Store in session` | Single-line comment explaining: "Store in session" |
| 97 | `userSession.setCurrentUser(user);` | Calls the method `userSession.setCurrentUser` to execute its corresponding logic. |
| 98 | *Spacer* | Blank line used as a visual separator for code readability. |
| 99 | `return user;` | Returns the expression/value `user` to the calling method, completing this thread's execution. |
| 100 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 101 | *Spacer* | Blank line used as a visual separator for code readability. |
| 102 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 103 | `* Logout current user.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 104 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 105 | `public void logout() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 106 | `userSession.logout();` | Calls the method `userSession.logout` to execute its corresponding logic. |
| 107 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 108 | *Spacer* | Blank line used as a visual separator for code readability. |
| 109 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 110 | `* Get current logged-in user.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 111 | `* @return Current User object, or null if not logged in` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 112 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 113 | `public User getCurrentUser() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 114 | `return userSession.getCurrentUser();` | Returns the expression/value `userSession.getCurrentUser()` to the calling method, completing this thread's execution. |
| 115 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 116 | *Spacer* | Blank line used as a visual separator for code readability. |
| 117 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 118 | `* Check if user is logged in.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 119 | `* @return true if logged in, false otherwise` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 120 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 121 | `public boolean isLoggedIn() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 122 | `return userSession.isLoggedIn();` | Returns the expression/value `userSession.isLoggedIn()` to the calling method, completing this thread's execution. |
| 123 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 124 | *Spacer* | Blank line used as a visual separator for code readability. |
| 125 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 126 | `* Validate registration input.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 127 | `* @param username Username to validate` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 128 | `* @param email Email to validate` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 129 | `* @param password Password to validate` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 130 | `* @param confirmPassword Password confirmation` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 131 | `* @throws ValidationException if validation fails` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 132 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 133 | `private void validateRegistrationInput(String username, String email, String password, String confirmPassword)` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 134 | `throws ValidationException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 135 | *Spacer* | Blank line used as a visual separator for code readability. |
| 136 | `// Check username` | Single-line comment explaining: "Check username" |
| 137 | `if (username == null \|\| username.trim().isEmpty()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 138 | `throw new ValidationException("Username cannot be empty.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 139 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 140 | `if (username.length() < 3) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 141 | `throw new ValidationException("Username must be at least 3 characters long.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 142 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 143 | `if (username.length() > 50) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 144 | `throw new ValidationException("Username cannot exceed 50 characters.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 145 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 146 | *Spacer* | Blank line used as a visual separator for code readability. |
| 147 | `// Check email` | Single-line comment explaining: "Check email" |
| 148 | `if (email == null \|\| email.trim().isEmpty()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 149 | `throw new ValidationException("Email cannot be empty.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 150 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 151 | `if (!isValidEmail(email)) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 152 | `throw new ValidationException("Please enter a valid email address.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 153 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 154 | *Spacer* | Blank line used as a visual separator for code readability. |
| 155 | `// Check password` | Single-line comment explaining: "Check password" |
| 156 | `if (password == null \|\| password.isEmpty()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 157 | `throw new ValidationException("Password cannot be empty.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 158 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 159 | `if (!PasswordUtil.isValidPassword(password)) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 160 | `throw new ValidationException("Password must be at least 6 characters long.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 161 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 162 | *Spacer* | Blank line used as a visual separator for code readability. |
| 163 | `// Check confirmation` | Single-line comment explaining: "Check confirmation" |
| 164 | `if (confirmPassword == null \|\| confirmPassword.isEmpty()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 165 | `throw new ValidationException("Please confirm your password.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 166 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 167 | `if (!password.equals(confirmPassword)) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 168 | `throw new ValidationException("Passwords do not match.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 169 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 170 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 171 | *Spacer* | Blank line used as a visual separator for code readability. |
| 172 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 173 | `* Simple email validation.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 174 | `* @param email Email to validate` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 175 | `* @return true if email format is valid, false otherwise` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 176 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 177 | `private boolean isValidEmail(String email) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 178 | `return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");` | Returns the expression/value `email.matches("^[A-Za-z0-9+_.-]+@(.+)$")` to the calling method, completing this thread's execution. |
| 179 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 180 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `AuthService` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
- **Service Layer Pattern**: Centralizes transaction and boundary constraints checking in a distinct tier, keeping database access and controllers disconnected.
