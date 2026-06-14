# UserDAO.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.dao`  
**Component Type:** `Class`  
**Description:** Database access object for user authentication and registration, handling secure credential retrieval and user registration in the database.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private DatabaseConnection dbConnection;
```

### Declared Methods & Constructors (Behaviors)
```java
public UserDAO();
public User findByUsername(String username) throws DatabaseException;
public User findById(int userId) throws DatabaseException;
public User register(User user) throws DatabaseException;
public boolean update(User user) throws DatabaseException;
public boolean delete(int userId) throws DatabaseException;
public boolean usernameExists(String username) throws DatabaseException;
public boolean emailExists(String email) throws DatabaseException;
private User mapResultSetToUser(ResultSet rs) throws SQLException;
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `UserDAO.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.dao;` | Declares the package namespace `com.smartbudget.dao` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import com.smartbudget.database.DatabaseConnection;` | Imports `com.smartbudget.database.DatabaseConnection` to make its classes and methods accessible within this file. |
| 4 | `import com.smartbudget.models.User;` | Imports `com.smartbudget.models.User` to make its classes and methods accessible within this file. |
| 5 | `import com.smartbudget.exceptions.DatabaseException;` | Imports `com.smartbudget.exceptions.DatabaseException` to make its classes and methods accessible within this file. |
| 6 | `import java.sql.Connection;` | Imports `java.sql.Connection` to make its classes and methods accessible within this file. |
| 7 | `import java.sql.PreparedStatement;` | Imports `java.sql.PreparedStatement` to make its classes and methods accessible within this file. |
| 8 | `import java.sql.ResultSet;` | Imports `java.sql.ResultSet` to make its classes and methods accessible within this file. |
| 9 | `import java.sql.SQLException;` | Imports `java.sql.SQLException` to make its classes and methods accessible within this file. |
| 10 | `import java.sql.Timestamp;` | Imports `java.sql.Timestamp` to make its classes and methods accessible within this file. |
| 11 | `import java.time.LocalDateTime;` | Imports `java.time.LocalDateTime` to make its classes and methods accessible within this file. |
| 12 | *Spacer* | Blank line used as a visual separator for code readability. |
| 13 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 14 | `* Data Access Object for User entity.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 15 | `* Handles all database operations related to users.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 16 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 17 | `public class UserDAO {` | Declares the public class `UserDAO` as a main architectural component of the module. |
| 18 | *Spacer* | Blank line used as a visual separator for code readability. |
| 19 | `private DatabaseConnection dbConnection;` | Declares a private instance field `dbConnection` of type `DatabaseConnection` to maintain state with strict encapsulation. |
| 20 | *Spacer* | Blank line used as a visual separator for code readability. |
| 21 | `public UserDAO() {` | Defines the constructor for `UserDAO` to initialize class dependencies, field values, or configuration states. |
| 22 | `this.dbConnection = DatabaseConnection.getInstance();` | Assigns or computes a value for the variable/field `this.dbConnection`. |
| 23 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 24 | *Spacer* | Blank line used as a visual separator for code readability. |
| 25 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 26 | `* Find user by username.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 27 | `* @param username Username to search for` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 28 | `* @return User object if found, null otherwise` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 29 | `* @throws DatabaseException if database error occurs` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 30 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 31 | `public User findByUsername(String username) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 32 | `String query = "SELECT user_id, username, email, password, created_at FROM users WHERE username = ?";` | Assigns or computes a value for the variable/field `query`. |
| 33 | *Spacer* | Blank line used as a visual separator for code readability. |
| 34 | `try (Connection connection = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 35 | `PreparedStatement stmt = connection.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 36 | *Spacer* | Blank line used as a visual separator for code readability. |
| 37 | `stmt.setString(1, username);` | Calls the method `stmt.setString` to execute its corresponding logic. |
| 38 | `ResultSet rs = stmt.executeQuery();` | Executes the prepared SELECT query statement, returning a ResultSet representing the returned rows. |
| 39 | *Spacer* | Blank line used as a visual separator for code readability. |
| 40 | `if (rs.next()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 41 | `return mapResultSetToUser(rs);` | Returns the expression/value `mapResultSetToUser(rs)` to the calling method, completing this thread's execution. |
| 42 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 43 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 44 | `throw new DatabaseException("Error finding user by username: " + e.getMessage());` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 45 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 46 | `return null;` | Returns the expression/value `null` to the calling method, completing this thread's execution. |
| 47 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 48 | *Spacer* | Blank line used as a visual separator for code readability. |
| 49 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 50 | `* Find user by ID.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 51 | `* @param userId User ID to search for` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 52 | `* @return User object if found, null otherwise` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 53 | `* @throws DatabaseException if database error occurs` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 54 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 55 | `public User findById(int userId) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 56 | `String query = "SELECT user_id, username, email, password, created_at FROM users WHERE user_id = ?";` | Assigns or computes a value for the variable/field `query`. |
| 57 | *Spacer* | Blank line used as a visual separator for code readability. |
| 58 | `try (Connection connection = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 59 | `PreparedStatement stmt = connection.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 60 | *Spacer* | Blank line used as a visual separator for code readability. |
| 61 | `stmt.setInt(1, userId);` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 62 | `ResultSet rs = stmt.executeQuery();` | Executes the prepared SELECT query statement, returning a ResultSet representing the returned rows. |
| 63 | *Spacer* | Blank line used as a visual separator for code readability. |
| 64 | `if (rs.next()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 65 | `return mapResultSetToUser(rs);` | Returns the expression/value `mapResultSetToUser(rs)` to the calling method, completing this thread's execution. |
| 66 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 67 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 68 | `throw new DatabaseException("Error finding user by ID: " + e.getMessage());` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 69 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 70 | `return null;` | Returns the expression/value `null` to the calling method, completing this thread's execution. |
| 71 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 72 | *Spacer* | Blank line used as a visual separator for code readability. |
| 73 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 74 | `* Register a new user.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 75 | `* @param user User object with username, email, password (hashed)` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 76 | `* @return User object with generated ID, or null if registration failed` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 77 | `* @throws DatabaseException if database error occurs` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 78 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 79 | `public User register(User user) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 80 | `String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";` | Assigns or computes a value for the variable/field `query`. |
| 81 | *Spacer* | Blank line used as a visual separator for code readability. |
| 82 | `try (Connection connection = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 83 | `PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 84 | *Spacer* | Blank line used as a visual separator for code readability. |
| 85 | `stmt.setString(1, user.getUsername());` | Calls the method `stmt.setString` to execute its corresponding logic. |
| 86 | `stmt.setString(2, user.getEmail());` | Calls the method `stmt.setString` to execute its corresponding logic. |
| 87 | `stmt.setString(3, user.getPassword());  // Already hashed by AuthService` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 88 | *Spacer* | Blank line used as a visual separator for code readability. |
| 89 | `int rowsInserted = stmt.executeUpdate();` | Executes the prepared INSERT, UPDATE, or DELETE statement, returning the number of affected database rows. |
| 90 | *Spacer* | Blank line used as a visual separator for code readability. |
| 91 | `if (rowsInserted > 0) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 92 | `try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {` | Declares a ResultSet pointer to scroll through rows returned from a database query execution. |
| 93 | `if (generatedKeys.next()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 94 | `int generatedId = (int) generatedKeys.getLong(1);` | Assigns or computes a value for the variable/field `generatedId`. |
| 95 | `user.setUserId(generatedId);` | Calls the method `user.setUserId` to execute its corresponding logic. |
| 96 | `user.setCreatedAt(LocalDateTime.now());` | Calls the method `user.setCreatedAt` to execute its corresponding logic. |
| 97 | `return user;` | Returns the expression/value `user` to the calling method, completing this thread's execution. |
| 98 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 99 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 100 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 101 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 102 | `if (e.getMessage().contains("Duplicate entry")) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 103 | `throw new DatabaseException("Username or email already exists");` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 104 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 105 | `throw new DatabaseException("Error registering user: " + e.getMessage());` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 106 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 107 | `return null;` | Returns the expression/value `null` to the calling method, completing this thread's execution. |
| 108 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 109 | *Spacer* | Blank line used as a visual separator for code readability. |
| 110 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 111 | `* Update existing user.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 112 | `* @param user User object with updated fields` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 113 | `* @return true if update successful, false otherwise` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 114 | `* @throws DatabaseException if database error occurs` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 115 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 116 | `public boolean update(User user) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 117 | `String query = "UPDATE users SET username = ?, email = ?, password = ? WHERE user_id = ?";` | Assigns or computes a value for the variable/field `query`. |
| 118 | *Spacer* | Blank line used as a visual separator for code readability. |
| 119 | `try (Connection connection = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 120 | `PreparedStatement stmt = connection.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 121 | *Spacer* | Blank line used as a visual separator for code readability. |
| 122 | `stmt.setString(1, user.getUsername());` | Calls the method `stmt.setString` to execute its corresponding logic. |
| 123 | `stmt.setString(2, user.getEmail());` | Calls the method `stmt.setString` to execute its corresponding logic. |
| 124 | `stmt.setString(3, user.getPassword());` | Calls the method `stmt.setString` to execute its corresponding logic. |
| 125 | `stmt.setInt(4, user.getUserId());` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 126 | *Spacer* | Blank line used as a visual separator for code readability. |
| 127 | `int rowsUpdated = stmt.executeUpdate();` | Executes the prepared INSERT, UPDATE, or DELETE statement, returning the number of affected database rows. |
| 128 | `return rowsUpdated > 0;` | Returns the expression/value `rowsUpdated > 0` to the calling method, completing this thread's execution. |
| 129 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 130 | `throw new DatabaseException("Error updating user: " + e.getMessage());` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 131 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 132 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 133 | *Spacer* | Blank line used as a visual separator for code readability. |
| 134 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 135 | `* Delete user by ID.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 136 | `* @param userId User ID to delete` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 137 | `* @return true if delete successful, false otherwise` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 138 | `* @throws DatabaseException if database error occurs` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 139 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 140 | `public boolean delete(int userId) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 141 | `String query = "DELETE FROM users WHERE user_id = ?";` | Assigns or computes a value for the variable/field `query`. |
| 142 | *Spacer* | Blank line used as a visual separator for code readability. |
| 143 | `try (Connection connection = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 144 | `PreparedStatement stmt = connection.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 145 | *Spacer* | Blank line used as a visual separator for code readability. |
| 146 | `stmt.setInt(1, userId);` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 147 | `int rowsDeleted = stmt.executeUpdate();` | Executes the prepared INSERT, UPDATE, or DELETE statement, returning the number of affected database rows. |
| 148 | `return rowsDeleted > 0;` | Returns the expression/value `rowsDeleted > 0` to the calling method, completing this thread's execution. |
| 149 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 150 | `throw new DatabaseException("Error deleting user: " + e.getMessage());` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 151 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 152 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 153 | *Spacer* | Blank line used as a visual separator for code readability. |
| 154 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 155 | `* Check if username already exists.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 156 | `* @param username Username to check` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 157 | `* @return true if username exists, false otherwise` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 158 | `* @throws DatabaseException if database error occurs` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 159 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 160 | `public boolean usernameExists(String username) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 161 | `return findByUsername(username) != null;` | Returns the expression/value `findByUsername(username) != null` to the calling method, completing this thread's execution. |
| 162 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 163 | *Spacer* | Blank line used as a visual separator for code readability. |
| 164 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 165 | `* Check if email already exists.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 166 | `* @param email Email to check` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 167 | `* @return true if email exists, false otherwise` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 168 | `* @throws DatabaseException if database error occurs` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 169 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 170 | `public boolean emailExists(String email) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 171 | `String query = "SELECT user_id FROM users WHERE email = ?";` | Assigns or computes a value for the variable/field `query`. |
| 172 | *Spacer* | Blank line used as a visual separator for code readability. |
| 173 | `try (Connection connection = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 174 | `PreparedStatement stmt = connection.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 175 | *Spacer* | Blank line used as a visual separator for code readability. |
| 176 | `stmt.setString(1, email);` | Calls the method `stmt.setString` to execute its corresponding logic. |
| 177 | `ResultSet rs = stmt.executeQuery();` | Executes the prepared SELECT query statement, returning a ResultSet representing the returned rows. |
| 178 | `return rs.next();` | Returns the expression/value `rs.next()` to the calling method, completing this thread's execution. |
| 179 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 180 | `throw new DatabaseException("Error checking email existence: " + e.getMessage());` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 181 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 182 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 183 | *Spacer* | Blank line used as a visual separator for code readability. |
| 184 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 185 | `* Map ResultSet row to User object.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 186 | `* @param rs ResultSet containing user data` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 187 | `* @return User object` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 188 | `* @throws SQLException if database error occurs` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 189 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 190 | `private User mapResultSetToUser(ResultSet rs) throws SQLException {` | Declares a ResultSet pointer to scroll through rows returned from a database query execution. |
| 191 | `User user = new User();` | Assigns or computes a value for the variable/field `user`. |
| 192 | `user.setUserId(rs.getInt("user_id"));` | Calls the method `user.setUserId` to execute its corresponding logic. |
| 193 | `user.setUsername(rs.getString("username"));` | Calls the method `user.setUsername` to execute its corresponding logic. |
| 194 | `user.setEmail(rs.getString("email"));` | Calls the method `user.setEmail` to execute its corresponding logic. |
| 195 | `user.setPassword(rs.getString("password"));` | Calls the method `user.setPassword` to execute its corresponding logic. |
| 196 | *Spacer* | Blank line used as a visual separator for code readability. |
| 197 | `Timestamp createdAt = rs.getTimestamp("created_at");` | Assigns or computes a value for the variable/field `createdAt`. |
| 198 | `if (createdAt != null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 199 | `user.setCreatedAt(createdAt.toLocalDateTime());` | Calls the method `user.setCreatedAt` to execute its corresponding logic. |
| 200 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 201 | *Spacer* | Blank line used as a visual separator for code readability. |
| 202 | `return user;` | Returns the expression/value `user` to the calling method, completing this thread's execution. |
| 203 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 204 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `UserDAO` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
- **Data Access Object (DAO) Pattern**: Isolates persistent database access operations directly from high-level business logical and controller layers, allowing clean migration of backends.
