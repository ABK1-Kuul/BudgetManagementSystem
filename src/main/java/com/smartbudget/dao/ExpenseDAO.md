# ExpenseDAO.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.dao`  
**Component Type:** `Class`  
**Description:** Database access layer managing SQL operations for the expenses table, supporting record insertion, updates, deletions, and custom aggregation queries.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private final DatabaseConnection dbConnection;
private final UserDAO userDAO;
private final CategoryDAO categoryDAO;
```

### Declared Methods & Constructors (Behaviors)
```java
public ExpenseDAO();
public Expense findById(int id) throws DatabaseException;
public List<Expense> findByUserId(int userId) throws DatabaseException;
public boolean insert(Expense entity) throws DatabaseException;
public boolean update(Expense entity) throws DatabaseException;
public boolean delete(int id) throws DatabaseException;
private Expense mapResultSetToExpense(ResultSet rs) throws SQLException, DatabaseException;
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `ExpenseDAO.java` to its execution intent, role, and compiler instruction:

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
| 13 | `import com.smartbudget.models.Category;` | Imports `com.smartbudget.models.Category` to make its classes and methods accessible within this file. |
| 14 | `import com.smartbudget.models.Expense;` | Imports `com.smartbudget.models.Expense` to make its classes and methods accessible within this file. |
| 15 | `import com.smartbudget.models.User;` | Imports `com.smartbudget.models.User` to make its classes and methods accessible within this file. |
| 16 | *Spacer* | Blank line used as a visual separator for code readability. |
| 17 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 18 | `* Data Access Object for Expense entity.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 19 | `* Handles database operations related to tracking user expenses.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 20 | `* Demonstrates the implementation of BaseDAO with object composition/aggregation.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 21 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 22 | `public class ExpenseDAO implements BaseDAO<Expense> {` | Declares the public class `ExpenseDAO` implementing `BaseDAO` as a main architectural component of the module. |
| 23 | *Spacer* | Blank line used as a visual separator for code readability. |
| 24 | `private final DatabaseConnection dbConnection;` | Declares a private immutable (final) instance field `dbConnection` of type `DatabaseConnection` to maintain state with strict encapsulation. |
| 25 | `private final UserDAO userDAO;` | Declares a private immutable (final) instance field `userDAO` of type `UserDAO` to maintain state with strict encapsulation. |
| 26 | `private final CategoryDAO categoryDAO;` | Declares a private immutable (final) instance field `categoryDAO` of type `CategoryDAO` to maintain state with strict encapsulation. |
| 27 | *Spacer* | Blank line used as a visual separator for code readability. |
| 28 | `public ExpenseDAO() {` | Defines the constructor for `ExpenseDAO` to initialize class dependencies, field values, or configuration states. |
| 29 | `this.dbConnection = DatabaseConnection.getInstance();` | Assigns or computes a value for the variable/field `this.dbConnection`. |
| 30 | `this.userDAO = new UserDAO();` | Assigns or computes a value for the variable/field `this.userDAO`. |
| 31 | `this.categoryDAO = new CategoryDAO();` | Assigns or computes a value for the variable/field `this.categoryDAO`. |
| 32 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 33 | *Spacer* | Blank line used as a visual separator for code readability. |
| 34 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 35 | `public Expense findById(int id) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 36 | `String query = "SELECT expense_id, user_id, category_id, amount, description, expense_date FROM expenses WHERE expense_id = ?";` | Assigns or computes a value for the variable/field `query`. |
| 37 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 38 | `PreparedStatement stmt = conn.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 39 | *Spacer* | Blank line used as a visual separator for code readability. |
| 40 | `stmt.setInt(1, id);` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 41 | `try (ResultSet rs = stmt.executeQuery()) {` | Executes the prepared SELECT query statement, returning a ResultSet representing the returned rows. |
| 42 | `if (rs.next()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 43 | `return mapResultSetToExpense(rs);` | Returns the expression/value `mapResultSetToExpense(rs)` to the calling method, completing this thread's execution. |
| 44 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 45 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 46 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 47 | `throw new DatabaseException("Error finding expense by ID: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 48 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 49 | `return null;` | Returns the expression/value `null` to the calling method, completing this thread's execution. |
| 50 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 51 | *Spacer* | Blank line used as a visual separator for code readability. |
| 52 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 53 | `public List<Expense> findByUserId(int userId) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 54 | `List<Expense> expenses = new ArrayList<>();` | Assigns or computes a value for the variable/field `expenses`. |
| 55 | `String query = "SELECT expense_id, user_id, category_id, amount, description, expense_date " +` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 56 | `"FROM expenses WHERE user_id = ? ORDER BY expense_date DESC";` | Assigns or computes a value for the variable/field `user_id`. |
| 57 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 58 | `PreparedStatement stmt = conn.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 59 | *Spacer* | Blank line used as a visual separator for code readability. |
| 60 | `stmt.setInt(1, userId);` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 61 | `try (ResultSet rs = stmt.executeQuery()) {` | Executes the prepared SELECT query statement, returning a ResultSet representing the returned rows. |
| 62 | `while (rs.next()) {` | While loop iterating dynamically as long as the conditional test evaluates to true. |
| 63 | `expenses.add(mapResultSetToExpense(rs));` | Calls the method `expenses.add` to execute its corresponding logic. |
| 64 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 65 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 66 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 67 | `throw new DatabaseException("Error finding expenses by User ID: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 68 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 69 | `return expenses;` | Returns the expression/value `expenses` to the calling method, completing this thread's execution. |
| 70 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 71 | *Spacer* | Blank line used as a visual separator for code readability. |
| 72 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 73 | `public boolean insert(Expense entity) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 74 | `String query = "INSERT INTO expenses (user_id, category_id, amount, description, expense_date) VALUES (?, ?, ?, ?, ?)";` | Assigns or computes a value for the variable/field `query`. |
| 75 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 76 | `PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 77 | *Spacer* | Blank line used as a visual separator for code readability. |
| 78 | `stmt.setInt(1, entity.getUser().getUserId());` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 79 | `stmt.setInt(2, entity.getCategory().getCategoryId());` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 80 | `stmt.setDouble(3, entity.getAmount());` | Calls the method `stmt.setDouble` to execute its corresponding logic. |
| 81 | `stmt.setString(4, entity.getDescription());` | Calls the method `stmt.setString` to execute its corresponding logic. |
| 82 | `stmt.setDate(5, Date.valueOf(entity.getExpenseDate()));` | Calls the method `stmt.setDate` to execute its corresponding logic. |
| 83 | *Spacer* | Blank line used as a visual separator for code readability. |
| 84 | `int affected = stmt.executeUpdate();` | Executes the prepared INSERT, UPDATE, or DELETE statement, returning the number of affected database rows. |
| 85 | `if (affected > 0) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 86 | `try (ResultSet rs = stmt.getGeneratedKeys()) {` | Declares a ResultSet pointer to scroll through rows returned from a database query execution. |
| 87 | `if (rs.next()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 88 | `entity.setExpenseId(rs.getInt(1));` | Calls the method `entity.setExpenseId` to execute its corresponding logic. |
| 89 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 90 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 91 | `return true;` | Returns the expression/value `true` to the calling method, completing this thread's execution. |
| 92 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 93 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 94 | `throw new DatabaseException("Error inserting expense: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 95 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 96 | `return false;` | Returns the expression/value `false` to the calling method, completing this thread's execution. |
| 97 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 98 | *Spacer* | Blank line used as a visual separator for code readability. |
| 99 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 100 | `public boolean update(Expense entity) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 101 | `String query = "UPDATE expenses SET user_id = ?, category_id = ?, amount = ?, description = ?, expense_date = ? WHERE expense_id = ?";` | Assigns or computes a value for the variable/field `query`. |
| 102 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 103 | `PreparedStatement stmt = conn.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 104 | *Spacer* | Blank line used as a visual separator for code readability. |
| 105 | `stmt.setInt(1, entity.getUser().getUserId());` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 106 | `stmt.setInt(2, entity.getCategory().getCategoryId());` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 107 | `stmt.setDouble(3, entity.getAmount());` | Calls the method `stmt.setDouble` to execute its corresponding logic. |
| 108 | `stmt.setString(4, entity.getDescription());` | Calls the method `stmt.setString` to execute its corresponding logic. |
| 109 | `stmt.setDate(5, Date.valueOf(entity.getExpenseDate()));` | Calls the method `stmt.setDate` to execute its corresponding logic. |
| 110 | `stmt.setInt(6, entity.getExpenseId());` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 111 | *Spacer* | Blank line used as a visual separator for code readability. |
| 112 | `return stmt.executeUpdate() > 0;` | Returns the expression/value `stmt.executeUpdate() > 0` to the calling method, completing this thread's execution. |
| 113 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 114 | `throw new DatabaseException("Error updating expense: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 115 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 116 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 117 | *Spacer* | Blank line used as a visual separator for code readability. |
| 118 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 119 | `public boolean delete(int id) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 120 | `String query = "DELETE FROM expenses WHERE expense_id = ?";` | Assigns or computes a value for the variable/field `query`. |
| 121 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 122 | `PreparedStatement stmt = conn.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 123 | *Spacer* | Blank line used as a visual separator for code readability. |
| 124 | `stmt.setInt(1, id);` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 125 | `return stmt.executeUpdate() > 0;` | Returns the expression/value `stmt.executeUpdate() > 0` to the calling method, completing this thread's execution. |
| 126 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 127 | `throw new DatabaseException("Error deleting expense: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 128 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 129 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 130 | *Spacer* | Blank line used as a visual separator for code readability. |
| 131 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 132 | `* Map ResultSet row to Expense object.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 133 | `* Demonstrates Object Composition/Aggregation by loading User and Category objects.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 134 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 135 | `private Expense mapResultSetToExpense(ResultSet rs) throws SQLException, DatabaseException {` | Declares a ResultSet pointer to scroll through rows returned from a database query execution. |
| 136 | `int userId = rs.getInt("user_id");` | Assigns or computes a value for the variable/field `userId`. |
| 137 | `int categoryId = rs.getInt("category_id");` | Assigns or computes a value for the variable/field `categoryId`. |
| 138 | *Spacer* | Blank line used as a visual separator for code readability. |
| 139 | `// Retrieve associated aggregated objects` | Single-line comment explaining: "Retrieve associated aggregated objects" |
| 140 | `User user = userDAO.findById(userId);` | Assigns or computes a value for the variable/field `user`. |
| 141 | `Category category = categoryDAO.findById(categoryId);` | Assigns or computes a value for the variable/field `category`. |
| 142 | *Spacer* | Blank line used as a visual separator for code readability. |
| 143 | `try {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 144 | `Expense expense = new Expense();` | Assigns or computes a value for the variable/field `expense`. |
| 145 | `expense.setExpenseId(rs.getInt("expense_id"));` | Calls the method `expense.setExpenseId` to execute its corresponding logic. |
| 146 | `expense.setUser(user);` | Calls the method `expense.setUser` to execute its corresponding logic. |
| 147 | `expense.setCategory(category);` | Calls the method `expense.setCategory` to execute its corresponding logic. |
| 148 | `expense.setAmount(rs.getDouble("amount"));` | Calls the method `expense.setAmount` to execute its corresponding logic. |
| 149 | `expense.setDescription(rs.getString("description"));` | Calls the method `expense.setDescription` to execute its corresponding logic. |
| 150 | *Spacer* | Blank line used as a visual separator for code readability. |
| 151 | `Date date = rs.getDate("expense_date");` | Assigns or computes a value for the variable/field `date`. |
| 152 | `if (date != null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 153 | `expense.setExpenseDate(date.toLocalDate());` | Calls the method `expense.setExpenseDate` to execute its corresponding logic. |
| 154 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 155 | `return expense;` | Returns the expression/value `expense` to the calling method, completing this thread's execution. |
| 156 | `} catch (Exception e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 157 | `throw new DatabaseException("Failed to construct Expense model: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 158 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 159 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 160 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `ExpenseDAO` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
- **Data Access Object (DAO) Pattern**: Isolates persistent database access operations directly from high-level business logical and controller layers, allowing clean migration of backends.
