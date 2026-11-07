package com.example.bus_station_management_system.model;

public class DutyAssignment implements Identifiable<String> {
    public enum RoleType {
        PrimaryDriver,
        ReserveDriver
    }
    private String id;
    private String tripId;
    private String staffId;
    private RoleType role; // e.g., "Primary Driver/Reserve Driver"

    public DutyAssignment(){}
    public DutyAssignment(String id, String tripId, String staffId, RoleType role) {
        this.id = id;
        this.tripId = tripId;
        this.staffId = staffId;
        this.role = role;
    }

    @Override
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTripId() { return tripId; }
    public void setTripId(String tripId) { this.tripId = tripId; }

    public String getStaffId() { return staffId; }
    public void setStaffId(String staffId) { this.staffId = staffId; }

    public RoleType getRole() { return role; }
    public void setRole(RoleType role) { this.role = role; }
}
