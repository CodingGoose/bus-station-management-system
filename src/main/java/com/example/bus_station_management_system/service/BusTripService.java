package com.example.bus_station_management_system.service;

import com.example.bus_station_management_system.exception.ValidationException;
import com.example.bus_station_management_system.model.Bus;
import com.example.bus_station_management_system.model.BusTrip;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class BusTripService extends BaseService<BusTrip> {

    private static final DateTimeFormatter START_TIME_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    private final RouteService routeService;
    private final BusService busService;
    private final TicketService ticketService;
    private final DutyAssignmentService dutyAssignmentService;

    public BusTripService(IRepository<BusTrip> repository, RouteService routeService, BusService busService,
                          @Lazy TicketService ticketService, @Lazy DutyAssignmentService dutyAssignmentService) {
        super(repository);
        this.routeService = routeService;
        this.busService = busService;
        this.ticketService = ticketService;
        this.dutyAssignmentService = dutyAssignmentService;
    }

    @Override
    protected void validateForCreate(BusTrip trip) {
        validateCommon(trip);
        if (trip.getStatus() == BusTrip.TripStatus.Planned && !trip.getStartTime().isAfter(LocalDateTime.now())) {
            throw new ValidationException("startTime", "Start time for a planned trip must be in the future.");
        }
    }

    @Override
    protected void validateForUpdate(BusTrip trip) {
        validateCommon(trip);
        if (trip.getStatus() == BusTrip.TripStatus.Planned && !trip.getStartTime().isAfter(LocalDateTime.now())) {
            throw new ValidationException("startTime", "Start time for a planned trip must be in the future.");
        }
    }

    private void validateCommon(BusTrip trip) {
        if (isBlank(trip.getRouteId()) || !routeService.existsById(trip.getRouteId())) {
            throw new ValidationException("routeId", "Selected route does not exist.");
        }
        if (isBlank(trip.getBusId()) || !busService.existsById(trip.getBusId())) {
            throw new ValidationException("busId", "Selected bus does not exist.");
        }
        if (trip.getStatus() == null) {
            throw new ValidationException("status", "Trip status must be selected.");
        }
        Bus bus = busService.findById(trip.getBusId());
        if (trip.getStatus() != BusTrip.TripStatus.Completed && bus.getStatus() == Bus.BusStatus.Down) {
            throw new ValidationException("busId", "Selected bus is currently down and cannot be assigned to a trip.");
        }
        if (trip.getStartTime() == null) {
            throw new ValidationException("startTime", "Start time must not be empty.");
        }
        boolean overlapping = findAll().stream()
                .anyMatch(existing -> !existing.getId().equals(trip.getId())
                        && trip.getBusId().equals(existing.getBusId())
                        && trip.getStartTime().equals(existing.getStartTime()));
        if (overlapping) {
            throw new ValidationException("startTime", "This bus already has a trip scheduled at the selected start time.");
        }
    }

    @Override
    protected void validateForDelete(String id) {
        boolean hasTickets = ticketService.findAll().stream()
                .anyMatch(ticket -> id.equals(ticket.getTripId()));
        if (hasTickets) {
            throw new ValidationException("Cannot delete bus trip because tickets exist for it.");
        }
        boolean hasAssignments = dutyAssignmentService.findAll().stream()
                .anyMatch(assignment -> id.equals(assignment.getTripId()));
        if (hasAssignments) {
            throw new ValidationException("Cannot delete bus trip because duty assignments exist for it.");
        }
    }

    @Override
    protected String label(BusTrip trip) {
        String start = trip.getStartTime() == null ? "no start time" : trip.getStartTime().format(START_TIME_FORMAT);
        return routeService.labelOf(trip.getRouteId()) + ", " + start;
    }

    public java.util.List<BusTrip> findByRouteId(String routeId) {
        return findAll().stream()
                .filter(trip -> routeId.equals(trip.getRouteId()))
                .toList();
    }

    public java.util.List<BusTrip> findByRouteIds(java.util.Set<String> routeIds) {
        return findAll().stream()
                .filter(trip -> routeIds.contains(trip.getRouteId()))
                .toList();
    }
}
