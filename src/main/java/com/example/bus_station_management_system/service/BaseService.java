package com.example.bus_station_management_system.service;

import com.example.bus_station_management_system.exception.ValidationException;
import com.example.bus_station_management_system.model.Identifiable;
import com.example.bus_station_management_system.repository.IRepository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

public abstract class BaseService<T extends Identifiable> {

    protected final IRepository<T> repository;

    public BaseService(IRepository<T> repository) {
        this.repository = repository;
    }

    public T create(T entity) {
        if (entity == null) {
            throw new ValidationException("Entity must not be null.");
        }
        if (isBlank(entity.getId())) {
            entity.setId(UUID.randomUUID().toString());
        } else if (repository.existsById(entity.getId())) {
            throw new ValidationException("id", "An entity with ID " + entity.getId() + " already exists.");
        }
        validateForCreate(entity);
        return repository.create(entity);
    }

    public T update(T entity) {
        if (entity == null) {
            throw new ValidationException("Entity must not be null.");
        }
        if (isBlank(entity.getId()) || !repository.existsById(entity.getId())) {
            throw new NoSuchElementException("An entity with ID " + entity.getId() + " doesn't exist.");
        }
        validateForUpdate(entity);
        return repository.update(entity);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

    public T findById(String id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Entity with ID " + id + " not found."));
    }

    public boolean existsById(String id) {
        return !isBlank(id) && repository.existsById(id);
    }

    public void delete(String id) {
        if (!existsById(id)) {
            throw new NoSuchElementException("Entity with ID " + id + " not found.");
        }
        validateForDelete(id);
        repository.delete(id);
    }

    protected void validateForCreate(T entity) {
    }

    protected void validateForUpdate(T entity) {
        validateForCreate(entity);
    }

    protected void validateForDelete(String id) {
    }

    protected static boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    protected static void requireNonBlank(String value, String field, String message) {
        if (isBlank(value)) {
            throw new ValidationException(field, message);
        }
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
