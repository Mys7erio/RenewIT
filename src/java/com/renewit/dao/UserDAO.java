/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renewit.dao;


/**
 *
 * @author joyfd
 */
import com.renewit.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // Method to create a new user
    public void createUser(String name, String password, String email, String address, String phone, String urole) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            String query = "INSERT INTO users (name, password, email, address, phone, urole) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, name);
                pstmt.setString(2, password); 
                pstmt.setString(3, email);
                pstmt.setString(4, address);
                pstmt.setString(5, phone);
                pstmt.setString(6, urole);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error creating user: " + e.getMessage());
        } 
    }

    // Method to find a user by name
    public User findUserByName(String name) {
        Connection connection = null;
        User user = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            String query = "SELECT * FROM users WHERE name = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, name);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("urole"),
                        rs.getTimestamp("created_at")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error finding user: " + e.getMessage());
        } 
        return user;
    }
    
    // Method to find a user by ID
public User findUserById(Connection connection, int id) {
    User user = null;
    try {
        String query = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getString("urole"),
                    rs.getTimestamp("created_at")
                );
            }
        }
    } catch (SQLException e) {
        System.err.println("Error finding user: " + e.getMessage());
    }
    return user;
}

    // Method to retrieve all users
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            String query = "SELECT * FROM users";
            try (PreparedStatement pstmt = connection.prepareStatement(query);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("phone"),
                        rs.getString("urole"),
                        rs.getTimestamp("created_at")
                    );
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving users: " + e.getMessage());
        } 
        return users;
    }

    // Method to update user information
    public void updateUser(int id, String name, String email, String address, String phone, String urole) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            String query = "UPDATE users SET name = ?, email = ?, address = ?, phone = ?, urole = ? WHERE id = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, address);
                pstmt.setString(4, phone);
                pstmt.setString(5, urole);
                pstmt.setInt(6, id);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error updating user: " + e.getMessage());
        } 
    }

    // Method to delete a user by ID
    public void deleteUser(int id) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            String query = "DELETE FROM users WHERE id = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error deleting user: " + e.getMessage());
        } 
    }
}
