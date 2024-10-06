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
import com.renewit.pojo.Submission;

public class SubmissionDAO {

    // Method to add a new submission
    public void addSubmission(Submission submission) {
        String sql = "INSERT INTO submissions (uid, item_type, model_no, issue_desc, repair_cost, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, submission.getUid());
            stmt.setString(2, submission.getItemType());
            stmt.setString(3, submission.getModelNo());
            stmt.setString(4, submission.getIssueDesc());
            stmt.setDouble(5, submission.getRepairCost());
            stmt.setString(6, submission.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get a submission by its ID
    public Submission getSubmissionById(int sid) {
        String sql = "SELECT * FROM submissions WHERE sid = ?";
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, sid);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Submission(rs.getInt("sid"), rs.getInt("uid"), rs.getString("item_type"), 
                                      rs.getString("model_no"), rs.getString("issue_desc"), 
                                      rs.getDouble("repair_cost"), rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to get all submissions
    public List<Submission> getAllSubmissions() {
        List<Submission> submissions = new ArrayList<>();
        String sql = "SELECT * FROM submissions";
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                submissions.add(new Submission(rs.getInt("sid"), rs.getInt("uid"), rs.getString("item_type"),
                                                rs.getString("model_no"), rs.getString("issue_desc"),
                                                rs.getDouble("repair_cost"), rs.getString("status")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return submissions;
    }

    // Method to update a submission
    public void updateSubmission(Submission submission) {
        String sql = "UPDATE submissions SET uid = ?, item_type = ?, model_no = ?, issue_desc = ?, repair_cost = ?, status = ? WHERE sid = ?";
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, submission.getUid());
            stmt.setString(2, submission.getItemType());
            stmt.setString(3, submission.getModelNo());
            stmt.setString(4, submission.getIssueDesc());
            stmt.setDouble(5, submission.getRepairCost());
            stmt.setString(6, submission.getStatus());
            stmt.setInt(7, submission.getSid());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a submission
    public void deleteSubmission(int sid) {
        String sql = "DELETE FROM submissions WHERE sid = ?";
        try (Connection conn = ConnectionPool.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, sid);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

