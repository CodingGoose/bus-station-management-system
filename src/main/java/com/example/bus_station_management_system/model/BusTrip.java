package com.example.bus_station_management_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bus_trip")
public class BusTrip implements Identifiable {

    public enum TripStatus {
        Planned,
        Active,
        Completed
    }

    @Id
    @Column(length = 36)
    private String id;
    @NotBlank(message = "Selected route does not exist.")
    @Column(name = "route_id", length = 36, nullable = false)
    private String routeId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", insertable = false, updatable = false)
    @JsonIgnore
    private Route route;
    @NotBlank(message = "Selected bus does not exist.")
    @Column(name = "bus_id", length = 36, nullable = false)
    private String busId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_id", insertable = false, updatable = false)
    @JsonIgnore
    private Bus bus;
    @NotNull(message = "Start time must not be empty.")
    @Column(name = "start_time", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime startTime;
    @OneToMany(mappedBy = "trip")
    @JsonIgnore
    private List<Ticket> tickets = new ArrayList<>();
    @OneToMany(mappedBy = "trip")
    @JsonIgnore
    private List<DutyAssignment> assignments = new ArrayList<>();
    @NotNull(message = "Trip status must be selected.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
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
