package com.example.bus_station_management_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket implements Identifiable {
    @Id
    @Column(length = 36)
    private String id;
    @Column(name = "trip_id", length = 36, nullable = false)
    private String tripId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id", insertable = false, updatable = false)
    @JsonIgnore
    private BusTrip trip;
    @Column(name = "passenger_id", length = 36, nullable = false)
    private String passengerId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id", insertable = false, updatable = false)
    @JsonIgnore
    private Passenger passenger;
    @Column(name = "seat_number", nullable = false)
    private String seatNumber;
    @Column(nullable = false)
    private double price;

    public Ticket(){}
    public Ticket(String id, String tripId, String passengerId, String seatNumber, double price) {
        this.id = id;
        this.tripId = tripId;
        this.passengerId = passengerId;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    @Override
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTripId() { return tripId; }
    public void setTripId(String tripId) { this.tripId = tripId; }

    public String getPassengerId() { return passengerId; }
    public void setPassengerId(String passengerId) { this.passengerId = passengerId; }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
