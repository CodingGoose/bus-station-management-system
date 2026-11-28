package com.example.bus_station_management_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "trip_manager")
public class TripManager extends Staff {
    @NotBlank(message = "Employee code must not be blank.")
    @Column(name = "employee_code", nullable = false)
    private String employeeCode;

    public TripManager(){}
    public TripManager(String id, String name, String employeeCode) {
        super(id, name);
        this.employeeCode = employeeCode;
    }

    public TripManager(String id, String name, int salary, String employeeCode) {
        super(id, name, salary);
        this.employeeCode = employeeCode;
    }

    public String getEmployeeCode() { return employeeCode; }
    public void setEmployeeCode(String employeeCode) { this.employeeCode = employeeCode; }

}
