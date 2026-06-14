# DashboardService.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.services`  
**Component Type:** `Class`  
**Description:** High-level analysis service that aggregate statistics (totals, averages, monthly trends) to feed data into the main dashboard panels.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private final ExpenseDAO expenseDAO;
private final IncomeDAO incomeDAO;
```

### Declared Methods & Constructors (Behaviors)
```java
public DashboardService();
public List<Transaction> getAllTransactions(int userId) throws DatabaseException;
public double getTotalIncome(int userId) throws DatabaseException;
public double getTotalExpenses(int userId) throws DatabaseException;
public double getNetBalance(int userId) throws DatabaseException;
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `DashboardService.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.services;` | Declares the package namespace `com.smartbudget.services` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import java.util.ArrayList;` | Imports `java.util.ArrayList` to make its classes and methods accessible within this file. |
| 4 | `import java.util.List;` | Imports `java.util.List` to make its classes and methods accessible within this file. |
| 5 | *Spacer* | Blank line used as a visual separator for code readability. |
| 6 | `import com.smartbudget.dao.ExpenseDAO;` | Imports `com.smartbudget.dao.ExpenseDAO` to make its classes and methods accessible within this file. |
| 7 | `import com.smartbudget.dao.IncomeDAO;` | Imports `com.smartbudget.dao.IncomeDAO` to make its classes and methods accessible within this file. |
| 8 | `import com.smartbudget.exceptions.DatabaseException;` | Imports `com.smartbudget.exceptions.DatabaseException` to make its classes and methods accessible within this file. |
| 9 | `import com.smartbudget.models.Expense;` | Imports `com.smartbudget.models.Expense` to make its classes and methods accessible within this file. |
| 10 | `import com.smartbudget.models.Income;` | Imports `com.smartbudget.models.Income` to make its classes and methods accessible within this file. |
| 11 | `import com.smartbudget.models.Transaction;` | Imports `com.smartbudget.models.Transaction` to make its classes and methods accessible within this file. |
| 12 | *Spacer* | Blank line used as a visual separator for code readability. |
| 13 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 14 | `* Service class for Dashboard aggregation metrics.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 15 | `* Demonstrates the power of Polymorphism by managing subclass instances uniformly` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 16 | `* under a common parent superclass reference.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 17 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 18 | `public class DashboardService {` | Declares the public class `DashboardService` as a main architectural component of the module. |
| 19 | *Spacer* | Blank line used as a visual separator for code readability. |
| 20 | `private final ExpenseDAO expenseDAO;` | Declares a private immutable (final) instance field `expenseDAO` of type `ExpenseDAO` to maintain state with strict encapsulation. |
| 21 | `private final IncomeDAO incomeDAO;` | Declares a private immutable (final) instance field `incomeDAO` of type `IncomeDAO` to maintain state with strict encapsulation. |
| 22 | *Spacer* | Blank line used as a visual separator for code readability. |
| 23 | `public DashboardService() {` | Defines the constructor for `DashboardService` to initialize class dependencies, field values, or configuration states. |
| 24 | `this.expenseDAO = new ExpenseDAO();` | Assigns or computes a value for the variable/field `this.expenseDAO`. |
| 25 | `this.incomeDAO = new IncomeDAO();` | Assigns or computes a value for the variable/field `this.incomeDAO`. |
| 26 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 27 | *Spacer* | Blank line used as a visual separator for code readability. |
| 28 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 29 | `* Retrieve a polymorphic list of all transactions (Expenses and Incomes) for a user.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 30 | `* Demonstrates Polymorphism: treating subclasses (Expense, Income) as their parent (Transaction).` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 31 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 32 | `public List<Transaction> getAllTransactions(int userId) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 33 | `List<Transaction> transactions = new ArrayList<>();` | Assigns or computes a value for the variable/field `transactions`. |
| 34 | *Spacer* | Blank line used as a visual separator for code readability. |
| 35 | `// Load expenses (Subclass 1)` | Single-line comment explaining: "Load expenses (Subclass 1)" |
| 36 | `List<Expense> expenses = expenseDAO.findByUserId(userId);` | Assigns or computes a value for the variable/field `expenses`. |
| 37 | `transactions.addAll(expenses);` | Calls the method `transactions.addAll` to execute its corresponding logic. |
| 38 | *Spacer* | Blank line used as a visual separator for code readability. |
| 39 | `// Load incomes (Subclass 2)` | Single-line comment explaining: "Load incomes (Subclass 2)" |
| 40 | `List<Income> incomes = incomeDAO.findByUserId(userId);` | Assigns or computes a value for the variable/field `incomes`. |
| 41 | `transactions.addAll(incomes);` | Calls the method `transactions.addAll` to execute its corresponding logic. |
| 42 | *Spacer* | Blank line used as a visual separator for code readability. |
| 43 | `// Sort transactions by date descending (optional sorting using custom comparator or standard library)` | Single-line comment explaining: "Sort transactions by date descending (optional sorting using custom comparator or standard library)" |
| 44 | `transactions.sort((t1, t2) -> {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 45 | `if (t1.getDate() == null \|\| t2.getDate() == null) return 0;` | Assigns or computes a value for the variable/field `(t1.getDate()`. |
| 46 | `return t2.getDate().compareTo(t1.getDate());` | Returns the expression/value `t2.getDate().compareTo(t1.getDate())` to the calling method, completing this thread's execution. |
| 47 | `});` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 48 | *Spacer* | Blank line used as a visual separator for code readability. |
| 49 | `return transactions;` | Returns the expression/value `transactions` to the calling method, completing this thread's execution. |
| 50 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 51 | *Spacer* | Blank line used as a visual separator for code readability. |
| 52 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 53 | `* Compute total income recorded for a user.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 54 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 55 | `public double getTotalIncome(int userId) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 56 | `List<Income> incomes = incomeDAO.findByUserId(userId);` | Assigns or computes a value for the variable/field `incomes`. |
| 57 | `double total = 0.00;` | Assigns or computes a value for the variable/field `total`. |
| 58 | `for (Income income : incomes) {` | Loop statement iterating through a collection, array, or list of objects. |
| 59 | `total += income.getAmount();` | Assigns or computes a value for the variable/field `+`. |
| 60 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 61 | `return total;` | Returns the expression/value `total` to the calling method, completing this thread's execution. |
| 62 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 63 | *Spacer* | Blank line used as a visual separator for code readability. |
| 64 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 65 | `* Compute total expenses recorded for a user.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 66 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 67 | `public double getTotalExpenses(int userId) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 68 | `List<Expense> expenses = expenseDAO.findByUserId(userId);` | Assigns or computes a value for the variable/field `expenses`. |
| 69 | `double total = 0.00;` | Assigns or computes a value for the variable/field `total`. |
| 70 | `for (Expense expense : expenses) {` | Loop statement iterating through a collection, array, or list of objects. |
| 71 | `total += expense.getAmount();` | Assigns or computes a value for the variable/field `+`. |
| 72 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 73 | `return total;` | Returns the expression/value `total` to the calling method, completing this thread's execution. |
| 74 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 75 | *Spacer* | Blank line used as a visual separator for code readability. |
| 76 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 77 | `* Compute the remaining net balance for a user.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 78 | `* Demonstrates Polymorphism and Abstraction by invoking the overridden polymorphic 'getSignedAmount()' method.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 79 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 80 | `public double getNetBalance(int userId) throws DatabaseException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 81 | `List<Transaction> transactions = getAllTransactions(userId);` | Assigns or computes a value for the variable/field `transactions`. |
| 82 | `double balance = 0.00;` | Assigns or computes a value for the variable/field `balance`. |
| 83 | *Spacer* | Blank line used as a visual separator for code readability. |
| 84 | `for (Transaction transaction : transactions) {` | Loop statement iterating through a collection, array, or list of objects. |
| 85 | `// Polymorphic call: Expense returns negative, Income returns positive.` | Single-line comment explaining: "Polymorphic call: Expense returns negative, Income returns positive." |
| 86 | `balance += transaction.getSignedAmount();` | Assigns or computes a value for the variable/field `+`. |
| 87 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 88 | `return balance;` | Returns the expression/value `balance` to the calling method, completing this thread's execution. |
| 89 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 90 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `DashboardService` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
- **Service Layer Pattern**: Centralizes transaction and boundary constraints checking in a distinct tier, keeping database access and controllers disconnected.
