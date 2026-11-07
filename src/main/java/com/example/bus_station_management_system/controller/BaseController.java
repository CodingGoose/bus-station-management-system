package com.example.bus_station_management_system.controller;

import com.example.bus_station_management_system.model.Identifiable;
import com.example.bus_station_management_system.service.BaseService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public abstract class BaseController<T extends Identifiable<ID>, ID> {

    protected final BaseService<T, ID> service;
    protected final String folderName; // Used for URLs and HTML paths (e.g., "bus-trip")
    protected final String modelName;  // Used for Thymeleaf variables (e.g., "busTrip")
    protected final String listName;   // Used for Thymeleaf lists (e.g., "busTrips")

    public BaseController(BaseService<T, ID> service, String folderName, String modelName, String listName) {
        this.service = service;
        this.folderName = folderName;
        this.modelName = modelName;
        this.listName = listName;
    }

    protected abstract T createEmptyEntity();

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute(listName, service.findAll());
        return folderName + "/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute(modelName, createEmptyEntity());
        return folderName + "/form";
    }

    @PostMapping
    public String create(@ModelAttribute T entity) {
        service.save(entity);
        return "redirect:/" + folderName;
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable ID id) {
        service.delete(id);
        return "redirect:/" + folderName;
    }
}