package com.example.bus_station_management_system.service;

import com.example.bus_station_management_system.exception.ValidationException;
import com.example.bus_station_management_system.model.Driver;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class DriverService extends BaseService<Driver> {

    private final DutyAssignmentService dutyAssignmentService;

    public DriverService(IRepository<Driver> repository, @Lazy DutyAssignmentService dutyAssignmentService) {
        super(repository);
        this.dutyAssignmentService = dutyAssignmentService;
    }

    @Override
    protected void validateForCreate(Driver driver) {
        requireNonBlank(driver.getName(), "name", "Driver name must not be blank.");
        if (driver.getSalary() < 0) {
            throw new ValidationException("salary", "Salary must be 0 or greater.");
        }
        if (driver.getYearsOfExperience() < 0) {
            throw new ValidationException("yearsOfExperience", "Years of experience must be 0 or greater.");
        }
    }

    @Override
    protected void validateForDelete(String id) {
        boolean assigned = dutyAssignmentService.findAll().stream()
                .anyMatch(assignment -> id.equals(assignment.getStaffId()));
        if (assigned) {
            throw new ValidationException("Cannot delete driver because they are assigned to a trip.");
        }
    }

    @Override
    protected String label(Driver driver) {
        return driver.getName();
    }
}
