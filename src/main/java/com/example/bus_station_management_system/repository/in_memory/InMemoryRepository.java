package com.example.bus_station_management_system.repository.in_memory;

import com.example.bus_station_management_system.model.Identifiable;
import com.example.bus_station_management_system.repository.IRepository;

import java.util.*;


public abstract class InMemoryRepository<T extends Identifiable> implements IRepository<T> {

    // Protected so child classes can access it if custom queries are needed later
    protected final Map<String, T> storage = new LinkedHashMap<>();

    @Override
    public synchronized T create(T entity) {
        if (entity.getId() == null || entity.getId().isBlank()) {
            entity.setId(UUID.randomUUID().toString());
        } else if (storage.containsKey(entity.getId())) {
            throw new IllegalArgumentException("An entity with ID " + entity.getId() + " already exists.");
        }
        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public synchronized T update(T entity) {
        if (!storage.containsKey(entity.getId())) {
            throw new NoSuchElementException("An entity with ID " + entity.getId() + " doesn't exist.");
        }
        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public synchronized List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public synchronized Optional<T> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public synchronized void delete(String id) {
        storage.remove(id);
    }

    @Override
    public synchronized boolean existsById(String id){
        return storage.containsKey(id);
    }
}
