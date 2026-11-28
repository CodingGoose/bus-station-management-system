package com.example.bus_station_management_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "route")
public class Route implements Identifiable {
    @Id
    @Column(length = 36)
    private String id;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "origin_id", nullable = false)
    private BusStation origin;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "destination_id", nullable = false)
    private BusStation destination;
    @Column(nullable = false)
    private double distance;
    @Transient
    @JsonIgnore
    private List<BusTrip> trips = new ArrayList<>();

    public Route() {}

    public Route(String id, BusStation origin, BusStation destination, double distance) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }

    @Override
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public BusStation getOrigin() { return origin; }
    public void setOrigin(BusStation origin) { this.origin = origin; }

    public BusStation getDestination() { return destination; }
    public void setDestination(BusStation destination) { this.destination = destination; }

    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }

    public List<BusTrip> getTrips() { return trips; }
    public void setTrips(List<BusTrip> trips) { this.trips = trips; }
}
