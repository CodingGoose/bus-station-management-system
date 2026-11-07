package com.example.bus_station_management_system.controller;

import com.example.bus_station_management_system.model.Identifiable;
import com.example.bus_station_management_system.service.BaseService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public abstract class BaseController<T extends Identifiable<ID>, ID> {

    protected final BaseService<T, ID> service;
    protected final String entityName; // e.g., "bus"
    protected final String listName;   // e.g., "buses"

    // The constructor now requires the string names so Thymeleaf knows which folders to look for
    public BaseController(BaseService<T, ID> service, String entityName, String listName) {
        this.service = service;
        this.entityName = entityName;
        this.listName = listName;
    }

    // Abstract method to bypass Java's inability to call 'new T()'
    protected abstract T createEmptyEntity();

    // 1. GET /<entität> -> Shows the list
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute(listName, service.findAll());
        return entityName + "/index"; // Evaluates to something like "bus/index"
    }

    // 2. GET /<entität>/new -> Shows the form
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute(entityName, createEmptyEntity());
        return entityName + "/form"; // Evaluates to something like "bus/form"
    }

    // 3. POST /<entität> -> Processes the form and saves
    @PostMapping
    public String create(@ModelAttribute T entity) {
        service.save(entity);
        return "redirect:/" + entityName; // Redirects back to the table view
    }

    // 4. POST /<entität>/{id}/delete -> Deletes the object
    // The GET /{id} method is removed because detail views are explicitly not required
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable ID id) {
        service.delete(id);
        return "redirect:/" + entityName; // Redirects back to the table view
    }
}
