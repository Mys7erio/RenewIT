/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renewit.dao;

/**
 *
 * @author joyfd
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.renewit.pojo.Appointment;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AppointmentDAO {

    private static final Logger logger = Logger.getLogger(Appointment.class.getName());

    // Method to add a new appointment
    public boolean addAppointment(Appointment appointment)
            throws SQLException {
        String sql = "INSERT INTO appointments (uid, item_type, status, repair_cost, device_model, issue_description, preferred_date, preferred_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        logger.info("Starting to add appointment for user ID: " + appointment.getUid());

        Connection conn = ConnectionPool.getInstance().getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, appointment.getUid());
        stmt.setString(2, appointment.getItemType());
        stmt.setString(3, appointment.getStatus());
        stmt.setDouble(4, appointment.getRepairCost());
        stmt.setString(5, appointment.getDeviceModel());
        stmt.setString(6, appointment.getIssueDescription());
        stmt.setDate(7, appointment.getPreferredDate());
        stmt.setTime(8, appointment.getPreferredTime());

        // Log the SQL statement and parameters (for debugging)
        logger.warning("Executing SQL: " + sql + " with parameters: "
                + appointment.getUid() + ", "
                + appointment.getItemType() + ", "
                + appointment.getStatus() + ", "
                + appointment.getRepairCost() + ", "
                + appointment.getDeviceModel() + ", "
                + appointment.getIssueDescription() + ", "
                + appointment.getPreferredDate() + ", "
                + appointment.getPreferredTime());

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            logger.info("Successfully added appointment for user ID: " + appointment.getUid());
            return true;
        }
        return false;
    }

    // Method to get an appointment by its ID
    public List<Appointment> getAppointmentById(int aid) {
        List<Appointment> appointments = new ArrayList<>();

        String sql = "SELECT * FROM appointments WHERE aid = ?";
        try (Connection conn = ConnectionPool.getInstance().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, aid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                while (rs.next()) {
                    appointments.add(new Appointment(
                            //                        rs.getInt("aid"),
                            rs.getInt("uid"),
                            rs.getString("item_type"),
                            rs.getString("status"),
                            rs.getDouble("repair_cost"),
                            rs.getString("device_model"),
                            rs.getString("issue_description"),
                            rs.getString("preferred_date"), // Convert Timestamp to LocalDateTime
                            rs.getString("preferred_time") // Convert Time to LocalTime
                    )
                    );

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to get an appointment by user ID
    public List<Appointment> getAppointmentByUserId(int uid) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE uid = ?";
        try (Connection conn = ConnectionPool.getInstance().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, uid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                while (rs.next()) {
                    appointments.add(new Appointment(
                            rs.getInt("uid"),
                            rs.getString("item_type"),
                            rs.getString("status"),
                            rs.getDouble("repair_cost"),
                            rs.getString("device_model"),
                            rs.getString("issue_description"),
                            rs.getString("preferred_date"), // Convert Timestamp to LocalDateTime
                            rs.getString("preferred_time")
                    )
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // Method to get all appointments
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments";
        try (Connection conn = ConnectionPool.getInstance().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                appointments.add(new Appointment(
                        rs.getInt("uid"),
                        rs.getString("item_type"),
                        rs.getString("status"),
                        rs.getDouble("repair_cost"),
                        rs.getString("device_model"),
                        rs.getString("issue_description"),
                        rs.getString("preferred_date"), // Convert Timestamp to LocalDateTime
                        rs.getString("preferred_time")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    // Method to get all appointments by user ID
    public List<Appointment> getAllAppointmentsByUserId(int uid) {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE uid = ?";

        try (Connection conn = ConnectionPool.getInstance().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, uid);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    appointments.add(new Appointment(
                            rs.getInt("uid"),
                            rs.getString("item_type"),
                            rs.getString("status"),
                            rs.getDouble("repair_cost"),
                            rs.getString("device_model"),
                            rs.getString("issue_description"),
                            rs.getString("preferred_date"), // Convert Timestamp to LocalDateTime
                            rs.getString("preferred_time")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return appointments;
    }

    // Method to update an appointment
//    public void updateAppointment(Appointment appointment) {
//        String sql = "UPDATE appointments SET uid = ?, item_type = ?, status = ?, repair_cost = ?, device_model = ?, issue_description = ?, preferred_date = ?, preferred_time = ? WHERE aid = ?";
//        try (Connection conn = ConnectionPool.getInstance().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setInt(1, appointment.getUid());
//            stmt.setString(2, appointment.getItemType());
//            stmt.setString(3, appointment.getStatus());
//            stmt.setDouble(4, appointment.getRepairCost());
//            stmt.setString(5, appointment.getDeviceModel());
//            stmt.setString(6, appointment.getIssueDescription());
//            stmt.setTimestamp(7, Timestamp.valueOf(appointment.getPreferredDate()));
//            stmt.setTime(8, Time.valueOf(appointment.getPreferredTime()));
//            stmt.setInt(9, appointment.getAid());
//            stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    // Method to update appointment status
    public void updateAppointmentStatus(int aid, String status) {
        String sql = "UPDATE appointments SET status = ? WHERE aid = ?";
        try (Connection conn = ConnectionPool.getInstance().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setInt(2, aid);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete an appointment
    public void deleteAppointment(int aid) {
        String sql = "DELETE FROM appointments WHERE aid = ?";
        try (Connection conn = ConnectionPool.getInstance().getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, aid);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
