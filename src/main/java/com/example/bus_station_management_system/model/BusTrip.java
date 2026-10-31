package com.example.bus_station_management_system.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BusTrip implements Identifiable<String> {
    private String id;
    private String routeId;
    private String busId;
    private LocalDateTime startTime;
    private List<String> tickets = new ArrayList<>();
    private List<String> assignments = new ArrayList<>();
    private String status; // Planned / Active / Completed

    public BusTrip() {}

    public BusTrip(String id, String routeId, String busId, LocalDateTime startTime, String status) {
        this.id = id;
        this.routeId = routeId;
        this.busId = busId;
        this.startTime = startTime;
        this.status = status;
    }

    @Override
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getRouteId() { return routeId; }
    public void setRouteId(String routeId) { this.routeId = routeId; }

    public String getBusId() { return busId; }
    public void setBusId(String busId) { this.busId = busId; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public List<String> getTickets() { return tickets; }
    public void setTickets(List<String> tickets) { this.tickets = tickets; }

    public List<String> getAssignments() { return assignments; }
    public void setAssignments(List<String> assignments) { this.assignments = assignments; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
