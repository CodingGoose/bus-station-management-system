package com.example.bus_station_management_system.service;

import com.example.bus_station_management_system.exception.ValidationException;
import com.example.bus_station_management_system.model.Bus;
import com.example.bus_station_management_system.model.BusTrip;
import com.example.bus_station_management_system.model.Ticket;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService extends BaseService<Ticket> {

    private final BusTripService busTripService;
    private final PassengerService passengerService;
    private final BusService busService;

    public TicketService(IRepository<Ticket> repository, BusTripService busTripService,
                         PassengerService passengerService, BusService busService) {
        super(repository);
        this.busTripService = busTripService;
        this.passengerService = passengerService;
        this.busService = busService;
    }

    @Override
    protected void validateForCreate(Ticket ticket) {
        validateCommon(ticket);
    }

    @Override
    protected void validateForUpdate(Ticket ticket) {
        Ticket existing = findById(ticket.getId());
        if (existing.getPassengerId() != null && !existing.getPassengerId().equals(ticket.getPassengerId())) {
            throw new ValidationException("passengerId", "Passenger cannot be changed once a ticket is created.");
        }
        validateCommon(ticket);
    }

    private void validateCommon(Ticket ticket) {
        if (isBlank(ticket.getTripId()) || !busTripService.existsById(ticket.getTripId())) {
            throw new ValidationException("tripId", "Selected trip does not exist.");
        }
        if (isBlank(ticket.getPassengerId()) || !passengerService.existsById(ticket.getPassengerId())) {
            throw new ValidationException("passengerId", "Selected passenger does not exist.");
        }
        requireNonBlank(ticket.getSeatNumber(), "seatNumber", "Seat number must not be blank.");
        if (ticket.getPrice() < 0) {
            throw new ValidationException("price", "Price must be 0 or greater.");
        }

        BusTrip trip = busTripService.findById(ticket.getTripId());
        if (trip.getStatus() == BusTrip.TripStatus.Completed) {
            throw new ValidationException("tripId", "Cannot issue or modify a ticket for a completed trip.");
        }

        String normalizedSeat = ticket.getSeatNumber().trim();
        boolean seatTaken = findAll().stream()
                .anyMatch(existing -> !existing.getId().equals(ticket.getId())
                        && ticket.getTripId().equals(existing.getTripId())
                        && existing.getSeatNumber() != null
                        && existing.getSeatNumber().trim().equalsIgnoreCase(normalizedSeat));
        if (seatTaken) {
            throw new ValidationException("seatNumber", "Seat " + normalizedSeat + " is already taken on this trip.");
        }

        long soldForTrip = findAll().stream()
                .filter(existing -> !existing.getId().equals(ticket.getId())
                        && ticket.getTripId().equals(existing.getTripId()))
                .count();
        Bus bus = busService.findById(trip.getBusId());
        if (soldForTrip >= bus.getCapacity()) {
            throw new ValidationException("tripId", "No seats available: bus capacity (" + bus.getCapacity() + ") has been reached.");
        }
    }

    public java.util.List<Ticket> findByTripId(String tripId) {
        return findAll().stream()
                .filter(ticket -> tripId.equals(ticket.getTripId()))
                .toList();
    }

    public java.util.List<Ticket> findByPassengerId(String passengerId) {
        return findAll().stream()
                .filter(ticket -> passengerId.equals(ticket.getPassengerId()))
                .toList();
    }
}
