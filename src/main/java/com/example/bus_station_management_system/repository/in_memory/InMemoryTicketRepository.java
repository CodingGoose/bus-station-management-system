package com.example.bus_station_management_system.repository.in_memory;

import com.example.bus_station_management_system.model.Ticket;
import com.example.bus_station_management_system.repository.TicketRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryTicketRepository extends InMemoryRepository<Ticket, String> implements TicketRepository {
    // Inherits all save, find, and delete methods automatically
}