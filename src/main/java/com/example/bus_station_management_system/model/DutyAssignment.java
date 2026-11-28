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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "duty_assignment")
public class DutyAssignment implements Identifiable {
    public enum RoleType {
        PrimaryDriver,
        ReserveDriver
    }
    @Id
    @Column(length = 36)
    private String id;
    @NotBlank(message = "Selected trip does not exist.")
    @Column(name = "trip_id", length = 36, nullable = false)
    private String tripId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id", insertable = false, updatable = false)
    @JsonIgnore
    private BusTrip trip;
    @NotBlank(message = "Selected staff member does not exist.")
    @Column(name = "staff_id", length = 36, nullable = false)
    private String staffId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", insertable = false, updatable = false)
    @JsonIgnore
    private Staff staff;
    @NotNull(message = "Role must be selected.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
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
