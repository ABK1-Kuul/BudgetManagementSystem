# IncomeService.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.services`  
**Component Type:** `Class`  
**Description:** Service layer coordinating income-related operations, validating entry values and persisting changes via IncomeDAO.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private final IncomeDAO incomeDAO;
```

### Declared Methods & Constructors (Behaviors)
```java
public IncomeService();
public List<Income> getIncomesByUser(int userId) throws DatabaseException;
public boolean deleteIncome(int incomeId) throws DatabaseException;
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `IncomeService.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.services;` | Declares the package namespace `com.smartbudget.services` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import java.time.LocalDate;` | Imports `java.time.LocalDate` to make its classes and methods accessible within this file. |
| 4 | `import java.util.List;` | Imports `java.util.List` to make its classes and methods accessible within this file. |
| 5 | *Spacer* | Blank line used as a visual separator for code readability. |
| 6 | `import com.smartbudget.dao.IncomeDAO;` | Imports `com.smartbudget.dao.IncomeDAO` to make its classes and methods accessible within this file. |
| 7 | `import com.smartbudget.exceptions.DatabaseException;` | Imports `com.smartbudget.exceptions.DatabaseException` to make its classes and methods accessible within this file. |
| 8 | `import com.smartbudget.exceptions.ValidationException;` | Imports `com.smartbudget.exceptions.ValidationException` to make its classes and methods accessible within this file. |
| 9 | `import com.smartbudget.models.Income;` | Imports `com.smartbudget.models.Income` to make its classes and methods accessible within this file. |
| 10 | `import com.smartbudget.models.User;` | Imports `com.smartbudget.models.User` to make its classes and methods accessible within this file. |
| 11 | *Spacer* | Blank line used as a visual separator for code readability. |
| 12 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 13 | `* Service class for managing Income transactions.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 14 | `* Coordinates between controller layer and DAO layer, implementing business validations.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 15 | `* Demonstrates the OOP concept of Separation of Concerns.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 16 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 17 | `public class IncomeService {` | Declares the public class `IncomeService` as a main architectural component of the module. |
| 18 | *Spacer* | Blank line used as a visual separator for code readability. |
| 19 | `private final IncomeDAO incomeDAO;` | Declares a private immutable (final) instance field `incomeDAO` of type `IncomeDAO` to maintain state with strict encapsulation. |
| 20 | *Spacer* | Blank line used as a visual separator for code readability. |
| 21 | `public IncomeService() {` | Defines the constructor for `IncomeService` to initialize class dependencies, field values, or configuration states. |
| 22 | `this.incomeDAO = new IncomeDAO();` | Assigns or computes a value for the variable/field `this.incomeDAO`. |
| 23 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 24 | *Spacer* | Blank line used as a visual separator for code readability. |
| 25 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 26 | `* Retrieve incomes associated with a specific user.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 27 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 28 | `public List<Income> getIncomesByUser(int userId) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 29 | `return incomeDAO.findByUserId(userId);` | Returns the expression/value `incomeDAO.findByUserId(userId)` to the calling method, completing this thread's execution. |
| 30 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 31 | *Spacer* | Blank line used as a visual separator for code readability. |
| 32 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 33 | `* Validate and create a new Income transaction.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 34 | `* Demonstrates strict Validation and Defensive Programming.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 35 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 36 | `public Income addIncome(User user, double amount, String description, LocalDate date)` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 37 | `throws ValidationException, DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 38 | *Spacer* | Blank line used as a visual separator for code readability. |
| 39 | `// Input Validations` | Single-line comment explaining: "Input Validations" |
| 40 | `if (user == null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 41 | `throw new ValidationException("A valid user session is required to record income.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 42 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 43 | `if (amount <= 0) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 44 | `throw new ValidationException("Income amount must be strictly greater than 0.00 ETB.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 45 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 46 | `if (date == null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 47 | `throw new ValidationException("Please select a valid date.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 48 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 49 | `if (date.isAfter(LocalDate.now())) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 50 | `throw new ValidationException("Cannot record income for future dates.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 51 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 52 | *Spacer* | Blank line used as a visual separator for code readability. |
| 53 | `// Create and populate the polymorphic model object` | Single-line comment explaining: "Create and populate the polymorphic model object" |
| 54 | `Income income = new Income();` | Assigns or computes a value for the variable/field `income`. |
| 55 | `income.setUser(user);` | Calls the method `income.setUser` to execute its corresponding logic. |
| 56 | `income.setAmount(amount);` | Calls the method `income.setAmount` to execute its corresponding logic. |
| 57 | `income.setDescription(description != null ? description.trim() : "");` | Assigns or computes a value for the variable/field `!`. |
| 58 | `income.setIncomeDate(date);` | Calls the method `income.setIncomeDate` to execute its corresponding logic. |
| 59 | *Spacer* | Blank line used as a visual separator for code readability. |
| 60 | `// Persist via Data Access Layer` | Single-line comment explaining: "Persist via Data Access Layer" |
| 61 | `boolean success = incomeDAO.insert(income);` | Assigns or computes a value for the variable/field `success`. |
| 62 | `if (!success) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 63 | `throw new DatabaseException("Database error: Failed to record the income entry.");` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 64 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 65 | `return income;` | Returns the expression/value `income` to the calling method, completing this thread's execution. |
| 66 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 67 | *Spacer* | Blank line used as a visual separator for code readability. |
| 68 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 69 | `* Delete an income transaction by its unique identifier.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 70 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 71 | `public boolean deleteIncome(int incomeId) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 72 | `return incomeDAO.delete(incomeId);` | Returns the expression/value `incomeDAO.delete(incomeId)` to the calling method, completing this thread's execution. |
| 73 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 74 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `IncomeService` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
- **Service Layer Pattern**: Centralizes transaction and boundary constraints checking in a distinct tier, keeping database access and controllers disconnected.
