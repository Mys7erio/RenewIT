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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.renewit.pojo.Service;

public class ServiceDAO {

    // Method to create a new service
    public void createService(String serviceName, String description, double price) {
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            String query = "INSERT INTO services (service_name, description, price) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, serviceName);
                pstmt.setString(2, description);
                pstmt.setDouble(3, price);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error creating service: " + e.getMessage());
        }
    }

    // Method to retrieve all services
    public List<Service> getAllServices() {
        List<Service> services = new ArrayList<>();
        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            String query = "SELECT * FROM services";
            try (PreparedStatement pstmt = connection.prepareStatement(query);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Service service = new Service(
                        rs.getInt("id"),
                        rs.getString("service_name"),
                        rs.getString("description"),
                        rs.getDouble("price")
                    );
                    services.add(service);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving services: " + e.getMessage());
        }
        return services;
    }
}
