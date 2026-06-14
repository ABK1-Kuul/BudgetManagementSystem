# Transaction.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.models`  
**Component Type:** `Class`  
**Description:** Abstract or base model representing generic transactions with shared fields such as ID, amount, date, and description. Promotes inheritance.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Methods & Constructors (Behaviors)
```java
public Transaction() };
public Transaction(int id, User user, double amount, String description, LocalDate date) throws ValidationException;
public int getId();
public void setId(int id);
public User getUser();
public void setUser(User user);
public double getAmount();
public void setAmount(double amount) throws ValidationException;
public String getDescription();
public void setDescription(String description);
public LocalDate getDate();
public void setDate(LocalDate date);
public String toString();
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `Transaction.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.models;` | Declares the package namespace `com.smartbudget.models` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import java.time.LocalDate;` | Imports `java.time.LocalDate` to make its classes and methods accessible within this file. |
| 4 | *Spacer* | Blank line used as a visual separator for code readability. |
| 5 | `import com.smartbudget.exceptions.ValidationException;` | Imports `com.smartbudget.exceptions.ValidationException` to make its classes and methods accessible within this file. |
| 6 | *Spacer* | Blank line used as a visual separator for code readability. |
| 7 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 8 | `* Abstract class representing a general financial transaction.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 9 | `* Demonstrates the OOP principles of Abstraction, Inheritance, and Encapsulation.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 10 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 11 | `public abstract class Transaction {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 12 | `protected int id;` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 13 | `protected User user;           // Aggregation: User exists independently of Transaction` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 14 | `protected double amount;` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 15 | `protected String description;` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 16 | `protected LocalDate date;` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 17 | *Spacer* | Blank line used as a visual separator for code readability. |
| 18 | `// Default No-Args Constructor` | Single-line comment explaining: "Default No-Args Constructor" |
| 19 | `public Transaction() {}` | Defines the constructor for `Transaction` to initialize class dependencies, field values, or configuration states. |
| 20 | *Spacer* | Blank line used as a visual separator for code readability. |
| 21 | `// Parameterized Constructor` | Single-line comment explaining: "Parameterized Constructor" |
| 22 | `public Transaction(int id, User user, double amount, String description, LocalDate date) throws ValidationException {` | Defines the constructor for `Transaction` to initialize class dependencies, field values, or configuration states. |
| 23 | `this.id = id;` | Assigns or computes a value for the variable/field `this.id`. |
| 24 | `this.user = user;` | Assigns or computes a value for the variable/field `this.user`. |
| 25 | `setAmount(amount); // Demonstrates encapsulation: checking validation rules during construction` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 26 | `this.description = description;` | Assigns or computes a value for the variable/field `this.description`. |
| 27 | `this.date = date;` | Assigns or computes a value for the variable/field `this.date`. |
| 28 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 29 | *Spacer* | Blank line used as a visual separator for code readability. |
| 30 | `// Abstract method: Demonstrates Abstraction and forces subclasses to override behavior` | Single-line comment explaining: "Abstract method: Demonstrates Abstraction and forces subclasses to override behavior" |
| 31 | `public abstract String getTransactionType();` | Calls the method `getTransactionType` to execute its corresponding logic. |
| 32 | *Spacer* | Blank line used as a visual separator for code readability. |
| 33 | `// Polymorphic method: Returns positive or negative depending on transaction category` | Single-line comment explaining: "Polymorphic method: Returns positive or negative depending on transaction category" |
| 34 | `public abstract double getSignedAmount();` | Calls the method `getSignedAmount` to execute its corresponding logic. |
| 35 | *Spacer* | Blank line used as a visual separator for code readability. |
| 36 | `// Setters and Getters with strict Encapsulation (Validation rules)` | Single-line comment explaining: "Setters and Getters with strict Encapsulation (Validation rules)" |
| 37 | `public int getId() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 38 | `return id;` | Returns the expression/value `id` to the calling method, completing this thread's execution. |
| 39 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 40 | *Spacer* | Blank line used as a visual separator for code readability. |
| 41 | `public void setId(int id) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 42 | `this.id = id;` | Assigns or computes a value for the variable/field `this.id`. |
| 43 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 44 | *Spacer* | Blank line used as a visual separator for code readability. |
| 45 | `public User getUser() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 46 | `return user;` | Returns the expression/value `user` to the calling method, completing this thread's execution. |
| 47 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 48 | *Spacer* | Blank line used as a visual separator for code readability. |
| 49 | `public void setUser(User user) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 50 | `this.user = user;` | Assigns or computes a value for the variable/field `this.user`. |
| 51 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 52 | *Spacer* | Blank line used as a visual separator for code readability. |
| 53 | `public double getAmount() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 54 | `return amount;` | Returns the expression/value `amount` to the calling method, completing this thread's execution. |
| 55 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 56 | *Spacer* | Blank line used as a visual separator for code readability. |
| 57 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 58 | `* Set amount with safe validation logic.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 59 | `* Demonstrates Encapsulation (Information Hiding and Data Guarding).` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 60 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 61 | `public void setAmount(double amount) throws ValidationException {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 62 | `if (amount <= 0) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 63 | `throw new ValidationException("Transaction amount must be strictly positive.");` | Calls the method `ValidationException` to execute its corresponding logic. |
| 64 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 65 | `this.amount = amount;` | Assigns or computes a value for the variable/field `this.amount`. |
| 66 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 67 | *Spacer* | Blank line used as a visual separator for code readability. |
| 68 | `public String getDescription() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 69 | `return description;` | Returns the expression/value `description` to the calling method, completing this thread's execution. |
| 70 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 71 | *Spacer* | Blank line used as a visual separator for code readability. |
| 72 | `public void setDescription(String description) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 73 | `this.description = description;` | Assigns or computes a value for the variable/field `this.description`. |
| 74 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 75 | *Spacer* | Blank line used as a visual separator for code readability. |
| 76 | `public LocalDate getDate() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 77 | `return date;` | Returns the expression/value `date` to the calling method, completing this thread's execution. |
| 78 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 79 | *Spacer* | Blank line used as a visual separator for code readability. |
| 80 | `public void setDate(LocalDate date) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 81 | `this.date = date;` | Assigns or computes a value for the variable/field `this.date`. |
| 82 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 83 | *Spacer* | Blank line used as a visual separator for code readability. |
| 84 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 85 | `public String toString() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 86 | `return "Transaction{" +` | Returns the expression/value `"Transaction{" +` to the calling method, completing this thread's execution. |
| 87 | `"id=" + id +` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 88 | `", user=" + (user != null ? user.getUsername() : "null") +` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 89 | `", amount=" + amount +` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 90 | `", description='" + description + '\'' +` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 91 | `", date=" + date +` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 92 | `'}';` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 93 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 94 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `Transaction` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
