package com.example.bus_station_management_system.model;

public class Bus implements Identifiable<String> {

    public enum FuelType {
        Gasoline,
        Diesel,
        Electric,
        Hybrid
    }

    public enum BusStatus {
        Active,
        Down
    }

    private String id;
    private String registrationNumber;
    private int capacity;
    private BusStatus status;
    private boolean hasAC;
    private FuelType fuelType;

    public Bus(){
    }
    public Bus(String id, String registrationNumber, int capacity, BusStatus status) {
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

    public BusStatus getStatus() { return status; }
    public void setStatus(BusStatus status) { this.status = status; }

    public boolean getHasAC() { return hasAC; }
    public void setHasAC(boolean hasAC) { this.hasAC = hasAC; }
    public FuelType getFuelType() { return fuelType; }
    public void setFuelType(FuelType fuelType) { this.fuelType = fuelType; }
}
