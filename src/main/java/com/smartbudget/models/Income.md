# Income.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.models`  
**Component Type:** `Class`  
**Description:** Domain model representing an income entry containing tracking details like source, amount, date, and description.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Methods & Constructors (Behaviors)
```java
public Income();
public Income(int incomeId, User user, double amount, String description, LocalDate incomeDate) throws ValidationException;
public String getTransactionType();
public double getSignedAmount();
public int getIncomeId();
public void setIncomeId(int incomeId);
public LocalDate getIncomeDate();
public void setIncomeDate(LocalDate incomeDate);
public String toString();
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `Income.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.models;` | Declares the package namespace `com.smartbudget.models` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import java.time.LocalDate;` | Imports `java.time.LocalDate` to make its classes and methods accessible within this file. |
| 4 | *Spacer* | Blank line used as a visual separator for code readability. |
| 5 | `import com.smartbudget.exceptions.ValidationException;` | Imports `com.smartbudget.exceptions.ValidationException` to make its classes and methods accessible within this file. |
| 6 | *Spacer* | Blank line used as a visual separator for code readability. |
| 7 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 8 | `* Class representing an Income transaction.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 9 | `* Demonstrates the OOP principle of Inheritance (extends Transaction).` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 10 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 11 | `public class Income extends Transaction {` | Declares the public class `Income` extending `Transaction` as a main architectural component of the module. |
| 12 | *Spacer* | Blank line used as a visual separator for code readability. |
| 13 | `// No-Args Constructor` | Single-line comment explaining: "No-Args Constructor" |
| 14 | `public Income() {` | Defines the constructor for `Income` to initialize class dependencies, field values, or configuration states. |
| 15 | `super();` | Calls the method `super` to execute its corresponding logic. |
| 16 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 17 | *Spacer* | Blank line used as a visual separator for code readability. |
| 18 | `// Parameterized Constructor` | Single-line comment explaining: "Parameterized Constructor" |
| 19 | `public Income(int incomeId, User user, double amount, String description, LocalDate incomeDate) throws ValidationException {` | Defines the constructor for `Income` to initialize class dependencies, field values, or configuration states. |
| 20 | `// Call parent class constructor to initialize common fields` | Single-line comment explaining: "Call parent class constructor to initialize common fields" |
| 21 | `super(incomeId, user, amount, description, incomeDate);` | Calls the method `super` to execute its corresponding logic. |
| 22 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 23 | *Spacer* | Blank line used as a visual separator for code readability. |
| 24 | `// Implement Abstraction contract: returns the transaction category type description` | Single-line comment explaining: "Implement Abstraction contract: returns the transaction category type description" |
| 25 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 26 | `public String getTransactionType() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 27 | `return "Income";` | Returns the expression/value `"Income"` to the calling method, completing this thread's execution. |
| 28 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 29 | *Spacer* | Blank line used as a visual separator for code readability. |
| 30 | `// Implement Polymorphic signed amount contract: Incomes are positive cash flows` | Single-line comment explaining: "Implement Polymorphic signed amount contract: Incomes are positive cash flows" |
| 31 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 32 | `public double getSignedAmount() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 33 | `return amount;` | Returns the expression/value `amount` to the calling method, completing this thread's execution. |
| 34 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 35 | *Spacer* | Blank line used as a visual separator for code readability. |
| 36 | `// Backward compatibility delegates: map standard names to parent class Transaction fields` | Single-line comment explaining: "Backward compatibility delegates: map standard names to parent class Transaction fields" |
| 37 | `public int getIncomeId() {` | Defines the constructor for `Income` to initialize class dependencies, field values, or configuration states. |
| 38 | `return getId();` | Returns the expression/value `getId()` to the calling method, completing this thread's execution. |
| 39 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 40 | *Spacer* | Blank line used as a visual separator for code readability. |
| 41 | `public void setIncomeId(int incomeId) {` | Defines the constructor for `Income` to initialize class dependencies, field values, or configuration states. |
| 42 | `setId(incomeId);` | Calls the method `setId` to execute its corresponding logic. |
| 43 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 44 | *Spacer* | Blank line used as a visual separator for code readability. |
| 45 | `public LocalDate getIncomeDate() {` | Defines the constructor for `Income` to initialize class dependencies, field values, or configuration states. |
| 46 | `return getDate();` | Returns the expression/value `getDate()` to the calling method, completing this thread's execution. |
| 47 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 48 | *Spacer* | Blank line used as a visual separator for code readability. |
| 49 | `public void setIncomeDate(LocalDate incomeDate) {` | Defines the constructor for `Income` to initialize class dependencies, field values, or configuration states. |
| 50 | `setDate(incomeDate);` | Calls the method `setDate` to execute its corresponding logic. |
| 51 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 52 | *Spacer* | Blank line used as a visual separator for code readability. |
| 53 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 54 | `public String toString() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 55 | `return "Income{" +` | Returns the expression/value `"Income{" +` to the calling method, completing this thread's execution. |
| 56 | `"incomeId=" + getIncomeId() +` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 57 | `", user=" + (user != null ? user.getUsername() : "null") +` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 58 | `", amount=" + amount +` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 59 | `", description='" + description + '\'' +` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 60 | `", incomeDate=" + getIncomeDate() +` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 61 | `'}';` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 62 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 63 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `Income` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
