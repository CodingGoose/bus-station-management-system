package com.example.bus_station_management_system.controller;
import com.example.bus_station_management_system.model.BusTrip;
import com.example.bus_station_management_system.service.BusTripService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/bus-trips")
public class BusTripController {
    private final BusTripService service;

    public BusTripController(BusTripService service) { this.service = service; }

    @PostMapping public BusTrip create(@RequestBody BusTrip entity) { return service.save(entity); }
    @GetMapping public List<BusTrip> getAll() { return service.findAll(); }
    @GetMapping("/{id}") public BusTrip getById(@PathVariable String id) { return service.findById(id); }
    @DeleteMapping("/{id}") public void delete(@PathVariable String id) { service.delete(id); }
}
