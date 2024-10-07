/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renewit.pojo;
import java.sql.Timestamp;
import java.sql.Date;
/**
 *
 * @author joyfd
 */

public class Appointment {
    private int aid;
    private int uid;
    private String itemType;
    private String status;
    private double repairCost;
    private String deviceModel;
    private String issueDescription;
    private String preferredDate;
    private String preferredTime;

    
    public Appointment() {
         this.status="APPOINTMENT_CONFIRMED";
     }
    
    // Constructor for basic fields used in getAll methods
    public Appointment(int aid, int uid, String itemType, String status, double repairCost) {
        this.aid = aid;
        this.uid = uid;
        this.itemType = itemType;
        this.status = status;
        this.repairCost = repairCost;
    }

    // Full constructor for adding new appointments
    public Appointment(int uid, String itemType, String status, double repairCost, String deviceModel, String issueDescription, String preferredDate, String preferredTime) {
        this.uid = uid;
        this.itemType = itemType;
        this.status = status;
        this.repairCost = repairCost;
        this.deviceModel = deviceModel;
        this.issueDescription = issueDescription;
        this.preferredDate = preferredDate;
        this.preferredTime = preferredTime;
    }

    // Getters and Setters for each field
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(double repairCost) {
        this.repairCost = repairCost;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getPreferredDate() {
        return preferredDate;
    }

    public void setPreferredDate(String preferredDate) {
        this.preferredDate = preferredDate;
    }

    public String getPreferredTime() {
        return preferredTime;
    }

    public void setPreferredTime(String preferredTime) {
        this.preferredTime = preferredTime;
    }
}