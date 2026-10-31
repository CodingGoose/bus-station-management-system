package com.example.bus_station_management_system.model;
import java.util.ArrayList;
import java.util.List;

public class Route implements Identifiable<String> {
    private String id;
    private BusStation origin;
    private BusStation destination;
    private double distance;
    private List<String> trips = new ArrayList<>();

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

    public List<String> getTrips() { return trips; }
    public void setTrips(List<String> trips) { this.trips = trips; }
}
