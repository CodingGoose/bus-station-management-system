package com.example.bus_station_management_system.model;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "driver")
public class Driver extends Staff {
    @PositiveOrZero(message = "Years of experience must be 0 or greater.")
    @Column(name = "years_of_experience", nullable = false)
    private int yearsOfExperience;
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

    public List<String> getDecorations() { return decorations; }
    public void setDecorations(List<String> decorations) { this.decorations = decorations; }
}
