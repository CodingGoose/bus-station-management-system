package com.example.bus_station_management_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "bus")
public class Bus implements Identifiable {

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

    @Id
    @Column(length = 36)
    private String id;
    @NotBlank(message = "Registration number must not be blank.")
    @Column(name = "registration_number", nullable = false)
    private String registrationNumber;
    @Positive(message = "Capacity must be greater than 0.")
    @Column(nullable = false)
    private int capacity;
    @NotNull(message = "Status must be selected.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BusStatus status;
    @Column(name = "has_ac", nullable = false)
    private boolean hasAC;
    @NotNull(message = "Fuel type must be selected.")
    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type", nullable = false)
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
