package com.smartbudget.utils;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 * Utility for date formatting and manipulation.
 */
public class DateUtil {
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DISPLAY_FORMATTER = DateTimeFormatter.ofPattern("MMM dd, yyyy");
    
    /**
     * Format LocalDate to standard database format (yyyy-MM-dd).
     * @param date LocalDate to format
     * @return Formatted date string
     */
    public static String formatToDatabase(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }
    
    /**
     * Format LocalDate to display format (MMM dd, yyyy).
     * @param date LocalDate to format
     * @return Formatted date string
     */
    public static String formatToDisplay(LocalDate date) {
        return date.format(DISPLAY_FORMATTER);
    }
    
    /**
     * Parse string to LocalDate (assumes yyyy-MM-dd format).
     * @param dateString Date string to parse
     * @return Parsed LocalDate
     */
    public static LocalDate parseDate(String dateString) {
        return LocalDate.parse(dateString, DATE_FORMATTER);
    }
    
    /**
     * Get current month and year as YearMonth.
     * @return Current YearMonth
     */
    public static YearMonth getCurrentMonth() {
        return YearMonth.now();
    }
    
    /**
     * Get current year.
     * @return Current year
     */
    public static int getCurrentYear() {
        return LocalDate.now().getYear();
    }
    
    /**
     * Get current month (1-12).
     * @return Current month
     */
    public static int getCurrentMonthValue() {
        return LocalDate.now().getMonthValue();
    }
}
