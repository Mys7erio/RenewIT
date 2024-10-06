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


public class AppointmentDAO {

    // Method to add a new appointment
    public void addAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointments (uid, item_type, status, repair_cost) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, appointment.getUid());
            stmt.setString(2, appointment.getItemType());
            stmt.setString(3, appointment.getStatus());
            stmt.setDouble(4, appointment.getRepairCost());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get an appointment by its ID
    public Appointment getAppointmentById(int aid) {
        String sql = "SELECT * FROM appointments WHERE aid = ?";
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, aid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Appointment(rs.getInt("aid"), rs.getInt("uid"), rs.getString("item_type"), 
                                       rs.getString("status"), rs.getDouble("repair_cost"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
        // Method to get an appointment by user ID
    public Appointment getAppointmentByUserId(int uid) {
        String sql = "SELECT * FROM appointments WHERE uid = ?";
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, uid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Appointment(rs.getInt("aid"), rs.getInt("uid"), rs.getString("item_type"), 
                                       rs.getString("status"), rs.getDouble("repair_cost"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to get all appointments
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments";
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                appointments.add(new Appointment(rs.getInt("aid"), rs.getInt("uid"), rs.getString("item_type"),
                                                 rs.getString("status"), rs.getDouble("repair_cost")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }

    // Method to update an appointment
    public void updateAppointment(Appointment appointment) {
        String sql = "UPDATE appointments SET uid = ?, item_type = ?, status = ?, repair_cost = ? WHERE aid = ?";
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, appointment.getUid());
            stmt.setString(2, appointment.getItemType());
            stmt.setString(3, appointment.getStatus());
            stmt.setDouble(4, appointment.getRepairCost());
            stmt.setInt(5, appointment.getAid());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Method to update appointment status
    public void updateAppointmentStatus(int aid, String status) {
    String sql = "UPDATE appointments SET status = ? WHERE aid = ?";
    try (Connection conn = ConnectionPool.getInstance().getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
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
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, aid);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

