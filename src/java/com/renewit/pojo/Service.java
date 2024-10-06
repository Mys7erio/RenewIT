/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.renewit.pojo;

/**
 *
 * @author joyfd
 */
public class Service {
    private int id;                // Unique identifier for the service
    private String serviceName;    // Name of the service (e.g., "Phone Repair", "Laptop Repair")
    private String description;     // Description of the service
    private double price;           // Price of the service

    // Constructor
    public Service(int id, String serviceName, String description, double price) {
        this.id = id;
        this.serviceName = serviceName;
        this.description = description;
        this.price = price;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
