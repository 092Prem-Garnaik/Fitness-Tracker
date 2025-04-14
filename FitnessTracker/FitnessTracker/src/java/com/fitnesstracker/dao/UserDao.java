package com.fitnesstracker.dao;

import com.fitnesstracker.model.User;
import java.sql.*;

public class UserDao {

    private static final String URL = "jdbc:mysql://localhost:3306/fitness_db";
    private static final String USER = "root";
    private static final String PASSWORD = "anjusus@#234";

    public boolean registerUser(User user) {
        String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getUsername().trim());
            stmt.setString(2, user.getPassword().trim());
            stmt.setString(3, user.getEmail().trim());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validateUser(String username, String password) {
        String query = "SELECT * FROM users WHERE BINARY username = ? AND BINARY password = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Trim input to avoid extra spaces
            username = username.trim();
            password = password.trim();

            // Debugging statements
            System.out.println("Login Attempt: Username - " + username + ", Password - " + password);
            
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("User found! Welcome, " + username);
                return true;
            } else {
                System.out.println("Invalid credentials or user not found.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
