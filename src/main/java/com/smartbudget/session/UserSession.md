# UserSession.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.session`  
**Component Type:** `Class`  
**Description:** Thread-safe singleton session manager storing the currently logged-in user details to handle state and authorization across UI controllers.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private static UserSession instance;
private User currentUser;
```

### Declared Methods & Constructors (Behaviors)
```java
private UserSession();
public static synchronized UserSession getInstance();
public User getCurrentUser();
public void setCurrentUser(User user);
public int getCurrentUserId();
public String getCurrentUsername();
public boolean isLoggedIn();
public void logout();
public String toString();
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `UserSession.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.session;` | Declares the package namespace `com.smartbudget.session` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import com.smartbudget.models.User;` | Imports `com.smartbudget.models.User` to make its classes and methods accessible within this file. |
| 4 | *Spacer* | Blank line used as a visual separator for code readability. |
| 5 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 6 | `* Singleton session manager for storing current logged-in user.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 7 | `* Used across controllers to access user context without passing parameters.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 8 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 9 | `public class UserSession {` | Declares the public class `UserSession` as a main architectural component of the module. |
| 10 | *Spacer* | Blank line used as a visual separator for code readability. |
| 11 | `private static UserSession instance;` | Declares a private class-level (static) instance field `instance` of type `UserSession` to maintain state with strict encapsulation. |
| 12 | `private User currentUser;` | Declares a private instance field `currentUser` of type `User` to maintain state with strict encapsulation. |
| 13 | *Spacer* | Blank line used as a visual separator for code readability. |
| 14 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 15 | `* Private constructor - prevents direct instantiation.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 16 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 17 | `private UserSession() {` | Defines the constructor for `UserSession` to initialize class dependencies, field values, or configuration states. |
| 18 | `this.currentUser = null;` | Assigns or computes a value for the variable/field `this.currentUser`. |
| 19 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 20 | *Spacer* | Blank line used as a visual separator for code readability. |
| 21 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 22 | `* Get singleton instance of UserSession.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 23 | `* @return UserSession instance` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 24 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 25 | `public static synchronized UserSession getInstance() {` | Defines the constructor for `UserSession` to initialize class dependencies, field values, or configuration states. |
| 26 | `if (instance == null) {` | Conditional IF statement evaluating business criteria or checking for null references before proceeding. |
| 27 | `instance = new UserSession();` | Assigns or computes a value for the variable/field `instance`. |
| 28 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 29 | `return instance;` | Returns the expression/value `instance` to the calling method, completing this thread's execution. |
| 30 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 31 | *Spacer* | Blank line used as a visual separator for code readability. |
| 32 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 33 | `* Get current logged-in user.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 34 | `* @return Current User object, or null if not logged in` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 35 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 36 | `public User getCurrentUser() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 37 | `return currentUser;` | Returns the expression/value `currentUser` to the calling method, completing this thread's execution. |
| 38 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 39 | *Spacer* | Blank line used as a visual separator for code readability. |
| 40 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 41 | `* Set current logged-in user (called after successful login).` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 42 | `* @param user User object to set as current` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 43 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 44 | `public void setCurrentUser(User user) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 45 | `this.currentUser = user;` | Assigns or computes a value for the variable/field `this.currentUser`. |
| 46 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 47 | *Spacer* | Blank line used as a visual separator for code readability. |
| 48 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 49 | `* Get current user ID.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 50 | `* @return User ID, or -1 if not logged in` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 51 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 52 | `public int getCurrentUserId() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 53 | `return currentUser != null ? currentUser.getUserId() : -1;` | Returns the expression/value `currentUser != null ? currentUser.getUserId() : -1` to the calling method, completing this thread's execution. |
| 54 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 55 | *Spacer* | Blank line used as a visual separator for code readability. |
| 56 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 57 | `* Get current username.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 58 | `* @return Username, or null if not logged in` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 59 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 60 | `public String getCurrentUsername() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 61 | `return currentUser != null ? currentUser.getUsername() : null;` | Returns the expression/value `currentUser != null ? currentUser.getUsername() : null` to the calling method, completing this thread's execution. |
| 62 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 63 | *Spacer* | Blank line used as a visual separator for code readability. |
| 64 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 65 | `* Check if user is logged in.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 66 | `* @return true if user is logged in, false otherwise` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 67 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 68 | `public boolean isLoggedIn() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 69 | `return currentUser != null;` | Returns the expression/value `currentUser != null` to the calling method, completing this thread's execution. |
| 70 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 71 | *Spacer* | Blank line used as a visual separator for code readability. |
| 72 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 73 | `* Clear session (called on logout).` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 74 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 75 | `public void logout() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 76 | `this.currentUser = null;` | Assigns or computes a value for the variable/field `this.currentUser`. |
| 77 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 78 | *Spacer* | Blank line used as a visual separator for code readability. |
| 79 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 80 | `* Get session info for debugging.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 81 | `* @return Session state string` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 82 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 83 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 84 | `public String toString() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 85 | `return "UserSession{" + "currentUser=" + (currentUser != null ? currentUser.getUsername() : "null") + '}';` | Returns the expression/value `"UserSession{" + "currentUser=" + (currentUser != null ? currentUser.getUsername() : "null") + '}'` to the calling method, completing this thread's execution. |
| 86 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 87 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `UserSession` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
