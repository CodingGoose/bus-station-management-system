package com.example.bus_station_management_system.service;

import com.example.bus_station_management_system.model.Identifiable;
import com.example.bus_station_management_system.repository.IRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

    protected String label(T entity) {
        return entity.getId();
    }

    public Map<String, String> labels() {
        Map<String, String> labels = new LinkedHashMap<>();
        for (T entity : findAll()) {
            labels.put(entity.getId(), label(entity));
        }
        return labels;
    }

    /** Name of the entity with this ID, or a placeholder if there is none (e.g. it was deleted). */
    public String labelOf(String id) {
        if (id == null) {
            return "-";
        }
        return repository.findById(id).map(this::label).orElse("(deleted)");
    }
}
