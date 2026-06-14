# ExpenseService.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.services`  
**Component Type:** `Class`  
**Description:** Service layer validating and processing expense records, enforcing logic like limit checking before allowing writes.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private final ExpenseDAO expenseDAO;
private final CategoryDAO categoryDAO;
```

### Declared Methods & Constructors (Behaviors)
```java
public ExpenseService();
public List<Category> getCategories() throws DatabaseException;
public List<Expense> getExpensesByUser(int userId) throws DatabaseException;
public boolean deleteExpense(int expenseId) throws DatabaseException;
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `ExpenseService.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.services;` | Declares the package namespace `com.smartbudget.services` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import java.time.LocalDate;` | Imports `java.time.LocalDate` to make its classes and methods accessible within this file. |
| 4 | `import java.util.List;` | Imports `java.util.List` to make its classes and methods accessible within this file. |
| 5 | *Spacer* | Blank line used as a visual separator for code readability. |
| 6 | `import com.smartbudget.dao.CategoryDAO;` | Imports `com.smartbudget.dao.CategoryDAO` to make its classes and methods accessible within this file. |
| 7 | `import com.smartbudget.dao.ExpenseDAO;` | Imports `com.smartbudget.dao.ExpenseDAO` to make its classes and methods accessible within this file. |
| 8 | `import com.smartbudget.exceptions.DatabaseException;` | Imports `com.smartbudget.exceptions.DatabaseException` to make its classes and methods accessible within this file. |
| 9 | `import com.smartbudget.exceptions.ValidationException;` | Imports `com.smartbudget.exceptions.ValidationException` to make its classes and methods accessible within this file. |
| 10 | `import com.smartbudget.models.Category;` | Imports `com.smartbudget.models.Category` to make its classes and methods accessible within this file. |
| 11 | `import com.smartbudget.models.Expense;` | Imports `com.smartbudget.models.Expense` to make its classes and methods accessible within this file. |
| 12 | `import com.smartbudget.models.User;` | Imports `com.smartbudget.models.User` to make its classes and methods accessible within this file. |
| 13 | *Spacer* | Blank line used as a visual separator for code readability. |
| 14 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 15 | `* Service class for managing Expense transactions.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 16 | `* Coordinates between controller layer and DAO layer, implementing business validations.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 17 | `* Demonstrates the OOP concept of Separation of Concerns.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 18 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 19 | `public class ExpenseService {` | Declares the public class `ExpenseService` as a main architectural component of the module. |
| 20 | *Spacer* | Blank line used as a visual separator for code readability. |
| 21 | `private final ExpenseDAO expenseDAO;` | Declares a private immutable (final) instance field `expenseDAO` of type `ExpenseDAO` to maintain state with strict encapsulation. |
| 22 | `private final CategoryDAO categoryDAO;` | Declares a private immutable (final) instance field `categoryDAO` of type `CategoryDAO` to maintain state with strict encapsulation. |
| 23 | *Spacer* | Blank line used as a visual separator for code readability. |
| 24 | `public ExpenseService() {` | Defines the constructor for `ExpenseService` to initialize class dependencies, field values, or configuration states. |
| 25 | `this.expenseDAO = new ExpenseDAO();` | Assigns or computes a value for the variable/field `this.expenseDAO`. |
| 26 | `this.categoryDAO = new CategoryDAO();` | Assigns or computes a value for the variable/field `this.categoryDAO`. |
| 27 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 28 | *Spacer* | Blank line used as a visual separator for code readability. |
| 29 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 30 | `* Retrieve all available expense categories.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 31 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 32 | `public List<Category> getCategories() throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 33 | `return categoryDAO.getAllCategories();` | Returns the expression/value `categoryDAO.getAllCategories()` to the calling method, completing this thread's execution. |
| 34 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 35 | *Spacer* | Blank line used as a visual separator for code readability. |
| 36 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 37 | `* Retrieve expenses associated with a specific user.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 38 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 39 | `public List<Expense> getExpensesByUser(int userId) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 40 | `return expenseDAO.findByUserId(userId);` | Returns the expression/value `expenseDAO.findByUserId(userId)` to the calling method, completing this thread's execution. |
| 41 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 42 | *Spacer* | Blank line used as a visual separator for code readability. |
| 43 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 44 | `* Validate and create a new Expense transaction.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 45 | `* Demonstrates strict Validation and Defensive Programming.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 46 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 47 | `public Expense addExpense(User user, Category category, double amount, String description, LocalDate date)` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 48 | `throws ValidationException, DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 49 | *Spacer* | Blank line used as a visual separator for code readability. |
| 50 | `// Input Validations` | Single-line comment explaining: "Input Validations" |
| 51 | `if (user == null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 52 | `throw new ValidationException("A valid user session is required to record an expense.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 53 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 54 | `if (category == null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 55 | `throw new ValidationException("Please select a transaction category.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 56 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 57 | `if (amount <= 0) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 58 | `throw new ValidationException("Expense amount must be strictly greater than 0.00 ETB.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 59 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 60 | `if (date == null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 61 | `throw new ValidationException("Please select a valid date.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 62 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 63 | `if (date.isAfter(LocalDate.now())) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 64 | `throw new ValidationException("Cannot record expenses for future dates.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 65 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 66 | *Spacer* | Blank line used as a visual separator for code readability. |
| 67 | `// Create and populate the polymorphic model object` | Single-line comment explaining: "Create and populate the polymorphic model object" |
| 68 | `Expense expense = new Expense();` | Assigns or computes a value for the variable/field `expense`. |
| 69 | `expense.setUser(user);` | Calls the method `expense.setUser` to execute its corresponding logic. |
| 70 | `expense.setCategory(category);` | Calls the method `expense.setCategory` to execute its corresponding logic. |
| 71 | `expense.setAmount(amount);` | Calls the method `expense.setAmount` to execute its corresponding logic. |
| 72 | `expense.setDescription(description != null ? description.trim() : "");` | Assigns or computes a value for the variable/field `!`. |
| 73 | `expense.setExpenseDate(date);` | Calls the method `expense.setExpenseDate` to execute its corresponding logic. |
| 74 | *Spacer* | Blank line used as a visual separator for code readability. |
| 75 | `// Persist via Data Access Layer` | Single-line comment explaining: "Persist via Data Access Layer" |
| 76 | `boolean success = expenseDAO.insert(expense);` | Assigns or computes a value for the variable/field `success`. |
| 77 | `if (!success) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 78 | `throw new DatabaseException("Database error: Failed to record the expense entry.");` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 79 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 80 | `return expense;` | Returns the expression/value `expense` to the calling method, completing this thread's execution. |
| 81 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 82 | *Spacer* | Blank line used as a visual separator for code readability. |
| 83 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 84 | `* Delete an expense transaction by its unique identifier.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 85 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 86 | `public boolean deleteExpense(int expenseId) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 87 | `return expenseDAO.delete(expenseId);` | Returns the expression/value `expenseDAO.delete(expenseId)` to the calling method, completing this thread's execution. |
| 88 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 89 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `ExpenseService` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
- **Service Layer Pattern**: Centralizes transaction and boundary constraints checking in a distinct tier, keeping database access and controllers disconnected.
