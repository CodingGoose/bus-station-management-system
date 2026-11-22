package com.example.bus_station_management_system.controller;
import com.example.bus_station_management_system.model.BusTrip;
import com.example.bus_station_management_system.service.BusService;
import com.example.bus_station_management_system.service.BusTripService;
import com.example.bus_station_management_system.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bus-trip")
public class BusTripController extends BaseController<BusTrip> {

    private final RouteService routeService;
    private final BusService busService;

    public BusTripController(BusTripService service, RouteService routeService, BusService busService) {
        super(service, "bus-trip", "busTrip", "busTrips");
        this.routeService = routeService;
        this.busService = busService;
    }

    @Override
    protected BusTrip createEmptyEntity() {
        return new BusTrip();
    }

    @Override
    protected void addReferenceData(Model model) {
        model.addAttribute("routeLabels", routeService.labels());
        model.addAttribute("busLabels", busService.labels());
    }
}
