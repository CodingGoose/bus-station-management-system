package com.example.bus_station_management_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trip_manager")
public class TripManager extends Staff {
    @Column(name = "employee_code", nullable = false)
    private String employeeCode;
    @Transient
    @JsonIgnore
    private List<DutyAssignment> assignments = new ArrayList<>();

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

    public List<DutyAssignment> getAssignments() { return assignments; }
    public void setAssignments(List<DutyAssignment> assignments) { this.assignments = assignments; }

}
