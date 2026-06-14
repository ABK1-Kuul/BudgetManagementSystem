# Category.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.models`  
**Component Type:** `Class`  
**Description:** Domain model representing custom transaction categories, defining fields for category names and optional thresholds.

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Fields (Encapsulated State)
```java
private int categoryId;
private String categoryName;
```

### Declared Methods & Constructors (Behaviors)
```java
public Category()};
public Category(int categoryId, String categoryName);
public int getCategoryId()return categoryId;};
public void setCategoryId(int categoryId)this.categoryId = categoryId;};
public String getCategoryName()return categoryName;};
public void setCategoryName(String categoryName)this.categoryName = categoryName;};
public String toString();
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `Category.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.models;` | Declares the package namespace `com.smartbudget.models` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `public class Category {` | Declares the public class `Category` as a main architectural component of the module. |
| 4 | `private int categoryId;` | Declares a private instance field `categoryId` of type `int` to maintain state with strict encapsulation. |
| 5 | `private String categoryName;` | Declares a private instance field `categoryName` of type `String` to maintain state with strict encapsulation. |
| 6 | *Spacer* | Blank line used as a visual separator for code readability. |
| 7 | `//No-Args constructor` | Single-line comment explaining: "No-Args constructor" |
| 8 | `public Category(){}` | Defines the constructor for `Category` to initialize class dependencies, field values, or configuration states. |
| 9 | *Spacer* | Blank line used as a visual separator for code readability. |
| 10 | `//All-Args constructor` | Single-line comment explaining: "All-Args constructor" |
| 11 | `public Category(int categoryId, String categoryName){` | Defines the constructor for `Category` to initialize class dependencies, field values, or configuration states. |
| 12 | `this.categoryId = categoryId;` | Assigns or computes a value for the variable/field `this.categoryId`. |
| 13 | `this.categoryName = categoryName;` | Assigns or computes a value for the variable/field `this.categoryName`. |
| 14 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 15 | *Spacer* | Blank line used as a visual separator for code readability. |
| 16 | `//Getters and Setters` | Single-line comment explaining: "Getters and Setters" |
| 17 | `public int getCategoryId(){return categoryId;}` | Defines the constructor for `Category` to initialize class dependencies, field values, or configuration states. |
| 18 | `public void setCategoryId(int categoryId){this.categoryId = categoryId;}` | Defines the constructor for `Category` to initialize class dependencies, field values, or configuration states. |
| 19 | *Spacer* | Blank line used as a visual separator for code readability. |
| 20 | `public String getCategoryName(){return categoryName;}` | Defines the constructor for `Category` to initialize class dependencies, field values, or configuration states. |
| 21 | `public void setCategoryName(String categoryName){this.categoryName = categoryName;}` | Defines the constructor for `Category` to initialize class dependencies, field values, or configuration states. |
| 22 | *Spacer* | Blank line used as a visual separator for code readability. |
| 23 | `@Override` | Compiler annotation indicating that this method overrides a method declared in its parent class or interface. |
| 24 | `public String toString() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 25 | `return "Category{" + "categoryId=" + categoryId + ", categoryName='" + categoryName + '\'' + '}';` | Returns the expression/value `"Category{" + "categoryId=" + categoryId + ", categoryName='" + categoryName + '\'' + '}'` to the calling method, completing this thread's execution. |
| 26 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 27 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 28 | *Spacer* | Blank line used as a visual separator for code readability. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `Category` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
