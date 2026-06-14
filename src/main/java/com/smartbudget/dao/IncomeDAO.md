# IncomeDAO.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.dao`  
**Component Type:** `Class`  
**Description:** Database access layer handling query execution and mapping for income entries, facilitating tracking of user revenues.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private final DatabaseConnection dbConnection;
private final UserDAO userDAO;
```

### Declared Methods & Constructors (Behaviors)
```java
public IncomeDAO();
public Income findById(int id) throws DatabaseException;
public List<Income> findByUserId(int userId) throws DatabaseException;
public boolean insert(Income entity) throws DatabaseException;
public boolean update(Income entity) throws DatabaseException;
public boolean delete(int id) throws DatabaseException;
private Income mapResultSetToIncome(ResultSet rs) throws SQLException, DatabaseException;
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `IncomeDAO.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.dao;` | Declares the package namespace `com.smartbudget.dao` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import java.sql.Connection;` | Imports `java.sql.Connection` to make its classes and methods accessible within this file. |
| 4 | `import java.sql.Date;` | Imports `java.sql.Date` to make its classes and methods accessible within this file. |
| 5 | `import java.sql.PreparedStatement;` | Imports `java.sql.PreparedStatement` to make its classes and methods accessible within this file. |
| 6 | `import java.sql.ResultSet;` | Imports `java.sql.ResultSet` to make its classes and methods accessible within this file. |
| 7 | `import java.sql.SQLException;` | Imports `java.sql.SQLException` to make its classes and methods accessible within this file. |
| 8 | `import java.util.ArrayList;` | Imports `java.util.ArrayList` to make its classes and methods accessible within this file. |
| 9 | `import java.util.List;` | Imports `java.util.List` to make its classes and methods accessible within this file. |
| 10 | *Spacer* | Blank line used as a visual separator for code readability. |
| 11 | `import com.smartbudget.database.DatabaseConnection;` | Imports `com.smartbudget.database.DatabaseConnection` to make its classes and methods accessible within this file. |
| 12 | `import com.smartbudget.exceptions.DatabaseException;` | Imports `com.smartbudget.exceptions.DatabaseException` to make its classes and methods accessible within this file. |
| 13 | `import com.smartbudget.models.Income;` | Imports `com.smartbudget.models.Income` to make its classes and methods accessible within this file. |
| 14 | `import com.smartbudget.models.User;` | Imports `com.smartbudget.models.User` to make its classes and methods accessible within this file. |
| 15 | *Spacer* | Blank line used as a visual separator for code readability. |
| 16 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 17 | `* Data Access Object for Income entity.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 18 | `* Handles database operations related to tracking user income.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 19 | `* Demonstrates the implementation of BaseDAO with object composition.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 20 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 21 | `public class IncomeDAO implements BaseDAO<Income> {` | Declares the public class `IncomeDAO` implementing `BaseDAO` as a main architectural component of the module. |
| 22 | *Spacer* | Blank line used as a visual separator for code readability. |
| 23 | `private final DatabaseConnection dbConnection;` | Declares a private immutable (final) instance field `dbConnection` of type `DatabaseConnection` to maintain state with strict encapsulation. |
| 24 | `private final UserDAO userDAO;` | Declares a private immutable (final) instance field `userDAO` of type `UserDAO` to maintain state with strict encapsulation. |
| 25 | *Spacer* | Blank line used as a visual separator for code readability. |
| 26 | `public IncomeDAO() {` | Defines the constructor for `IncomeDAO` to initialize class dependencies, field values, or configuration states. |
| 27 | `this.dbConnection = DatabaseConnection.getInstance();` | Assigns or computes a value for the variable/field `this.dbConnection`. |
| 28 | `this.userDAO = new UserDAO();` | Assigns or computes a value for the variable/field `this.userDAO`. |
| 29 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 30 | *Spacer* | Blank line used as a visual separator for code readability. |
| 31 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 32 | `public Income findById(int id) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 33 | `String query = "SELECT income_id, user_id, amount, description, income_date FROM incomes WHERE income_id = ?";` | Assigns or computes a value for the variable/field `query`. |
| 34 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 35 | `PreparedStatement stmt = conn.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 36 | *Spacer* | Blank line used as a visual separator for code readability. |
| 37 | `stmt.setInt(1, id);` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 38 | `try (ResultSet rs = stmt.executeQuery()) {` | Executes the prepared SELECT query statement, returning a ResultSet representing the returned rows. |
| 39 | `if (rs.next()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 40 | `return mapResultSetToIncome(rs);` | Returns the expression/value `mapResultSetToIncome(rs)` to the calling method, completing this thread's execution. |
| 41 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 42 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 43 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 44 | `throw new DatabaseException("Error finding income by ID: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 45 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 46 | `return null;` | Returns the expression/value `null` to the calling method, completing this thread's execution. |
| 47 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 48 | *Spacer* | Blank line used as a visual separator for code readability. |
| 49 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 50 | `public List<Income> findByUserId(int userId) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 51 | `List<Income> incomes = new ArrayList<>();` | Assigns or computes a value for the variable/field `incomes`. |
| 52 | `String query = "SELECT income_id, user_id, amount, description, income_date " +` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 53 | `"FROM incomes WHERE user_id = ? ORDER BY income_date DESC";` | Assigns or computes a value for the variable/field `user_id`. |
| 54 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 55 | `PreparedStatement stmt = conn.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 56 | *Spacer* | Blank line used as a visual separator for code readability. |
| 57 | `stmt.setInt(1, userId);` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 58 | `try (ResultSet rs = stmt.executeQuery()) {` | Executes the prepared SELECT query statement, returning a ResultSet representing the returned rows. |
| 59 | `while (rs.next()) {` | While loop iterating dynamically as long as the conditional test evaluates to true. |
| 60 | `incomes.add(mapResultSetToIncome(rs));` | Calls the method `incomes.add` to execute its corresponding logic. |
| 61 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 62 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 63 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 64 | `throw new DatabaseException("Error finding incomes by User ID: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 65 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 66 | `return incomes;` | Returns the expression/value `incomes` to the calling method, completing this thread's execution. |
| 67 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 68 | *Spacer* | Blank line used as a visual separator for code readability. |
| 69 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 70 | `public boolean insert(Income entity) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 71 | `String query = "INSERT INTO incomes (user_id, amount, description, income_date) VALUES (?, ?, ?, ?)";` | Assigns or computes a value for the variable/field `query`. |
| 72 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 73 | `PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 74 | *Spacer* | Blank line used as a visual separator for code readability. |
| 75 | `stmt.setInt(1, entity.getUser().getUserId());` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 76 | `stmt.setDouble(2, entity.getAmount());` | Calls the method `stmt.setDouble` to execute its corresponding logic. |
| 77 | `stmt.setString(3, entity.getDescription());` | Calls the method `stmt.setString` to execute its corresponding logic. |
| 78 | `stmt.setDate(4, Date.valueOf(entity.getIncomeDate()));` | Calls the method `stmt.setDate` to execute its corresponding logic. |
| 79 | *Spacer* | Blank line used as a visual separator for code readability. |
| 80 | `int affected = stmt.executeUpdate();` | Executes the prepared INSERT, UPDATE, or DELETE statement, returning the number of affected database rows. |
| 81 | `if (affected > 0) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 82 | `try (ResultSet rs = stmt.getGeneratedKeys()) {` | Declares a ResultSet pointer to scroll through rows returned from a database query execution. |
| 83 | `if (rs.next()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 84 | `entity.setIncomeId(rs.getInt(1));` | Calls the method `entity.setIncomeId` to execute its corresponding logic. |
| 85 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 86 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 87 | `return true;` | Returns the expression/value `true` to the calling method, completing this thread's execution. |
| 88 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 89 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 90 | `throw new DatabaseException("Error inserting income: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 91 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 92 | `return false;` | Returns the expression/value `false` to the calling method, completing this thread's execution. |
| 93 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 94 | *Spacer* | Blank line used as a visual separator for code readability. |
| 95 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 96 | `public boolean update(Income entity) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 97 | `String query = "UPDATE incomes SET user_id = ?, amount = ?, description = ?, income_date = ? WHERE income_id = ?";` | Assigns or computes a value for the variable/field `query`. |
| 98 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 99 | `PreparedStatement stmt = conn.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 100 | *Spacer* | Blank line used as a visual separator for code readability. |
| 101 | `stmt.setInt(1, entity.getUser().getUserId());` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 102 | `stmt.setDouble(2, entity.getAmount());` | Calls the method `stmt.setDouble` to execute its corresponding logic. |
| 103 | `stmt.setString(3, entity.getDescription());` | Calls the method `stmt.setString` to execute its corresponding logic. |
| 104 | `stmt.setDate(4, Date.valueOf(entity.getIncomeDate()));` | Calls the method `stmt.setDate` to execute its corresponding logic. |
| 105 | `stmt.setInt(5, entity.getIncomeId());` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 106 | *Spacer* | Blank line used as a visual separator for code readability. |
| 107 | `return stmt.executeUpdate() > 0;` | Returns the expression/value `stmt.executeUpdate() > 0` to the calling method, completing this thread's execution. |
| 108 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 109 | `throw new DatabaseException("Error updating income: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 110 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 111 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 112 | *Spacer* | Blank line used as a visual separator for code readability. |
| 113 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 114 | `public boolean delete(int id) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 115 | `String query = "DELETE FROM incomes WHERE income_id = ?";` | Assigns or computes a value for the variable/field `query`. |
| 116 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 117 | `PreparedStatement stmt = conn.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 118 | *Spacer* | Blank line used as a visual separator for code readability. |
| 119 | `stmt.setInt(1, id);` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 120 | `return stmt.executeUpdate() > 0;` | Returns the expression/value `stmt.executeUpdate() > 0` to the calling method, completing this thread's execution. |
| 121 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 122 | `throw new DatabaseException("Error deleting income: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 123 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 124 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 125 | *Spacer* | Blank line used as a visual separator for code readability. |
| 126 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 127 | `* Map ResultSet row to Income object.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 128 | `* Demonstrates Object composition by loading the associated User object.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 129 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 130 | `private Income mapResultSetToIncome(ResultSet rs) throws SQLException, DatabaseException {` | Declares a ResultSet pointer to scroll through rows returned from a database query execution. |
| 131 | `int userId = rs.getInt("user_id");` | Assigns or computes a value for the variable/field `userId`. |
| 132 | `User user = userDAO.findById(userId);` | Assigns or computes a value for the variable/field `user`. |
| 133 | *Spacer* | Blank line used as a visual separator for code readability. |
| 134 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 135 | `Income income = new Income();` | Assigns or computes a value for the variable/field `income`. |
| 136 | `income.setIncomeId(rs.getInt("income_id"));` | Calls the method `income.setIncomeId` to execute its corresponding logic. |
| 137 | `income.setUser(user);` | Calls the method `income.setUser` to execute its corresponding logic. |
| 138 | `income.setAmount(rs.getDouble("amount"));` | Calls the method `income.setAmount` to execute its corresponding logic. |
| 139 | `income.setDescription(rs.getString("description"));` | Calls the method `income.setDescription` to execute its corresponding logic. |
| 140 | *Spacer* | Blank line used as a visual separator for code readability. |
| 141 | `Date date = rs.getDate("income_date");` | Assigns or computes a value for the variable/field `date`. |
| 142 | `if (date != null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 143 | `income.setIncomeDate(date.toLocalDate());` | Calls the method `income.setIncomeDate` to execute its corresponding logic. |
| 144 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 145 | `return income;` | Returns the expression/value `income` to the calling method, completing this thread's execution. |
| 146 | `} catch (Exception e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 147 | `throw new DatabaseException("Failed to construct Income model: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 148 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 149 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 150 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `IncomeDAO` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
- **Data Access Object (DAO) Pattern**: Isolates persistent database access operations directly from high-level business logical and controller layers, allowing clean migration of backends.
