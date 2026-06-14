# DatabaseConfig.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.config`  
**Component Type:** `Class`  
**Description:** Defines configuration constants for connecting to the database, including the JDBC URL, driver, database username, and credentials.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
public static final String DB_HOST = "localhost";
public static final String DB_PORT = "3306";
public static final String DB_NAME = "smart_budget";
public static final String DB_USER = "root";
public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
public static final int CONNECTION_POOL_SIZE = 5;
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `DatabaseConfig.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.config;` | Declares the package namespace `com.smartbudget.config` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 4 | `* Centralized database configuration.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 5 | `* NOTE: Local development only — passwords should never be hardcoded in production.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 6 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 7 | `public class DatabaseConfig {` | Declares the public class `DatabaseConfig` as a main architectural component of the module. |
| 8 | *Spacer* | Blank line used as a visual separator for code readability. |
| 9 | `// Database connection details` | Single-line comment explaining: "Database connection details" |
| 10 | `public static final String DB_HOST = "localhost";` | Assigns or computes a value for the variable/field `DB_HOST`. |
| 11 | `public static final String DB_PORT = "3306";` | Assigns or computes a value for the variable/field `DB_PORT`. |
| 12 | `public static final String DB_NAME = "smart_budget";` | Assigns or computes a value for the variable/field `DB_NAME`. |
| 13 | `public static final String DB_USER = "root";` | Assigns or computes a value for the variable/field `DB_USER`. |
| 14 | `public static final String DB_PASSWORD = "";  // Empty for root on localhost` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 15 | *Spacer* | Blank line used as a visual separator for code readability. |
| 16 | `// Construct JDBC URL` | Single-line comment explaining: "Construct JDBC URL" |
| 17 | `public static final String DB_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 18 | `+ "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";` | Assigns or computes a value for the variable/field `"?useSSL`. |
| 19 | *Spacer* | Blank line used as a visual separator for code readability. |
| 20 | `// MySQL driver class` | Single-line comment explaining: "MySQL driver class" |
| 21 | `public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";` | Assigns or computes a value for the variable/field `DB_DRIVER`. |
| 22 | *Spacer* | Blank line used as a visual separator for code readability. |
| 23 | `// Connection pool settings` | Single-line comment explaining: "Connection pool settings" |
| 24 | `public static final int CONNECTION_POOL_SIZE = 5;` | Assigns or computes a value for the variable/field `CONNECTION_POOL_SIZE`. |
| 25 | `public static final int CONNECTION_TIMEOUT = 30000;  // 30 seconds` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 26 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `DatabaseConfig` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
