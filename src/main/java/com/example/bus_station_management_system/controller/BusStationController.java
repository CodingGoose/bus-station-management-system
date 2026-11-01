package com.example.bus_station_management_system.controller;
import com.example.bus_station_management_system.model.BusStation;
import com.example.bus_station_management_system.service.BusStationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/bus-stations")
public class BusStationController {
    private final BusStationService service;

    public BusStationController(BusStationService service) { this.service = service; }

    @PostMapping public BusStation create(@RequestBody BusStation entity) { return service.save(entity); }
    @GetMapping public List<BusStation> getAll() { return service.findAll(); }
    @GetMapping("/{id}") public BusStation getById(@PathVariable String id) { return service.findById(id); }
    @DeleteMapping("/{id}") public void delete(@PathVariable String id) { service.delete(id); }
}
