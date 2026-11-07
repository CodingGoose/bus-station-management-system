package com.example.bus_station_management_system.model;

public abstract class Staff implements Identifiable<String> {
    private String id;
    private String name;
    private int salary;

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
}
