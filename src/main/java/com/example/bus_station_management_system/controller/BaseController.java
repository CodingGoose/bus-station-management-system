package com.example.bus_station_management_system.controller;

import com.example.bus_station_management_system.model.Identifiable;
import com.example.bus_station_management_system.service.BaseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public abstract class BaseController<T extends Identifiable<ID>, ID> {

    protected final BaseService<T, ID> service;

    public BaseController(BaseService<T, ID> service) {
        this.service = service;
    }

    @PostMapping
    public T create(@RequestBody T entity) {
        return service.save(entity);
    }

    @GetMapping
    public List<T> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public T getById(@PathVariable ID id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        service.delete(id);
    }
}
