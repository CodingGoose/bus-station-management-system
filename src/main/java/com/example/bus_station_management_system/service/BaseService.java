package com.example.bus_station_management_system.service;

import com.example.bus_station_management_system.model.Identifiable;
import com.example.bus_station_management_system.repository.BaseRepository;

import java.util.List;

public abstract class BaseService<T extends Identifiable<ID>, ID> {

    // Using dependency injection for the repository
    protected final BaseRepository<T, ID> repository;

    public BaseService(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public T findById(ID id) {
        T entity = repository.findById(id);
        if (entity == null) {
            throw new RuntimeException("Entity with ID " + id + " not found.");
        }
        return entity;
    }

    public void delete(ID id) {
        repository.delete(id);
    }
}
