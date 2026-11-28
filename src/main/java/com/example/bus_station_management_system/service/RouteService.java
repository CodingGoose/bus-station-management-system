package com.example.bus_station_management_system.service;

import com.example.bus_station_management_system.exception.ValidationException;
import com.example.bus_station_management_system.model.BusStation;
import com.example.bus_station_management_system.model.Route;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class RouteService extends BaseService<Route> {

    private final BusStationService stationService;
    private final BusTripService busTripService;

    public RouteService(IRepository<Route> repository, BusStationService stationService,
                        @Lazy BusTripService busTripService) {
        super(repository);
        this.stationService = stationService;
        this.busTripService = busTripService;
    }

    @Override
    protected void validateForCreate(Route route) {
        String originId = idOf(route.getOrigin());
        if (isBlank(originId) || !stationService.existsById(originId)) {
            throw new ValidationException("origin.id", "Selected origin station does not exist.");
        }
        String destinationId = idOf(route.getDestination());
        if (isBlank(destinationId) || !stationService.existsById(destinationId)) {
            throw new ValidationException("destination.id", "Selected destination station does not exist.");
        }
        if (originId.equals(destinationId)) {
            throw new ValidationException("destination.id", "Destination station must be different from origin station.");
        }
        if (route.getDistance() <= 0) {
            throw new ValidationException("distance", "Distance must be greater than 0.");
        }
    }

    @Override
    protected void validateForDelete(String id) {
        boolean inUse = busTripService.findAll().stream()
                .anyMatch(trip -> id.equals(trip.getRouteId()));
        if (inUse) {
            throw new ValidationException("Cannot delete route because it is used by an existing bus trip.");
        }
    }

    @Override
    protected String label(Route route) {
        return stationService.labelOf(idOf(route.getOrigin())) + " → " + stationService.labelOf(idOf(route.getDestination()));
    }

    private static String idOf(BusStation station) {
        return station == null ? null : station.getId();
    }

    public java.util.Set<String> findIdsByStationId(String stationId) {
        return findAll().stream()
                .filter(route -> stationId.equals(idOf(route.getOrigin()))
                        || stationId.equals(idOf(route.getDestination())))
                .map(Route::getId)
                .collect(java.util.stream.Collectors.toSet());
    }
}
