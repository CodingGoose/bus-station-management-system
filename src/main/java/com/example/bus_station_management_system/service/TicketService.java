package com.example.bus_station_management_system.service;
import com.example.bus_station_management_system.model.Ticket;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService extends BaseService<Ticket> {
    public TicketService(IRepository<Ticket> repository) {
        super(repository);
    }
}
