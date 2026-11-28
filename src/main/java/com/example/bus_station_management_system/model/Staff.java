package com.example.bus_station_management_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "staff")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Staff implements Identifiable {
    @Id
    @Column(length = 36)
    private String id;
    @NotBlank(message = "Name must not be blank.")
    @Column(nullable = false)
    private String name;
    @PositiveOrZero(message = "Salary must be 0 or greater.")
    @Column(nullable = false)
    private int salary;
    @OneToMany(mappedBy = "staff")
    @JsonIgnore
    private List<DutyAssignment> assignments = new ArrayList<>();

    public Staff(){}
    public Staff(String id, String name) {
        this.id = id;
        this.name = name;
        this.salary = 0;
    }
    public Staff(String id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) { this.salary = salary; }

    public List<DutyAssignment> getAssignments() { return assignments; }
    public void setAssignments(List<DutyAssignment> assignments) { this.assignments = assignments; }
}
