package com.example.bus_station_management_system.controller;
import com.example.bus_station_management_system.model.Route;
import com.example.bus_station_management_system.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/routes")
public class RouteController {
    private final RouteService service;

    public RouteController(RouteService service) { this.service = service; }

    @PostMapping public Route create(@RequestBody Route entity) { return service.save(entity); }
    @GetMapping public List<Route> getAll() { return service.findAll(); }
    @GetMapping("/{id}") public Route getById(@PathVariable String id) { return service.findById(id); }
    @DeleteMapping("/{id}") public void delete(@PathVariable String id) { service.delete(id); }
}
