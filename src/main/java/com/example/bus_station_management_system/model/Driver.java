package com.example.bus_station_management_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "driver")
public class Driver extends Staff {
    @Column(name = "years_of_experience", nullable = false)
    private int yearsOfExperience;
    @Transient
    @JsonIgnore
    private List<DutyAssignment> assignments = new ArrayList<>();
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "driver_decorations", joinColumns = @JoinColumn(name = "driver_id"))
    @Column(name = "decoration", nullable = false)
    private List<String> decorations = new ArrayList<>();

    public Driver(){}
    public Driver(String id, String name, int yearsOfExperience) {
        super(id, name);
        this.yearsOfExperience = yearsOfExperience;
    }

    public Driver(String id, String name, int salary, int yearsOfExperience) {
        super(id, name, salary);
        this.yearsOfExperience = yearsOfExperience;
    }


    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }

    public List<DutyAssignment> getAssignments() { return assignments; }
    public void setAssignments(List<DutyAssignment> assignments) { this.assignments = assignments; }

    public List<String> getDecorations() { return decorations; }
    public void setDecorations(List<String> decorations) { this.decorations = decorations; }
}
