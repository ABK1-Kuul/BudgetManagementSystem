package com.smartbudget.dao;

import com.smartbudget.database.DatabaseConnection;
import com.smartbudget.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public boolean createUser(User user) {

        String sql =
                "INSERT INTO users(username,email,password) VALUES(?,?,?)";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1,
                    user.getUsername());

            statement.setString(2,
                    user.getEmail());

            statement.setString(3,
                    user.getPassword());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    public User findByUsername(String username) {

        String sql =
                "SELECT * FROM users WHERE username = ?";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setString(1, username);

            ResultSet rs =
                    statement.executeQuery();

            if (rs.next()) {

                User user = new User();

                user.setUserId(
                        rs.getInt("user_id"));

                user.setUsername(
                        rs.getString("username"));

                user.setEmail(
                        rs.getString("email"));

                user.setPassword(
                        rs.getString("password"));

                return user;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }

    public User findById(int id) {

        String sql =
                "SELECT * FROM users WHERE user_id = ?";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            statement.setInt(1, id);

            ResultSet rs =
                    statement.executeQuery();

            if (rs.next()) {

                User user = new User();

                user.setUserId(
                        rs.getInt("user_id"));

                user.setUsername(
                        rs.getString("username"));

                user.setEmail(
                        rs.getString("email"));

                user.setPassword(
                        rs.getString("password"));

                return user;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return null;
    }
}