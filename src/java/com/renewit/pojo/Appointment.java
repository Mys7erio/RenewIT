/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renewit.pojo;

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

    public Appointment(int aid, int uid, String itemType, String status, double repairCost) {
        this.aid = aid;
        this.uid = uid;
        this.itemType = itemType;
        this.status = status;
        this.repairCost = repairCost;
    }

    // Getters and setters
    public int getAid() { return aid; }
    public int getUid() { return uid; }
    public String getItemType() { return itemType; }
    public String getStatus() { return status; }
    public double getRepairCost() { return repairCost; }

    public void setAid(int aid) { this.aid = aid; }
    public void setUid(int uid) { this.uid = uid; }
    public void setItemType(String itemType) { this.itemType = itemType; }
    public void setStatus(String status) { this.status = status; }
    public void setRepairCost(double repairCost) { this.repairCost = repairCost; }
}
