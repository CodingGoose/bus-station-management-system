package com.example.bus_station_management_system.service;

import com.example.bus_station_management_system.exception.ValidationException;
import com.example.bus_station_management_system.model.BusStation;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class BusStationService extends BaseService<BusStation> {

    private final RouteService routeService;

    public BusStationService(IRepository<BusStation> repository, @Lazy RouteService routeService) {
        super(repository);
        this.routeService = routeService;
    }

    @Override
    protected void validateForCreate(BusStation station) {
        requireNonBlank(station.getName(), "name", "Station name must not be blank.");
        requireNonBlank(station.getCity(), "city", "City must not be blank.");

        String normalizedName = station.getName().trim();
        String normalizedCity = station.getCity().trim();
        boolean duplicate = findAll().stream()
                .anyMatch(existing -> !existing.getId().equals(station.getId())
                        && existing.getName() != null && existing.getName().trim().equalsIgnoreCase(normalizedName)
                        && existing.getCity() != null && existing.getCity().trim().equalsIgnoreCase(normalizedCity));
        if (duplicate) {
            throw new ValidationException("name", "A station with this name and city already exists.");
        }
    }

    @Override
    protected void validateForDelete(String id) {
        boolean inUse = routeService.findAll().stream()
                .anyMatch(route -> (route.getOrigin() != null && id.equals(route.getOrigin().getId()))
                        || (route.getDestination() != null && id.equals(route.getDestination().getId())));
        if (inUse) {
            throw new ValidationException("Cannot delete bus station because it is used by an existing route.");
        }
    }

    @Override
    protected String label(BusStation station) {
        return station.getName();
    }
}
