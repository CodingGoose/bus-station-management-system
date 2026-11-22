package com.example.bus_station_management_system.service;
import com.example.bus_station_management_system.model.BusTrip;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class BusTripService extends BaseService<BusTrip> {

    private static final DateTimeFormatter START_TIME_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    private final RouteService routeService;

    public BusTripService(IRepository<BusTrip> repository, RouteService routeService) {
        super(repository);
        this.routeService = routeService;
    }

    @Override
    protected String label(BusTrip trip) {
        String start = trip.getStartTime() == null ? "no start time" : trip.getStartTime().format(START_TIME_FORMAT);
        return routeService.labelOf(trip.getRouteId()) + ", " + start;
    }
}
