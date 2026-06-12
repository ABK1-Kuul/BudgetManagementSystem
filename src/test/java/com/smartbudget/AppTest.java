// package com.smartbudget;

// // Add JUnit tests here when ready
// public class AppTest {
// }
package com.smartbudget;

import com.smartbudget.dao.UserDAO;
import com.smartbudget.models.User;

public class AppTest {

    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();

        // TEST INSERT
        User user = new User();
        user.setUsername("app_test");
        user.setEmail("app@gmail.com");
        user.setPassword("1234");

        boolean created = userDAO.createUser(user);
        System.out.println("User created: " + created);

        // TEST SELECT
        User found = userDAO.findByUsername("app_test");

        if (found != null) {
            System.out.println("User found:");
            System.out.println(found.getUserId());
            System.out.println(found.getUsername());
            System.out.println(found.getEmail());
        } else {
            System.out.println("User not found");
        }
    }
}