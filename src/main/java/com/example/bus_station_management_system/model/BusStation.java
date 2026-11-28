package com.example.bus_station_management_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bus_station")
public class BusStation implements Identifiable {
    @Id
    @Column(length = 36)
    private String id;
    @NotBlank(message = "Station name must not be blank.")
    @Column(nullable = false)
    private String name;
    @NotBlank(message = "City must not be blank.")
    @Column(nullable = false)
    private String city;
    @Transient
    @JsonIgnore
    private List<BusTrip> trips = new ArrayList<>();

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

    public List<BusTrip> getTrips() { return trips; }
    public void setTrips(List<BusTrip> trips) { this.trips = trips; }
}