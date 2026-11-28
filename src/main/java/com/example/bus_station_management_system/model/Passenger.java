package com.example.bus_station_management_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "passenger")
public class Passenger implements Identifiable {
    @Id
    @Column(length = 36)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String currency;
    @Transient
    @JsonIgnore
    private List<Ticket> tickets = new ArrayList<>();

    public Passenger(){}
    public Passenger(String id, String name, String currency) {
        this.id = id;
        this.name = name;
        this.currency = currency;
    }

    @Override
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public List<Ticket> getTickets() { return tickets; }
    public void setTickets(List<Ticket> tickets) { this.tickets = tickets; }
}
