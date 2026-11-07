package com.example.bus_station_management_system.repository;

import com.example.bus_station_management_system.model.Identifiable;

import java.util.List;

public interface IRepository <T extends Identifiable<ID>, ID>{
    T save(T entity);

    List<T> findAll();

    T findById(ID id);

    void delete(ID id);
}
