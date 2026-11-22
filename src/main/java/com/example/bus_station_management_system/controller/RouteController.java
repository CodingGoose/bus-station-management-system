package com.example.bus_station_management_system.controller;
import com.example.bus_station_management_system.model.Route;
import com.example.bus_station_management_system.service.BusStationService;
import com.example.bus_station_management_system.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/route")
public class RouteController extends BaseController<Route> {

    private final BusStationService stationService;

    public RouteController(RouteService service, BusStationService stationService) {
        super(service, "route", "route",  "routes");
        this.stationService = stationService;
    }

    @Override
    protected Route createEmptyEntity() {
        return new Route();
    }

    @Override
    protected void addReferenceData(Model model) {
        model.addAttribute("stationLabels", stationService.labels());
    }
}
