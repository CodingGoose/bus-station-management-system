package com.example.bus_station_management_system.model;

import java.util.ArrayList;
import java.util.List;

public class Driver extends Staff {
    private int yearsOfExperience;
    private List<DutyAssignment> assignments;
    private List<String> decorations;

    public Driver(){}
    public Driver(String id, String name, int yearsOfExperience) {
        super(id, name);
        this.yearsOfExperience = yearsOfExperience;
        this.assignments = new ArrayList<>();
        this.decorations = new ArrayList<>();
    }

    public Driver(String id, String name, int salary, int yearsOfExperience) {
        super(id, name, salary);
        this.yearsOfExperience = yearsOfExperience;
        this.assignments = new ArrayList<>();
        this.decorations = new ArrayList<>();
    }


    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }

    public List<DutyAssignment> getAssignments() { return assignments; }
    public void setAssignments(List<DutyAssignment> assignments) { this.assignments = assignments; }

    public List<String> getDecorations() { return decorations; }
    public void setDecorations(List<String> decorations) { this.decorations = decorations; }
}
