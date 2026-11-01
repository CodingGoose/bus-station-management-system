package com.example.bus_station_management_system.controller;
import com.example.bus_station_management_system.model.Bus;
import com.example.bus_station_management_system.service.BusService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/buses")
public class BusController {
    private final BusService service;

    public BusController(BusService service) { this.service = service; }

    @PostMapping public Bus create(@RequestBody Bus entity) { return service.save(entity); }
    @GetMapping public List<Bus> getAll() { return service.findAll(); }
    @GetMapping("/{id}") public Bus getById(@PathVariable String id) { return service.findById(id); }
    @DeleteMapping("/{id}") public void delete(@PathVariable String id) { service.delete(id); }
}
