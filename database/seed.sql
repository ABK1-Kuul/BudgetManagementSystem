USE smart_budget;

-- =========================
-- RESET TABLES (SAFE TESTING)
-- =========================
SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE expenses;
TRUNCATE TABLE incomes;
TRUNCATE TABLE budgets;
TRUNCATE TABLE categories;
TRUNCATE TABLE users;

SET FOREIGN_KEY_CHECKS = 1;

-- =========================
-- USERS
-- =========================
INSERT INTO users (username, email, password)
VALUES 
('admin', 'admin@gmail.com', '1234'),
('john', 'john@gmail.com', '1234');

-- =========================
-- CATEGORIES
-- =========================
INSERT INTO categories (category_name)
VALUES 
('Food'),
('Transport'),
('Rent'),
('Education'),
('Entertainment');

-- =========================
-- INCOMES
-- =========================
INSERT INTO incomes (user_id, amount, description, income_date)
VALUES 
(1, 5000, 'Monthly Salary', '2026-06-01'),
(2, 3000, 'Freelance Work', '2026-06-02');

-- =========================
-- EXPENSES
-- =========================
INSERT INTO expenses (user_id, category_id, amount, description, expense_date)
VALUES 
(1, 1, 200, 'Lunch', '2026-06-02'),
(1, 2, 50, 'Bus fare', '2026-06-03'),
(2, 3, 1000, 'Rent payment', '2026-06-05');

-- =========================
-- BUDGETS
-- =========================
INSERT INTO budgets (user_id, month, year, amount)
VALUES 
(1, 6, 2026, 1000),
(2, 6, 2026, 1500);