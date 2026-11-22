package com.example.bus_station_management_system.controller;

import com.example.bus_station_management_system.model.Identifiable;
import com.example.bus_station_management_system.service.BaseService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public abstract class BaseController<T extends Identifiable> {

    protected final BaseService<T> service;
    protected final String folderName; // Used for URLs and HTML paths (e.g., "bus-trip")
    protected final String modelName;  // Used for Thymeleaf variables (e.g., "busTrip")
    protected final String listName;   // Used for Thymeleaf lists (e.g., "busTrips")

    public BaseController(BaseService<T> service, String folderName, String modelName, String listName) {
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
        service.create(entity);
        return "redirect:/" + folderName;
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        service.delete(id);
        return "redirect:/" + folderName;
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        model.addAttribute(modelName, service.findById(id));
        model.addAttribute("isEdit", true);
        return folderName + "/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable String id, @ModelAttribute T entity) {
        entity.setId(id);
        service.update(entity);
        return "redirect:/" + folderName;
    }
}