package com.example.bus_station_management_system.service;

import com.example.bus_station_management_system.model.Identifiable;
import com.example.bus_station_management_system.repository.IRepository;

import java.util.List;
import java.util.NoSuchElementException;

public abstract class BaseService<T extends Identifiable> {

    protected final IRepository<T> repository;

    public BaseService(IRepository<T> repository) {
        this.repository = repository;
    }

    public T create(T entity){
        return repository.create(entity);
    }

    public T update(T entity){
        return repository.update(entity);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public T findById(String id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Entity with ID " + id + " not found."));
    }

    public void delete(String id) {
        repository.delete(id);
    }
}
