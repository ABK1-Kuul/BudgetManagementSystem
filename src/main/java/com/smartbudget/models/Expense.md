# Expense.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.models`  
**Component Type:** `Class`  
**Description:** Domain model representing an expense entry with fields for ID, category, amount, date, and descriptions, extending basic transaction structures.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Methods & Constructors (Behaviors)
```java
public Expense();
public Expense(int expenseId, User user, Category category, double amount, String description, LocalDate expenseDate) throws ValidationException;
public String getTransactionType();
public double getSignedAmount();
public Category getCategory();
public void setCategory(Category category);
public int getExpenseId();
public void setExpenseId(int expenseId);
public LocalDate getExpenseDate();
public void setExpenseDate(LocalDate expenseDate);
public String toString();
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `Expense.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.models;` | Declares the package namespace `com.smartbudget.models` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import java.time.LocalDate;` | Imports `java.time.LocalDate` to make its classes and methods accessible within this file. |
| 4 | *Spacer* | Blank line used as a visual separator for code readability. |
| 5 | `import com.smartbudget.exceptions.ValidationException;` | Imports `com.smartbudget.exceptions.ValidationException` to make its classes and methods accessible within this file. |
| 6 | *Spacer* | Blank line used as a visual separator for code readability. |
| 7 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 8 | `* Class representing an Expense transaction.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 9 | `* Demonstrates the OOP principles of Inheritance (extends Transaction) and` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 10 | `* Aggregation (has-a Category relationship, where Category lives independently of Expense).` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 11 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 12 | `public class Expense extends Transaction {` | Declares the public class `Expense` extending `Transaction` as a main architectural component of the module. |
| 13 | `private Category category; // Aggregation relationship` | Declares a private instance field `category` of type `Category` to maintain state with strict encapsulation. |
| 14 | *Spacer* | Blank line used as a visual separator for code readability. |
| 15 | `// No-Args Constructor` | Single-line comment explaining: "No-Args Constructor" |
| 16 | `public Expense() {` | Defines the constructor for `Expense` to initialize class dependencies, field values, or configuration states. |
| 17 | `super();` | Calls the method `super` to execute its corresponding logic. |
| 18 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 19 | *Spacer* | Blank line used as a visual separator for code readability. |
| 20 | `// Parameterized Constructor` | Single-line comment explaining: "Parameterized Constructor" |
| 21 | `public Expense(int expenseId, User user, Category category, double amount, String description, LocalDate expenseDate) throws ValidationException {` | Defines the constructor for `Expense` to initialize class dependencies, field values, or configuration states. |
| 22 | `// Call parent class constructor to initialize common fields` | Single-line comment explaining: "Call parent class constructor to initialize common fields" |
| 23 | `super(expenseId, user, amount, description, expenseDate);` | Calls the method `super` to execute its corresponding logic. |
| 24 | `this.category = category;` | Assigns or computes a value for the variable/field `this.category`. |
| 25 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 26 | *Spacer* | Blank line used as a visual separator for code readability. |
| 27 | `// Implement Abstraction contract: returns the transaction category type description` | Single-line comment explaining: "Implement Abstraction contract: returns the transaction category type description" |
| 28 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 29 | `public String getTransactionType() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 30 | `return "Expense";` | Returns the expression/value `"Expense"` to the calling method, completing this thread's execution. |
| 31 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 32 | *Spacer* | Blank line used as a visual separator for code readability. |
| 33 | `// Implement Polymorphic signed amount contract: Expenses are negative cash flows` | Single-line comment explaining: "Implement Polymorphic signed amount contract: Expenses are negative cash flows" |
| 34 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 35 | `public double getSignedAmount() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 36 | `return -amount;` | Returns the expression/value `-amount` to the calling method, completing this thread's execution. |
| 37 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 38 | *Spacer* | Blank line used as a visual separator for code readability. |
| 39 | `// Getter and Setter for Category (demonstrating encapsulation and aggregation)` | Single-line comment explaining: "Getter and Setter for Category (demonstrating encapsulation and aggregation)" |
| 40 | `public Category getCategory() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 41 | `return category;` | Returns the expression/value `category` to the calling method, completing this thread's execution. |
| 42 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 43 | *Spacer* | Blank line used as a visual separator for code readability. |
| 44 | `public void setCategory(Category category) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 45 | `this.category = category;` | Assigns or computes a value for the variable/field `this.category`. |
| 46 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 47 | *Spacer* | Blank line used as a visual separator for code readability. |
| 48 | `// Backward compatibility delegates: map standard names to parent class Transaction fields` | Single-line comment explaining: "Backward compatibility delegates: map standard names to parent class Transaction fields" |
| 49 | `public int getExpenseId() {` | Defines the constructor for `Expense` to initialize class dependencies, field values, or configuration states. |
| 50 | `return getId();` | Returns the expression/value `getId()` to the calling method, completing this thread's execution. |
| 51 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 52 | *Spacer* | Blank line used as a visual separator for code readability. |
| 53 | `public void setExpenseId(int expenseId) {` | Defines the constructor for `Expense` to initialize class dependencies, field values, or configuration states. |
| 54 | `setId(expenseId);` | Calls the method `setId` to execute its corresponding logic. |
| 55 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 56 | *Spacer* | Blank line used as a visual separator for code readability. |
| 57 | `public LocalDate getExpenseDate() {` | Defines the constructor for `Expense` to initialize class dependencies, field values, or configuration states. |
| 58 | `return getDate();` | Returns the expression/value `getDate()` to the calling method, completing this thread's execution. |
| 59 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 60 | *Spacer* | Blank line used as a visual separator for code readability. |
| 61 | `public void setExpenseDate(LocalDate expenseDate) {` | Defines the constructor for `Expense` to initialize class dependencies, field values, or configuration states. |
| 62 | `setDate(expenseDate);` | Calls the method `setDate` to execute its corresponding logic. |
| 63 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 64 | *Spacer* | Blank line used as a visual separator for code readability. |
| 65 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 66 | `public String toString() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 67 | `return "Expense{" +` | Returns the expression/value `"Expense{" +` to the calling method, completing this thread's execution. |
| 68 | `"expenseId=" + getExpenseId() +` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 69 | `", user=" + (user != null ? user.getUsername() : "null") +` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 70 | `", category=" + (category != null ? category.getCategoryName() : "null") +` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 71 | `", amount=" + amount +` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 72 | `", description='" + description + '\'' +` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 73 | `", expenseDate=" + getExpenseDate() +` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 74 | `'}';` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 75 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 76 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `Expense` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
