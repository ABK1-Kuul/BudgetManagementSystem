# CategoryDAO.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.dao`  
**Component Type:** `Class`  
**Description:** Database access object handling all CRUD operations for the categories table, mapping database rows to Category models.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private final DatabaseConnection dbConnection;
```

### Declared Methods & Constructors (Behaviors)
```java
public CategoryDAO();
public Category findById(int id) throws DatabaseException;
public List<Category> getAllCategories() throws DatabaseException;
public List<Category> findByUserId(int userId) throws DatabaseException;
public boolean insert(Category entity) throws DatabaseException;
public boolean update(Category entity) throws DatabaseException;
public boolean delete(int id) throws DatabaseException;
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `CategoryDAO.java` to its execution intent, role, and compiler instruction:

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
| 12 | `import com.smartbudget.models.Category;` | Imports `com.smartbudget.models.Category` to make its classes and methods accessible within this file. |
| 13 | *Spacer* | Blank line used as a visual separator for code readability. |
| 14 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 15 | `* Data Access Object for Category entity.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 16 | `* Handles database operations related to expense categories.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 17 | `* Demonstrates the implementation of the BaseDAO interface.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 18 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 19 | `public class CategoryDAO implements BaseDAO<Category> {` | Declares the public class `CategoryDAO` implementing `BaseDAO` as a main architectural component of the module. |
| 20 | *Spacer* | Blank line used as a visual separator for code readability. |
| 21 | `private final DatabaseConnection dbConnection;` | Declares a private immutable (final) instance field `dbConnection` of type `DatabaseConnection` to maintain state with strict encapsulation. |
| 22 | *Spacer* | Blank line used as a visual separator for code readability. |
| 23 | `public CategoryDAO() {` | Defines the constructor for `CategoryDAO` to initialize class dependencies, field values, or configuration states. |
| 24 | `this.dbConnection = DatabaseConnection.getInstance();` | Assigns or computes a value for the variable/field `this.dbConnection`. |
| 25 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 26 | *Spacer* | Blank line used as a visual separator for code readability. |
| 27 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 28 | `public Category findById(int id) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 29 | `String query = "SELECT category_id, category_name FROM categories WHERE category_id = ?";` | Assigns or computes a value for the variable/field `query`. |
| 30 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 31 | `PreparedStatement stmt = conn.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 32 | *Spacer* | Blank line used as a visual separator for code readability. |
| 33 | `stmt.setInt(1, id);` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 34 | `try (ResultSet rs = stmt.executeQuery()) {` | Executes the prepared SELECT query statement, returning a ResultSet representing the returned rows. |
| 35 | `if (rs.next()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 36 | `return new Category(rs.getInt("category_id"), rs.getString("category_name"));` | Returns the expression/value `new Category(rs.getInt("category_id"), rs.getString("category_name"))` to the calling method, completing this thread's execution. |
| 37 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 38 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 39 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 40 | `throw new DatabaseException("Error retrieving category by ID: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 41 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 42 | `return null;` | Returns the expression/value `null` to the calling method, completing this thread's execution. |
| 43 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 44 | *Spacer* | Blank line used as a visual separator for code readability. |
| 45 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 46 | `* Retrieve all categories from the database.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 47 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 48 | `public List<Category> getAllCategories() throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 49 | `List<Category> categories = new ArrayList<>();` | Assigns or computes a value for the variable/field `categories`. |
| 50 | `String query = "SELECT category_id, category_name FROM categories";` | Assigns or computes a value for the variable/field `query`. |
| 51 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 52 | `PreparedStatement stmt = conn.prepareStatement(query);` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 53 | `ResultSet rs = stmt.executeQuery()) {` | Executes the prepared SELECT query statement, returning a ResultSet representing the returned rows. |
| 54 | *Spacer* | Blank line used as a visual separator for code readability. |
| 55 | `while (rs.next()) {` | While loop iterating dynamically as long as the conditional test evaluates to true. |
| 56 | `categories.add(new Category(rs.getInt("category_id"), rs.getString("category_name")));` | Calls the method `categories.add` to execute its corresponding logic. |
| 57 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 58 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 59 | `throw new DatabaseException("Error retrieving categories: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 60 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 61 | `return categories;` | Returns the expression/value `categories` to the calling method, completing this thread's execution. |
| 62 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 63 | *Spacer* | Blank line used as a visual separator for code readability. |
| 64 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 65 | `public List<Category> findByUserId(int userId) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 66 | `// Categories are global, so returning all categories` | Single-line comment explaining: "Categories are global, so returning all categories" |
| 67 | `return getAllCategories();` | Returns the expression/value `getAllCategories()` to the calling method, completing this thread's execution. |
| 68 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 69 | *Spacer* | Blank line used as a visual separator for code readability. |
| 70 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 71 | `public boolean insert(Category entity) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 72 | `String query = "INSERT INTO categories (category_name) VALUES (?)";` | Assigns or computes a value for the variable/field `query`. |
| 73 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 74 | `PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 75 | *Spacer* | Blank line used as a visual separator for code readability. |
| 76 | `stmt.setString(1, entity.getCategoryName());` | Calls the method `stmt.setString` to execute its corresponding logic. |
| 77 | `int affected = stmt.executeUpdate();` | Executes the prepared INSERT, UPDATE, or DELETE statement, returning the number of affected database rows. |
| 78 | `if (affected > 0) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 79 | `try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {` | Declares a ResultSet pointer to scroll through rows returned from a database query execution. |
| 80 | `if (generatedKeys.next()) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 81 | `entity.setCategoryId(generatedKeys.getInt(1));` | Calls the method `entity.setCategoryId` to execute its corresponding logic. |
| 82 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 83 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 84 | `return true;` | Returns the expression/value `true` to the calling method, completing this thread's execution. |
| 85 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 86 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 87 | `throw new DatabaseException("Error inserting category: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 88 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 89 | `return false;` | Returns the expression/value `false` to the calling method, completing this thread's execution. |
| 90 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 91 | *Spacer* | Blank line used as a visual separator for code readability. |
| 92 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 93 | `public boolean update(Category entity) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 94 | `String query = "UPDATE categories SET category_name = ? WHERE category_id = ?";` | Assigns or computes a value for the variable/field `query`. |
| 95 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 96 | `PreparedStatement stmt = conn.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 97 | *Spacer* | Blank line used as a visual separator for code readability. |
| 98 | `stmt.setString(1, entity.getCategoryName());` | Calls the method `stmt.setString` to execute its corresponding logic. |
| 99 | `stmt.setInt(2, entity.getCategoryId());` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 100 | `return stmt.executeUpdate() > 0;` | Returns the expression/value `stmt.executeUpdate() > 0` to the calling method, completing this thread's execution. |
| 101 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 102 | `throw new DatabaseException("Error updating category: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 103 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 104 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 105 | *Spacer* | Blank line used as a visual separator for code readability. |
| 106 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 107 | `public boolean delete(int id) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 108 | `String query = "DELETE FROM categories WHERE category_id = ?";` | Assigns or computes a value for the variable/field `query`. |
| 109 | `try (Connection conn = dbConnection.getConnection();` | Try-with-resources statement ensuring that database connections, statements, or file resources are closed automatically at exit. |
| 110 | `PreparedStatement stmt = conn.prepareStatement(query)) {` | Prepares an SQL query statement with placeholding parameters to prevent SQL injection vulnerabilities. |
| 111 | *Spacer* | Blank line used as a visual separator for code readability. |
| 112 | `stmt.setInt(1, id);` | Calls the method `stmt.setInt` to execute its corresponding logic. |
| 113 | `return stmt.executeUpdate() > 0;` | Returns the expression/value `stmt.executeUpdate() > 0` to the calling method, completing this thread's execution. |
| 114 | `} catch (SQLException e) {` | Catch block intercepting specific exceptions, supporting safe logging, rollbacks, and throwing domain-specific exceptions. |
| 115 | `throw new DatabaseException("Error deleting category: " + e.getMessage(), e);` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 116 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 117 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 118 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `CategoryDAO` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
- **Data Access Object (DAO) Pattern**: Isolates persistent database access operations directly from high-level business logical and controller layers, allowing clean migration of backends.
