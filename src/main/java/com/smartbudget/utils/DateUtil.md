# DateUtil.java - Detailed Explanation & Logical Analysis

## 📌 Overview & Role
**Namespace/Package:** `com.smartbudget.utils`  
**Component Type:** `Class`  
**Description:** Core utility class containing static helper methods for parsing, formatting, and manipulating date values (LocalDate, SqlDate).

This source file represents a clean-code implementation of a `Class` in our MVC-layered architecture, adhering to OOP encapsulation, strict exception handling, and JDBC resources lifecycle safety.

## 📐 Blueprint & Logical Structure

### Declared Methods & Constructors (Behaviors)
```java
public static String formatToDatabase(LocalDate date);
public static String formatToDisplay(LocalDate date);
public static LocalDate parseDate(String dateString);
public static YearMonth getCurrentMonth();
public static int getCurrentYear();
public static int getCurrentMonthValue();
```

## 🔍 Line-by-Line Technical Analysis

Below is a detailed line-by-line logical analysis mapping each line of `DateUtil.java` to its execution intent, role, and compiler instruction:

| Line # | Code Line | Detailed Logical Explanation |
| :--- | :--- | :--- |
| 1 | `package com.smartbudget.utils;` | Declares the package namespace `com.smartbudget.utils` to organize classes logically and prevent namespace collision. |
| 2 | *Spacer* | Blank line used as a visual separator for code readability. |
| 3 | `import java.time.LocalDate;` | Imports `java.time.LocalDate` to make its classes and methods accessible within this file. |
| 4 | `import java.time.YearMonth;` | Imports `java.time.YearMonth` to make its classes and methods accessible within this file. |
| 5 | `import java.time.format.DateTimeFormatter;` | Imports `java.time.format.DateTimeFormatter` to make its classes and methods accessible within this file. |
| 6 | *Spacer* | Blank line used as a visual separator for code readability. |
| 7 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 8 | `* Utility for date formatting and manipulation.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 9 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 10 | `public class DateUtil {` | Declares the public class `DateUtil` as a main architectural component of the module. |
| 11 | *Spacer* | Blank line used as a visual separator for code readability. |
| 12 | `private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");` | Declares a private immutable (final) class-level (static) instance field `DATE_FORMATTER` of type `DateTimeFormatter` to maintain state with strict encapsulation. |
| 13 | `private static final DateTimeFormatter DISPLAY_FORMATTER = DateTimeFormatter.ofPattern("MMM dd, yyyy");` | Declares a private immutable (final) class-level (static) instance field `DISPLAY_FORMATTER` of type `DateTimeFormatter` to maintain state with strict encapsulation. |
| 14 | *Spacer* | Blank line used as a visual separator for code readability. |
| 15 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 16 | `* Format LocalDate to standard database format (yyyy-MM-dd).` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 17 | `* @param date LocalDate to format` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 18 | `* @return Formatted date string` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 19 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 20 | `public static String formatToDatabase(LocalDate date) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 21 | `return date.format(DATE_FORMATTER);` | Returns the expression/value `date.format(DATE_FORMATTER)` to the calling method, completing this thread's execution. |
| 22 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 23 | *Spacer* | Blank line used as a visual separator for code readability. |
| 24 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 25 | `* Format LocalDate to display format (MMM dd, yyyy).` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 26 | `* @param date LocalDate to format` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 27 | `* @return Formatted date string` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 28 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 29 | `public static String formatToDisplay(LocalDate date) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 30 | `return date.format(DISPLAY_FORMATTER);` | Returns the expression/value `date.format(DISPLAY_FORMATTER)` to the calling method, completing this thread's execution. |
| 31 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 32 | *Spacer* | Blank line used as a visual separator for code readability. |
| 33 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 34 | `* Parse string to LocalDate (assumes yyyy-MM-dd format).` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 35 | `* @param dateString Date string to parse` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 36 | `* @return Parsed LocalDate` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 37 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 38 | `public static LocalDate parseDate(String dateString) {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 39 | `return LocalDate.parse(dateString, DATE_FORMATTER);` | Returns the expression/value `LocalDate.parse(dateString, DATE_FORMATTER)` to the calling method, completing this thread's execution. |
| 40 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 41 | *Spacer* | Blank line used as a visual separator for code readability. |
| 42 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 43 | `* Get current month and year as YearMonth.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 44 | `* @return Current YearMonth` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 45 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 46 | `public static YearMonth getCurrentMonth() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 47 | `return YearMonth.now();` | Returns the expression/value `YearMonth.now()` to the calling method, completing this thread's execution. |
| 48 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 49 | *Spacer* | Blank line used as a visual separator for code readability. |
| 50 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 51 | `* Get current year.` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 52 | `* @return Current year` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 53 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 54 | `public static int getCurrentYear() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 55 | `return LocalDate.now().getYear();` | Returns the expression/value `LocalDate.now().getYear()` to the calling method, completing this thread's execution. |
| 56 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 57 | *Spacer* | Blank line used as a visual separator for code readability. |
| 58 | `/**` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 59 | `* Get current month (1-12).` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 60 | `* @return Current month` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 61 | `*/` | Block comment or Javadoc documentation providing metadata or clarifying code block intent. |
| 62 | `public static int getCurrentMonthValue() {` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 63 | `return LocalDate.now().getMonthValue();` | Returns the expression/value `LocalDate.now().getMonthValue()` to the calling method, completing this thread's execution. |
| 64 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |
| 65 | `}` | Executes procedural class logic, variable manipulation, or structural closing bracket matching. |


## 🛠️ Software Engineering & OOP Principles Applied

This component embodies several critical software design standards and OOP principles:

- **Encapsulation (Information Hiding)**: Fields are kept private, restricting read/write access via controlled accessor getter/setter patterns.
- **Single Responsibility Principle (SRP)**: The `DateUtil` layer focuses exclusively on one specific task, either representing domain state, executing schema statements, executing controllers, or coordinating computations.
