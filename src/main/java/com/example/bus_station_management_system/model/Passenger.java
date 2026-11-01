package com.example.bus_station_management_system.model;

import java.util.ArrayList;
import java.util.List;

public class Passenger implements Identifiable<String> {
    private String id;
    private String name;
    private String currency;
    private List<Ticket> tickets;

    public Passenger(String id, String name, String currency) {
        this.id = id;
        this.name = name;
        this.currency = currency;
        this.tickets = new ArrayList<>();
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
