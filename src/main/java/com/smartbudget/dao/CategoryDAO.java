 package com.smartbudget.dao;

import com.smartbudget.database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    // ADD CATEGORY
    public boolean addCategory(String name) {

        String sql = "INSERT INTO categories(category_name) VALUES(?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // GET ALL CATEGORIES
    public List<String> getAllCategories() {

        List<String> list = new ArrayList<>();

        String sql = "SELECT category_name FROM categories";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(rs.getString("category_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
}