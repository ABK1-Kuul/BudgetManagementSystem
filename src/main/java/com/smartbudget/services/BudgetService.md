# BudgetService.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.services`  
**Component Type:** `Class`  
**Description:** Business service managing budget limits, verifying if transactions exceed active budgets, and coordinating data with the DAO layers.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private final BudgetDAO budgetDAO;
private final ExpenseDAO expenseDAO;
```

### Declared Methods & Constructors (Behaviors)
```java
public BudgetService();
public List<Budget> getBudgetsByUser(int userId) throws DatabaseException;
public Budget getBudgetForPeriod(int userId, int month, int year) throws DatabaseException;
public double getRemainingBudget(int userId, int month, int year) throws DatabaseException;
public double getSpentForPeriod(int userId, int month, int year) throws DatabaseException;
public boolean deleteBudget(int budgetId) throws DatabaseException;
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `BudgetService.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.services;` | Declares the package namespace `com.smartbudget.services` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import java.time.LocalDate;` | Imports `java.time.LocalDate` to make its classes and methods accessible within this file. |
| 4 | `import java.util.List;` | Imports `java.util.List` to make its classes and methods accessible within this file. |
| 5 | *Spacer* | Blank line used as a visual separator for code readability. |
| 6 | `import com.smartbudget.dao.BudgetDAO;` | Imports `com.smartbudget.dao.BudgetDAO` to make its classes and methods accessible within this file. |
| 7 | `import com.smartbudget.dao.ExpenseDAO;` | Imports `com.smartbudget.dao.ExpenseDAO` to make its classes and methods accessible within this file. |
| 8 | `import com.smartbudget.exceptions.DatabaseException;` | Imports `com.smartbudget.exceptions.DatabaseException` to make its classes and methods accessible within this file. |
| 9 | `import com.smartbudget.exceptions.ValidationException;` | Imports `com.smartbudget.exceptions.ValidationException` to make its classes and methods accessible within this file. |
| 10 | `import com.smartbudget.models.Budget;` | Imports `com.smartbudget.models.Budget` to make its classes and methods accessible within this file. |
| 11 | `import com.smartbudget.models.Expense;` | Imports `com.smartbudget.models.Expense` to make its classes and methods accessible within this file. |
| 12 | `import com.smartbudget.models.User;` | Imports `com.smartbudget.models.User` to make its classes and methods accessible within this file. |
| 13 | *Spacer* | Blank line used as a visual separator for code readability. |
| 14 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 15 | `* Service class for managing monthly Budgets.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 16 | `* Demonstrates composition of data layers to perform complex calculations.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 17 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 18 | `public class BudgetService {` | Declares the public class `BudgetService` as a main architectural component of the module. |
| 19 | *Spacer* | Blank line used as a visual separator for code readability. |
| 20 | `private final BudgetDAO budgetDAO;` | Declares a private immutable (final) instance field `budgetDAO` of type `BudgetDAO` to maintain state with strict encapsulation. |
| 21 | `private final ExpenseDAO expenseDAO;` | Declares a private immutable (final) instance field `expenseDAO` of type `ExpenseDAO` to maintain state with strict encapsulation. |
| 22 | *Spacer* | Blank line used as a visual separator for code readability. |
| 23 | `public BudgetService() {` | Defines the constructor for `BudgetService` to initialize class dependencies, field values, or configuration states. |
| 24 | `this.budgetDAO = new BudgetDAO();` | Assigns or computes a value for the variable/field `this.budgetDAO`. |
| 25 | `this.expenseDAO = new ExpenseDAO();` | Assigns or computes a value for the variable/field `this.expenseDAO`. |
| 26 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 27 | *Spacer* | Blank line used as a visual separator for code readability. |
| 28 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 29 | `* Fetch a user's budget list.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 30 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 31 | `public List<Budget> getBudgetsByUser(int userId) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 32 | `return budgetDAO.findByUserId(userId);` | Returns the expression/value `budgetDAO.findByUserId(userId)` to the calling method, completing this thread's execution. |
| 33 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 34 | *Spacer* | Blank line used as a visual separator for code readability. |
| 35 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 36 | `* Get active budget for specific user during a specific month/year.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 37 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 38 | `public Budget getBudgetForPeriod(int userId, int month, int year) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 39 | `return budgetDAO.findByUserAndPeriod(userId, month, year);` | Returns the expression/value `budgetDAO.findByUserAndPeriod(userId, month, year)` to the calling method, completing this thread's execution. |
| 40 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 41 | *Spacer* | Blank line used as a visual separator for code readability. |
| 42 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 43 | `* Save or update a monthly budget value.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 44 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 45 | `public Budget setBudget(User user, int month, int year, double amount)` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 46 | `throws ValidationException, DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 47 | *Spacer* | Blank line used as a visual separator for code readability. |
| 48 | `if (user == null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 49 | `throw new ValidationException("User session is required to establish a budget.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 50 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 51 | `if (month < 1 \|\| month > 12) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 52 | `throw new ValidationException("Invalid month provided.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 53 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 54 | `if (year < 1900 \|\| year > 2100) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 55 | `throw new ValidationException("Invalid year provided.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 56 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 57 | `if (amount <= 0) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 58 | `throw new ValidationException("Budget amount must be strictly greater than 0.00 ETB.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 59 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 60 | *Spacer* | Blank line used as a visual separator for code readability. |
| 61 | `// Check if budget already exists for this period` | Single-line comment explaining: "Check if budget already exists for this period" |
| 62 | `Budget existing = budgetDAO.findByUserAndPeriod(user.getUserId(), month, year);` | Assigns or computes a value for the variable/field `existing`. |
| 63 | `if (existing != null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 64 | `existing.setAmount(amount);` | Calls the method `existing.setAmount` to execute its corresponding logic. |
| 65 | `boolean success = budgetDAO.update(existing);` | Assigns or computes a value for the variable/field `success`. |
| 66 | `if (!success) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 67 | `throw new DatabaseException("Database error: Failed to update the budget record.");` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 68 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 69 | `return existing;` | Returns the expression/value `existing` to the calling method, completing this thread's execution. |
| 70 | `} else {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 71 | `Budget budget = new Budget();` | Assigns or computes a value for the variable/field `budget`. |
| 72 | `budget.setUser(user);` | Calls the method `budget.setUser` to execute its corresponding logic. |
| 73 | `budget.setMonth(month);` | Calls the method `budget.setMonth` to execute its corresponding logic. |
| 74 | `budget.setYear(year);` | Calls the method `budget.setYear` to execute its corresponding logic. |
| 75 | `budget.setAmount(amount);` | Calls the method `budget.setAmount` to execute its corresponding logic. |
| 76 | *Spacer* | Blank line used as a visual separator for code readability. |
| 77 | `boolean success = budgetDAO.insert(budget);` | Assigns or computes a value for the variable/field `success`. |
| 78 | `if (!success) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 79 | `throw new DatabaseException("Database error: Failed to create the new budget entry.");` | Calls the method `DatabaseException` to execute its corresponding logic. |
| 80 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 81 | `return budget;` | Returns the expression/value `budget` to the calling method, completing this thread's execution. |
| 82 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 83 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 84 | *Spacer* | Blank line used as a visual separator for code readability. |
| 85 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 86 | `* Compute remaining budget balance for a given month and year.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 87 | `* Demonstrates Aggregation/Composition of Expense calculations.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 88 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 89 | `public double getRemainingBudget(int userId, int month, int year) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 90 | `Budget budget = getBudgetForPeriod(userId, month, year);` | Assigns or computes a value for the variable/field `budget`. |
| 91 | `if (budget == null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 92 | `return 0.00;` | Returns the expression/value `0.00` to the calling method, completing this thread's execution. |
| 93 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 94 | *Spacer* | Blank line used as a visual separator for code readability. |
| 95 | `double totalBudget = budget.getAmount();` | Assigns or computes a value for the variable/field `totalBudget`. |
| 96 | `double totalSpent = getSpentForPeriod(userId, month, year);` | Assigns or computes a value for the variable/field `totalSpent`. |
| 97 | *Spacer* | Blank line used as a visual separator for code readability. |
| 98 | `return totalBudget - totalSpent;` | Returns the expression/value `totalBudget - totalSpent` to the calling method, completing this thread's execution. |
| 99 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 100 | *Spacer* | Blank line used as a visual separator for code readability. |
| 101 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 102 | `* Calculate sum of expenses for a specific month and year.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 103 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 104 | `public double getSpentForPeriod(int userId, int month, int year) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 105 | `List<Expense> expenses = expenseDAO.findByUserId(userId);` | Assigns or computes a value for the variable/field `expenses`. |
| 106 | `double totalSpent = 0.00;` | Assigns or computes a value for the variable/field `totalSpent`. |
| 107 | *Spacer* | Blank line used as a visual separator for code readability. |
| 108 | `for (Expense expense : expenses) {` | Loop statement iterating through a collection, array, or list of objects. |
| 109 | `LocalDate expDate = expense.getExpenseDate();` | Assigns or computes a value for the variable/field `expDate`. |
| 110 | `if (expDate != null && expDate.getMonthValue() == month && expDate.getYear() == year) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 111 | `totalSpent += expense.getAmount();` | Assigns or computes a value for the variable/field `+`. |
| 112 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 113 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 114 | `return totalSpent;` | Returns the expression/value `totalSpent` to the calling method, completing this thread's execution. |
| 115 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 116 | *Spacer* | Blank line used as a visual separator for code readability. |
| 117 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 118 | `* Delete a budget plan by its identifier.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 119 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 120 | `public boolean deleteBudget(int budgetId) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 121 | `return budgetDAO.delete(budgetId);` | Returns the expression/value `budgetDAO.delete(budgetId)` to the calling method, completing this thread's execution. |
| 122 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 123 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `BudgetService` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
- **Service Layer Pattern**: Centralizes transaction and boundary constraints checking in a distinct tier, keeping database access and controllers disconnected.
