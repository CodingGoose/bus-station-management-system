package com.example.bus_station_management_system.service;

import com.example.bus_station_management_system.exception.ValidationException;
import com.example.bus_station_management_system.model.TripManager;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class TripManagerService extends BaseService<TripManager> {

    private final DutyAssignmentService dutyAssignmentService;

    public TripManagerService(IRepository<TripManager> repository, @Lazy DutyAssignmentService dutyAssignmentService) {
        super(repository);
        this.dutyAssignmentService = dutyAssignmentService;
    }

    @Override
    protected void validateForCreate(TripManager tripManager) {
        requireNonBlank(tripManager.getName(), "name", "Trip manager name must not be blank.");
        requireNonBlank(tripManager.getEmployeeCode(), "employeeCode", "Employee code must not be blank.");
        if (tripManager.getSalary() < 0) {
            throw new ValidationException("salary", "Salary must be 0 or greater.");
        }
        String normalizedCode = tripManager.getEmployeeCode().trim();
        boolean duplicateCode = findAll().stream()
                .anyMatch(existing -> !existing.getId().equals(tripManager.getId())
                        && existing.getEmployeeCode() != null
                        && existing.getEmployeeCode().trim().equalsIgnoreCase(normalizedCode));
        if (duplicateCode) {
            throw new ValidationException("employeeCode", "A trip manager with this employee code already exists.");
        }
    }

    @Override
    protected void validateForDelete(String id) {
        boolean assigned = dutyAssignmentService.findAll().stream()
                .anyMatch(assignment -> id.equals(assignment.getStaffId()));
        if (assigned) {
            throw new ValidationException("Cannot delete trip manager because they are assigned to a trip.");
        }
    }

    @Override
    protected String label(TripManager tripManager) {
        return tripManager.getName();
    }
}
