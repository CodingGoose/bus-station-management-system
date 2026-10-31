package com.example.bus_station_management_system.model;

import java.util.ArrayList;
import java.util.List;

public class BusStation implements Identifiable<String> {
    private String id;
    private String name;
    private String city;
    private List<String> trips = new ArrayList<>();

    public BusStation() {}

    public BusStation(String id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Override
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public List<String> getTrips() { return trips; }
    public void setTrips(List<String> trips) { this.trips = trips; }
}