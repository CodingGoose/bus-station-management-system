package com.example.bus_station_management_system.repository;

import com.example.bus_station_management_system.model.Identifiable;

import java.util.List;

public interface IRepository <T extends Identifiable<V>, V>{
    public T save(T entity);

    public List<T> findAll();

    public T findById(V id);

    public void delete(V id);
}
