package com.example.bus_station_management_system.model;

public class Bus implements Identifiable<String> {
    private String id;
    private String registrationNumber;
    private int capacity;
    private String status; // Active / Down

    public Bus() {}

    public Bus(String id, String registrationNumber, int capacity, String status) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.capacity = capacity;
        this.status = status;
    }

    @Override
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
