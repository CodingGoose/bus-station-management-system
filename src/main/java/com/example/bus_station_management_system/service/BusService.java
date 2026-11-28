package com.example.bus_station_management_system.service;

import com.example.bus_station_management_system.exception.ValidationException;
import com.example.bus_station_management_system.model.Bus;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class BusService extends BaseService<Bus> {

    private final BusTripService busTripService;

    public BusService(IRepository<Bus> repository, @Lazy BusTripService busTripService) {
        super(repository);
        this.busTripService = busTripService;
    }

    @Override
    protected void validateForCreate(Bus bus) {
        requireNonBlank(bus.getRegistrationNumber(), "registrationNumber", "Registration number must not be blank.");
        String normalizedReg = bus.getRegistrationNumber().trim();
        boolean duplicateReg = findAll().stream()
                .anyMatch(existing -> !existing.getId().equals(bus.getId())
                        && existing.getRegistrationNumber() != null
                        && existing.getRegistrationNumber().trim().equalsIgnoreCase(normalizedReg));
        if (duplicateReg) {
            throw new ValidationException("registrationNumber", "A bus with this registration number already exists.");
        }
        if (bus.getCapacity() <= 0) {
            throw new ValidationException("capacity", "Capacity must be greater than 0.");
        }
        if (bus.getFuelType() == null) {
            throw new ValidationException("fuelType", "Fuel type must be selected.");
        }
        if (bus.getStatus() == null) {
            throw new ValidationException("status", "Status must be selected.");
        }
    }

    @Override
    protected void validateForDelete(String id) {
        boolean inUse = busTripService.findAll().stream()
                .anyMatch(trip -> id.equals(trip.getBusId()));
        if (inUse) {
            throw new ValidationException("Cannot delete bus because it is assigned to an existing trip.");
        }
    }

    @Override
    protected String label(Bus bus) {
        return bus.getRegistrationNumber();
    }
}
