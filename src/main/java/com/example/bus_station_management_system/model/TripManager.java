package com.example.bus_station_management_system.model;

import java.util.ArrayList;
import java.util.List;

public class TripManager extends Staff {
    private String employeeCode;
    private List<DutyAssignment> assignments;

    public TripManager(String id, String name, String employeeCode) {
        super(id, name);
        this.employeeCode = employeeCode;
        this.assignments = new ArrayList<>();
    }

    public String getEmployeeCode() { return employeeCode; }
    public void setEmployeeCode(String employeeCode) { this.employeeCode = employeeCode; }

    public List<DutyAssignment> getAssignments() { return assignments; }
    public void setAssignments(List<DutyAssignment> assignments) { this.assignments = assignments; }
}
