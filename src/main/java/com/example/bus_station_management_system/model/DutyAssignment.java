package com.example.bus_station_management_system.model;

public class DutyAssignment implements Identifiable<String> {
    private String id;
    private String tripId;
    private String staffId;
    private String role; // e.g., "Primary Driver/Reserve Driver"

    public DutyAssignment(String id, String tripId, String staffId, String role) {
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

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
