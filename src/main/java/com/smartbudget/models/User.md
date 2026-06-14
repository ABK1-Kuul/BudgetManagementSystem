# User.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.models`  
**Component Type:** `Class`  
**Description:** Domain model representing an authenticated system user with credentials, full name, and role for access control.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private int userId;
private String username;
private String email;
private String password;
private LocalDateTime createdAt;
```

### Declared Methods & Constructors (Behaviors)
```java
public User()};
public User(int userId, String username, String email, String password, LocalDateTime createdAt);
public int getUserId()return userId;};
public void setUserId(int userId)this.userId = userId;};
public String getUsername()  return username; };
public void setUsername(String username)  this.username = username; };
public String getEmail()  return email; };
public void setEmail(String email)  this.email = email; };
public String getPassword()  return password; };
public void setPassword(String password)  this.password = password; };
public LocalDateTime getCreatedAt()  return createdAt; };
public void setCreatedAt(LocalDateTime createdAt)  this.createdAt = createdAt; };
public String toString();
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `User.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.models;` | Declares the package namespace `com.smartbudget.models` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import java.time.LocalDateTime;` | Imports `java.time.LocalDateTime` to make its classes and methods accessible within this file. |
| 4 | *Spacer* | Blank line used as a visual separator for code readability. |
| 5 | `public class User {` | Declares the public class `User` as a main architectural component of the module. |
| 6 | `private int userId;` | Declares a private instance field `userId` of type `int` to maintain state with strict encapsulation. |
| 7 | `private String username;` | Declares a private instance field `username` of type `String` to maintain state with strict encapsulation. |
| 8 | `private String email;` | Declares a private instance field `email` of type `String` to maintain state with strict encapsulation. |
| 9 | `private String password;` | Declares a private instance field `password` of type `String` to maintain state with strict encapsulation. |
| 10 | `private LocalDateTime createdAt;` | Declares a private instance field `createdAt` of type `LocalDateTime` to maintain state with strict encapsulation. |
| 11 | *Spacer* | Blank line used as a visual separator for code readability. |
| 12 | `//No-Arg constructor` | Single-line comment explaining: "No-Arg constructor" |
| 13 | `public User(){}` | Defines the constructor for `User` to initialize class dependencies, field values, or configuration states. |
| 14 | *Spacer* | Blank line used as a visual separator for code readability. |
| 15 | `//All-Arg constructor` | Single-line comment explaining: "All-Arg constructor" |
| 16 | `public User(int userId, String username, String email, String password, LocalDateTime createdAt){` | Defines the constructor for `User` to initialize class dependencies, field values, or configuration states. |
| 17 | `this.userId = userId;` | Assigns or computes a value for the variable/field `this.userId`. |
| 18 | `this.username = username;` | Assigns or computes a value for the variable/field `this.username`. |
| 19 | `this.email = email;` | Assigns or computes a value for the variable/field `this.email`. |
| 20 | `this.password = password;` | Assigns or computes a value for the variable/field `this.password`. |
| 21 | `this.createdAt = createdAt;` | Assigns or computes a value for the variable/field `this.createdAt`. |
| 22 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 23 | *Spacer* | Blank line used as a visual separator for code readability. |
| 24 | `//getter and setters` | Single-line comment explaining: "getter and setters" |
| 25 | `public int getUserId(){return userId;}` | Defines the constructor for `User` to initialize class dependencies, field values, or configuration states. |
| 26 | `public void setUserId(int userId){this.userId = userId;}` | Defines the constructor for `User` to initialize class dependencies, field values, or configuration states. |
| 27 | *Spacer* | Blank line used as a visual separator for code readability. |
| 28 | `public String getUsername() { return username; }` | Defines the constructor for `User` to initialize class dependencies, field values, or configuration states. |
| 29 | `public void setUsername(String username) { this.username = username; }` | Defines the constructor for `User` to initialize class dependencies, field values, or configuration states. |
| 30 | *Spacer* | Blank line used as a visual separator for code readability. |
| 31 | `public String getEmail() { return email; }` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 32 | `public void setEmail(String email) { this.email = email; }` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 33 | *Spacer* | Blank line used as a visual separator for code readability. |
| 34 | `public String getPassword() { return password; }` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 35 | `public void setPassword(String password) { this.password = password; }` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 36 | *Spacer* | Blank line used as a visual separator for code readability. |
| 37 | `public LocalDateTime getCreatedAt() { return createdAt; }` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 38 | `public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 39 | *Spacer* | Blank line used as a visual separator for code readability. |
| 40 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 41 | `public String toString() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 42 | `return "User{" + "userId=" + userId + ", username='" + username + '\'' + ", email='" + email + '\'' + '}';` | Returns the expression/value `"User{" + "userId=" + userId + ", username='" + username + '\'' + ", email='" + email + '\'' + '}'` to the calling method, completing this thread's execution. |
| 43 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 44 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `User` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
