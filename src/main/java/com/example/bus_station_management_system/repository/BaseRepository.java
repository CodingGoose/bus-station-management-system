package com.example.bus_station_management_system.repository;

import com.example.bus_station_management_system.model.Identifiable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class BaseRepository<T extends Identifiable<V>, V> {

    // Protected so child classes can access it if custom queries are needed later
    protected Map<V, T> storage = new HashMap<>();

    public T save(T entity) {
        storage.put(entity.getId(), entity);
        return entity;
    }

    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    public T findById(V id) {
        return storage.get(id);
    }

    public void delete(V id) {
        storage.remove(id);
    }
}
