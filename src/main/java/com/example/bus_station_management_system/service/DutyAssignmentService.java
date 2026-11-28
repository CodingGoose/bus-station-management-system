package com.example.bus_station_management_system.service;

import com.example.bus_station_management_system.exception.ValidationException;
import com.example.bus_station_management_system.model.BusTrip;
import com.example.bus_station_management_system.model.DutyAssignment;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.stereotype.Service;

@Service
public class DutyAssignmentService extends BaseService<DutyAssignment> {

    private final BusTripService busTripService;
    private final DriverService driverService;
    private final TripManagerService tripManagerService;

    public DutyAssignmentService(IRepository<DutyAssignment> repository, BusTripService busTripService,
                                 DriverService driverService, TripManagerService tripManagerService) {
        super(repository);
        this.busTripService = busTripService;
        this.driverService = driverService;
        this.tripManagerService = tripManagerService;
    }

    @Override
    protected void validateForCreate(DutyAssignment assignment) {
        if (isBlank(assignment.getTripId()) || !busTripService.existsById(assignment.getTripId())) {
            throw new ValidationException("tripId", "Selected trip does not exist.");
        }
        if (isBlank(assignment.getStaffId())
                || (!driverService.existsById(assignment.getStaffId()) && !tripManagerService.existsById(assignment.getStaffId()))) {
            throw new ValidationException("staffId", "Selected staff member does not exist.");
        }
        if (assignment.getRole() == null) {
            throw new ValidationException("role", "Role must be selected.");
        }

        BusTrip trip = busTripService.findById(assignment.getTripId());
        if (trip.getStatus() == BusTrip.TripStatus.Completed) {
            throw new ValidationException("tripId", "Cannot add or modify duty assignments for a completed trip.");
        }

        boolean duplicateStaff = findAll().stream()
                .anyMatch(existing -> !existing.getId().equals(assignment.getId())
                        && assignment.getTripId().equals(existing.getTripId())
                        && assignment.getStaffId().equals(existing.getStaffId()));
        if (duplicateStaff) {
            throw new ValidationException("staffId", "This staff member is already assigned to the selected trip.");
        }

        if (assignment.getRole() == DutyAssignment.RoleType.PrimaryDriver) {
            boolean hasPrimary = findAll().stream()
                    .anyMatch(existing -> !existing.getId().equals(assignment.getId())
                            && assignment.getTripId().equals(existing.getTripId())
                            && existing.getRole() == DutyAssignment.RoleType.PrimaryDriver);
            if (hasPrimary) {
                throw new ValidationException("role", "This trip already has a primary driver assigned.");
            }
        }
    }
}
