package com.example.bus_station_management_system.service;

import com.example.bus_station_management_system.exception.ValidationException;
import com.example.bus_station_management_system.model.Passenger;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class PassengerService extends BaseService<Passenger> {

    private final TicketService ticketService;

    public PassengerService(IRepository<Passenger> repository, @Lazy TicketService ticketService) {
        super(repository);
        this.ticketService = ticketService;
    }

    @Override
    protected void validateForCreate(Passenger passenger) {
        requireNonBlank(passenger.getName(), "name", "Passenger name must not be blank.");
        requireNonBlank(passenger.getCurrency(), "currency", "Currency must not be blank.");
    }

    @Override
    protected void validateForDelete(String id) {
        boolean hasTickets = ticketService.findAll().stream()
                .anyMatch(ticket -> id.equals(ticket.getPassengerId()));
        if (hasTickets) {
            throw new ValidationException("Cannot delete passenger because they have existing tickets.");
        }
    }

    @Override
    protected String label(Passenger passenger) {
        return passenger.getName();
    }
}
