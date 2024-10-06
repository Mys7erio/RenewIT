/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renewit.pojo;

/**
 *
 * @author joyfd
 */
public class Submission {
    private int sid;
    private int uid;
    private String itemType;
    private String modelNo;
    private String issueDesc;
    private double repairCost;
    private String status;

    public Submission(int sid, int uid, String itemType, String modelNo, String issueDesc, double repairCost, String status) {
        this.sid = sid;
        this.uid = uid;
        this.itemType = itemType;
        this.modelNo = modelNo;
        this.issueDesc = issueDesc;
        this.repairCost = repairCost;
        this.status = status;
    }

    // Getters and setters
    public int getSid() { return sid; }
    public int getUid() { return uid; }
    public String getItemType() { return itemType; }
    public String getModelNo() { return modelNo; }
    public String getIssueDesc() { return issueDesc; }
    public double getRepairCost() { return repairCost; }
    public String getStatus() { return status; }

    public void setSid(int sid) { this.sid = sid; }
    public void setUid(int uid) { this.uid = uid; }
    public void setItemType(String itemType) { this.itemType = itemType; }
    public void setModelNo(String modelNo) { this.modelNo = modelNo; }
    public void setIssueDesc(String issueDesc) { this.issueDesc = issueDesc; }
    public void setRepairCost(double repairCost) { this.repairCost = repairCost; }
    public void setStatus(String status) { this.status = status; }
}
