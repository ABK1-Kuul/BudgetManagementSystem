package com.smartbudget;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import com.smartbudget.exceptions.ValidationException;
import com.smartbudget.models.Category;
import com.smartbudget.models.Expense;
import com.smartbudget.models.Income;
import com.smartbudget.models.Transaction;
import com.smartbudget.models.User;

/**
 * Educational unit test suite designed for presentation defenses.
 * Explicitly tests and demonstrates fundamental Object-Oriented Programming (OOP) concepts.
 */
public class AppTest {

    /**
     * Test Case 1: Demonstrates and verifies INHERITANCE and POLYMORPHISM.
     * Ensures subclasses 'Expense' and 'Income' inherit from 'Transaction' and
     * respond polymorphically to 'getSignedAmount()'.
     */
    @Test
    public void testPolymorphismAndInheritance() throws ValidationException {
        User user = new User();
        user.setUserId(1);
        user.setUsername("testUser");
        user.setEmail("test@test.com");
        user.setPassword("password");
        Category category = new Category(1, "Rent");
        LocalDate date = LocalDate.now();

        // Instantiate subclasses as parent 'Transaction' reference (Upcasting)
        Transaction expense = new Expense(101, user, category, 1500.00, "Monthly Rent Payment", date);
        Transaction income = new Income(201, user, 2500.00, "Bi-weekly Salary", date);

        // 1. Verify Inheritance: Subclasses can be cast back and queried for common attributes
        assertEquals(1500.00, expense.getAmount(), "Inherited getter should fetch the configured amount.");
        assertEquals(2500.00, income.getAmount(), "Inherited getter should fetch the configured amount.");
        
        assertEquals("Monthly Rent Payment", expense.getDescription(), "Inherited field should be successfully populated.");
        assertEquals("Bi-weekly Salary", income.getDescription(), "Inherited field should be successfully populated.");

        // 2. Verify Polymorphism: Same method call 'getSignedAmount()' triggers different subclass implementations
        assertEquals(-1500.00, expense.getSignedAmount(), "Expense polymorphic return should be negative.");
        assertEquals(2500.00, income.getSignedAmount(), "Income polymorphic return should be positive.");

        // 3. Verify Abstraction: Abstract method return behaves according to subclass definition
        assertEquals("Expense", expense.getTransactionType(), "Abstraction contract implementation check.");
        assertEquals("Income", income.getTransactionType(), "Abstraction contract implementation check.");
    }

    /**
     * Test Case 2: Demonstrates and verifies ENCAPSULATION and defensive data guarding.
     * Verifies that the internal state is guarded securely by checking setter bounds,
     * and throwing appropriate custom exceptions upon violation.
     */
    @Test
    public void testEncapsulationAndValidation() {
        Expense expense = new Expense();

        // 1. Verify basic Encapsulation (Accessing attributes securely via standard getters/setters)
        try {
            expense.setAmount(100.50);
            assertEquals(100.50, expense.getAmount(), "Encapsulated field should be correctly set and fetched.");
        } catch (ValidationException e) {
            fail("Valid positive values should not trigger validation failures.");
        }

        // 2. Verify Data Guarding constraints: negative numbers must be blocked with custom check exceptions
        Exception exception1 = assertThrows(ValidationException.class, () -> {
            expense.setAmount(-25.00); // Should throw ValidationException
        }, "Setting a negative amount must trigger a ValidationException.");

        assertTrue(exception1.getMessage().contains("strictly positive"), "Validation exception message must describe the rule constraint.");

        // 3. Verify Data Guarding constraints: zero amount must be blocked
        Exception exception2 = assertThrows(ValidationException.class, () -> {
            expense.setAmount(0.00); // Should throw ValidationException
        }, "Setting a zero amount must trigger a ValidationException.");

        assertTrue(exception2.getMessage().contains("strictly positive"), "Validation exception message must describe the rule constraint.");
    }
}
