package com.example.bus_station_management_system.repository;

import com.example.bus_station_management_system.model.Identifiable;

import java.util.List;
import java.util.Optional;

public interface IRepository <T extends Identifiable>{
    T create(T entity);

    T update(T entity);

    List<T> findAll();

    Optional<T> findById(String id);

    boolean existsById(String id);

    void delete(String id);
}
