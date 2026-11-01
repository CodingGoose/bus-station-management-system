package com.example.bus_station_management_system.model;

import java.util.ArrayList;
import java.util.List;

public class Driver extends Staff {
    private String yearsOfExperience;
    private List<DutyAssignment> assignments;
    private List<String> decorations;


    public Driver(String id, String name, String yearsOfExperience) {
        super(id, name);
        this.yearsOfExperience = yearsOfExperience;
        this.assignments = new ArrayList<>();
        this.decorations = new ArrayList<>();
    }

    public Driver(String id, String name, int salary, String yearsOfExperience) {
        super(id, name, salary);
        this.yearsOfExperience = yearsOfExperience;
        this.assignments = new ArrayList<>();
        this.decorations = new ArrayList<>();
    }


    public String getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(String yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }

    public List<DutyAssignment> getAssignments() { return assignments; }
    public void setAssignments(List<DutyAssignment> assignments) { this.assignments = assignments; }

    public List<String> getDecorations() { return decorations; }
    public void setDecorations(List<String> decorations) { this.decorations = decorations; }
}
