package com.example.bus_station_management_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BusTrip implements Identifiable {

    public enum TripStatus {
        Planned,
        Active,
        Completed
    }

    private String id;
    private String routeId;
    private String busId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startTime;
    @JsonIgnore
    private List<Ticket> tickets = new ArrayList<>();
    @JsonIgnore
    private List<DutyAssignment> assignments = new ArrayList<>();
    private TripStatus status;

    public BusTrip() {}

    public BusTrip(String id, String routeId, String busId, LocalDateTime startTime, TripStatus status) {
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

    public List<Ticket> getTickets() { return tickets; }
    public void setTickets(List<Ticket> tickets) { this.tickets = tickets; }

    public List<DutyAssignment> getAssignments() { return assignments; }
    public void setAssignments(List<DutyAssignment> assignments) { this.assignments = assignments; }

    public TripStatus getStatus() { return status; }
    public void setStatus(TripStatus status) { this.status = status; }
}
