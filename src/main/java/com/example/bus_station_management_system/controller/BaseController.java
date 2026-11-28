package com.example.bus_station_management_system.controller;

import com.example.bus_station_management_system.exception.ValidationException;
import com.example.bus_station_management_system.model.Identifiable;
import com.example.bus_station_management_system.service.BaseService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.NoSuchElementException;

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

    protected void addReferenceData(Model model) {
    }

    protected void addDetailsData(String id, Model model) {
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute(listName, service.findAll());
        addReferenceData(model);
        return folderName + "/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute(modelName, createEmptyEntity());
        addReferenceData(model);
        return folderName + "/form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute T entity, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return renderFormWithErrors(entity, bindingResult, model, false);
        }
        try {
            service.create(entity);
            return "redirect:/" + folderName;
        } catch (ValidationException | NoSuchElementException e) {
            addExceptionError(bindingResult, e);
            return renderFormWithErrors(entity, bindingResult, model, false);
        }
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable String id, RedirectAttributes redirectAttributes) {
        try {
            service.delete(id);
        } catch (ValidationException | NoSuchElementException e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/" + folderName;
    }

    @GetMapping("/{id}")
    public String showDetails(@PathVariable String id, Model model) {
        model.addAttribute(modelName, service.findById(id));
        addReferenceData(model);
        addDetailsData(id, model);
        return folderName + "/details";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        model.addAttribute(modelName, service.findById(id));
        model.addAttribute("isEdit", true);
        addReferenceData(model);
        return folderName + "/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable String id, @Valid @ModelAttribute T entity, BindingResult bindingResult, Model model) {
        entity.setId(id);
        if (bindingResult.hasErrors()) {
            return renderFormWithErrors(entity, bindingResult, model, true);
        }
        try {
            service.update(entity);
            return "redirect:/" + folderName;
        } catch (ValidationException | NoSuchElementException e) {
            addExceptionError(bindingResult, e);
            return renderFormWithErrors(entity, bindingResult, model, true);
        }
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String handleNotFound(NoSuchElementException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        return "redirect:/" + folderName;
    }

    private void addExceptionError(BindingResult bindingResult, RuntimeException e) {
        if (e instanceof ValidationException ve && ve.getField() != null && !ve.getField().isBlank()) {
            bindingResult.rejectValue(ve.getField(), "validation.error", ve.getMessage());
        } else {
            bindingResult.reject("validation.error", e.getMessage());
        }
    }

    private String renderFormWithErrors(T entity, BindingResult bindingResult, Model model, boolean isEdit) {
        model.addAttribute(modelName, entity);
        model.addAttribute(BindingResult.MODEL_KEY_PREFIX + modelName, bindingResult);
        if (isEdit) {
            model.addAttribute("isEdit", true);
        }
        addReferenceData(model);
        return folderName + "/form";
    }
}
