/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renewit.dao;

/**
 *
 * @author joyfd
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
    private static ConnectionPool instance;
    private static final String URL = "jdbc:postgres://ep-soft-base-a1u5sikv.ap-southeast-1.aws.neon.tech:5432/verceldb?sslmode=require"; // Update with your database URL
    private static final String USER = "default"; // Update with your database username
    private static final String PASSWORD = "ROwIpNm2CsG1"; // Update with your database password
    private Connection connection;

    // Private constructor to prevent instantiation
    private ConnectionPool() {
        try {
            Class.forName("org.postgresql.Driver"); // Load the PostgreSQL JDBC driver
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Failed to create database connection: " + e.getMessage());
        }
    }

    // Public method to provide access to the single instance of ConnectionPool
    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    // Method to get the database connection
    public Connection getConnection() {
        return connection;
    }

    // Optional: Method to close the connection
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Failed to close the database connection: " + e.getMessage());
            }
        }
    }
}
