# BudgetDAO.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.dao`  
**Component Type:** `Class`  
**Description:** Database access layer containing queries to manage budgets, retrieve set limits, and query current spending against those limits.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private final DatabaseConnection dbConnection;
private final UserDAO userDAO;
```

### Declared Methods & Constructors (Behaviors)
```java
public BudgetDAO();
public Budget findById(int id) throws DatabaseException;
public List<Budget> findByUserId(int userId) throws DatabaseException;
public Budget findByUserAndPeriod(int userId, int month, int year) throws DatabaseException;
public boolean insert(Budget entity) throws DatabaseException;
public boolean update(Budget entity) throws DatabaseException;
public boolean delete(int id) throws DatabaseException;
private Budget mapResultSetToBudget(ResultSet rs) throws SQLException, DatabaseException;
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `BudgetDAO.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.dao;` | Declares the package namespace `com.smartbudget.dao` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import java.sql.Connection;` | Imports `java.sql.Connection` to make its classes and methods accessible within this file. |
| 4 | `import java.sql.PreparedStatement;` | Imports `java.sql.PreparedStatement` to make its classes and methods accessible within this file. |
| 5 | `import java.sql.ResultSet;` | Imports `java.sql.ResultSet` to make its classes and methods accessible within this file. |
| 6 | `import java.sql.SQLException;` | Imports `java.sql.SQLException` to make its classes and methods accessible within this file. |
| 7 | `import java.util.ArrayList;` | Imports `java.util.ArrayList` to make its classes and methods accessible within this file. |
| 8 | `import java.util.List;` | Imports `java.util.List` to make its classes and methods accessible within this file. |
| 9 | *Spacer* | Blank line used as a visual separator for code readability. |
| 10 | `import com.smartbudget.database.DatabaseConnection;` | Imports `com.smartbudget.database.DatabaseConnection` to make its classes and methods accessible within this file. |
| 11 | `import com.smartbudget.exceptions.DatabaseException;` | Imports `com.smartbudget.exceptions.DatabaseException` to make its classes and methods accessible within this file. |
| 12 | `import com.smartbudget.models.Budget;` | Imports `com.smartbudget.models.Budget` to make its classes and methods accessible within this file. |
| 13 | `import com.smartbudget.models.User;` | Imports `com.smartbudget.models.User` to make its classes and methods accessible within this file. |
| 14 | *Spacer* | Blank line used as a visual separator for code readability. |
| 15 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 16 | `* Data Access Object for Budget entity.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 17 | `* Handles database operations related to setting and tracking budgets.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 18 | `* Demonstrates the implementation of BaseDAO with object composition.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 19 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 20 | `public class BudgetDAO implements BaseDAO<Budget> {` | Declares the public class `BudgetDAO` implementing `BaseDAO` as a main architectural component of the module. |
| 21 | *Spacer* | Blank line used as a visual separator for code readability. |
| 22 | `private final DatabaseConnection dbConnection;` | Declares a private immutable (final) instance field `dbConnection` of type `DatabaseConnection` to maintain state with strict encapsulation. |
| 23 | `private final UserDAO userDAO;` | Declares a private immutable (final) instance field `userDAO` of type `UserDAO` to maintain state with strict encapsulation. |
| 24 | *Spacer* | Blank line used as a visual separator for code readability. |
| 25 | `public BudgetDAO() {` | Defines the constructor for `BudgetDAO` to initialize class dependencies, field values, or configuration states. |
| 26 | `this.dbConnection = DatabaseConnection.getInstance();` | Assigns or computes a value for the variable/field `this.dbConnection`. |
| 27 | `this.userDAO = new UserDAO();` | Assigns or computes a value for the variable/field `this.userDAO`. |
| 28 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 29 | *Spacer* | Blank line used as a visual separator for code readability. |
| 30 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 31 | `public Budget findById(int id) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 32 | `String query = "SELECT budget_id, user_id, month, year, amount FROM budgets WHERE budget_id = ?";` | Assigns or computes a value for the variable/field `query`. |
| 33 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 34 | `PreparedStatement stmt = conn.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 35 | *Spacer* | Blank line used as a visual separator for code readability. |
| 36 | `stmt.setInt(1, id);` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 37 | `try (ResultSet rs = stmt.executeQuery()) {` | Executes the prepared SELECT query statement, returning a ResultSet representing the returned rows. |
| 38 | `if (rs.next()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 39 | `return mapResultSetToBudget(rs);` | Returns the expression/value `mapResultSetToBudget(rs)` to the calling method, completing this thread's execution. |
| 40 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 41 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 42 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 43 | `throw new DatabaseException("Error finding budget by ID: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 44 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 45 | `return null;` | Returns the expression/value `null` to the calling method, completing this thread's execution. |
| 46 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 47 | *Spacer* | Blank line used as a visual separator for code readability. |
| 48 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 49 | `public List<Budget> findByUserId(int userId) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 50 | `List<Budget> budgets = new ArrayList<>();` | Assigns or computes a value for the variable/field `budgets`. |
| 51 | `String query = "SELECT budget_id, user_id, month, year, amount FROM budgets WHERE user_id = ? ORDER BY year DESC, month DESC";` | Assigns or computes a value for the variable/field `query`. |
| 52 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 53 | `PreparedStatement stmt = conn.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 54 | *Spacer* | Blank line used as a visual separator for code readability. |
| 55 | `stmt.setInt(1, userId);` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 56 | `try (ResultSet rs = stmt.executeQuery()) {` | Executes the prepared SELECT query statement, returning a ResultSet representing the returned rows. |
| 57 | `while (rs.next()) {` | While loop iterating dynamically as long as the conditional test evaluates to true. |
| 58 | `budgets.add(mapResultSetToBudget(rs));` | Calls the method `budgets.add` to execute its corresponding logic. |
| 59 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 60 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 61 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 62 | `throw new DatabaseException("Error finding budgets by User ID: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 63 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 64 | `return budgets;` | Returns the expression/value `budgets` to the calling method, completing this thread's execution. |
| 65 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 66 | *Spacer* | Blank line used as a visual separator for code readability. |
| 67 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 68 | `* Find budget by User, Month, and Year.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 69 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 70 | `public Budget findByUserAndPeriod(int userId, int month, int year) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 71 | `String query = "SELECT budget_id, user_id, month, year, amount FROM budgets WHERE user_id = ? AND month = ? AND year = ?";` | Assigns or computes a value for the variable/field `query`. |
| 72 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 73 | `PreparedStatement stmt = conn.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 74 | *Spacer* | Blank line used as a visual separator for code readability. |
| 75 | `stmt.setInt(1, userId);` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 76 | `stmt.setInt(2, month);` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 77 | `stmt.setInt(3, year);` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 78 | `try (ResultSet rs = stmt.executeQuery()) {` | Executes the prepared SELECT query statement, returning a ResultSet representing the returned rows. |
| 79 | `if (rs.next()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 80 | `return mapResultSetToBudget(rs);` | Returns the expression/value `mapResultSetToBudget(rs)` to the calling method, completing this thread's execution. |
| 81 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 82 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 83 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 84 | `throw new DatabaseException("Error finding budget by period: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 85 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 86 | `return null;` | Returns the expression/value `null` to the calling method, completing this thread's execution. |
| 87 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 88 | *Spacer* | Blank line used as a visual separator for code readability. |
| 89 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 90 | `public boolean insert(Budget entity) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 91 | `String query = "INSERT INTO budgets (user_id, month, year, amount) VALUES (?, ?, ?, ?)";` | Assigns or computes a value for the variable/field `query`. |
| 92 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 93 | `PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 94 | *Spacer* | Blank line used as a visual separator for code readability. |
| 95 | `stmt.setInt(1, entity.getUser().getUserId());` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 96 | `stmt.setInt(2, entity.getMonth());` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 97 | `stmt.setInt(3, entity.getYear());` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 98 | `stmt.setDouble(4, entity.getAmount());` | Calls the method `stmt.setDouble` to execute its corresponding logic. |
| 99 | *Spacer* | Blank line used as a visual separator for code readability. |
| 100 | `int affected = stmt.executeUpdate();` | Executes the prepared INSERT, UPDATE, or DELETE statement, returning the number of affected database rows. |
| 101 | `if (affected > 0) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 102 | `try (ResultSet rs = stmt.getGeneratedKeys()) {` | Declares a ResultSet pointer to scroll through rows returned from a database query execution. |
| 103 | `if (rs.next()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 104 | `entity.setBudgetId(rs.getInt(1));` | Calls the method `entity.setBudgetId` to execute its corresponding logic. |
| 105 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 106 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 107 | `return true;` | Returns the expression/value `true` to the calling method, completing this thread's execution. |
| 108 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 109 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 110 | `throw new DatabaseException("Error inserting budget: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 111 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 112 | `return false;` | Returns the expression/value `false` to the calling method, completing this thread's execution. |
| 113 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 114 | *Spacer* | Blank line used as a visual separator for code readability. |
| 115 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 116 | `public boolean update(Budget entity) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 117 | `String query = "UPDATE budgets SET user_id = ?, month = ?, year = ?, amount = ? WHERE budget_id = ?";` | Assigns or computes a value for the variable/field `query`. |
| 118 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 119 | `PreparedStatement stmt = conn.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 120 | *Spacer* | Blank line used as a visual separator for code readability. |
| 121 | `stmt.setInt(1, entity.getUser().getUserId());` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 122 | `stmt.setInt(2, entity.getMonth());` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 123 | `stmt.setInt(3, entity.getYear());` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 124 | `stmt.setDouble(4, entity.getAmount());` | Calls the method `stmt.setDouble` to execute its corresponding logic. |
| 125 | `stmt.setInt(5, entity.getBudgetId());` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 126 | *Spacer* | Blank line used as a visual separator for code readability. |
| 127 | `return stmt.executeUpdate() > 0;` | Returns the expression/value `stmt.executeUpdate() > 0` to the calling method, completing this thread's execution. |
| 128 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 129 | `throw new DatabaseException("Error updating budget: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 130 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 131 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 132 | *Spacer* | Blank line used as a visual separator for code readability. |
| 133 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 134 | `public boolean delete(int id) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 135 | `String query = "DELETE FROM budgets WHERE budget_id = ?";` | Assigns or computes a value for the variable/field `query`. |
| 136 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 137 | `PreparedStatement stmt = conn.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 138 | *Spacer* | Blank line used as a visual separator for code readability. |
| 139 | `stmt.setInt(1, id);` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 140 | `return stmt.executeUpdate() > 0;` | Returns the expression/value `stmt.executeUpdate() > 0` to the calling method, completing this thread's execution. |
| 141 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 142 | `throw new DatabaseException("Error deleting budget: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 143 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 144 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 145 | *Spacer* | Blank line used as a visual separator for code readability. |
| 146 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 147 | `* Map ResultSet row to Budget object.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 148 | `* Demonstrates Object composition by loading the associated User object.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 149 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 150 | `private Budget mapResultSetToBudget(ResultSet rs) throws SQLException, DatabaseException {` | Declares a ResultSet pointer to scroll through rows returned from a database query execution. |
| 151 | `int userId = rs.getInt("user_id");` | Assigns or computes a value for the variable/field `userId`. |
| 152 | `User user = userDAO.findById(userId);` | Assigns or computes a value for the variable/field `user`. |
| 153 | *Spacer* | Blank line used as a visual separator for code readability. |
| 154 | `Budget budget = new Budget();` | Assigns or computes a value for the variable/field `budget`. |
| 155 | `budget.setBudgetId(rs.getInt("budget_id"));` | Calls the method `budget.setBudgetId` to execute its corresponding logic. |
| 156 | `budget.setUser(user);` | Calls the method `budget.setUser` to execute its corresponding logic. |
| 157 | `budget.setMonth(rs.getInt("month"));` | Calls the method `budget.setMonth` to execute its corresponding logic. |
| 158 | `budget.setYear(rs.getInt("year"));` | Calls the method `budget.setYear` to execute its corresponding logic. |
| 159 | `budget.setAmount(rs.getDouble("amount"));` | Calls the method `budget.setAmount` to execute its corresponding logic. |
| 160 | `return budget;` | Returns the expression/value `budget` to the calling method, completing this thread's execution. |
| 161 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 162 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `BudgetDAO` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
- **Data Access Object (DAO) Pattern**: Isolates persistent database access operations directly from high-level business logical and controller layers, allowing clean migration of backends.
