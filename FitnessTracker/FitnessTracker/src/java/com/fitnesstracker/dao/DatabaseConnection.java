package com.fitnesstracker.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {

    // Database URL, Username, and Password
    private static final String URL = "jdbc:mysql://localhost:3306/fitness_db";
    private static final String USER = "root";
    private static final String PASSWORD = "anjusus@#234";

    // Method to establish a connection
    public static Connection getConnection() throws SQLException {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Database connected successfully!");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found!");
            e.printStackTrace();
            throw new SQLException("Unable to load driver");
        } catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
            throw e;
        }
    }
}