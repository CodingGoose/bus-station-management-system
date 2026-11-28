package com.example.bus_station_management_system.controller;
import com.example.bus_station_management_system.model.Route;
import com.example.bus_station_management_system.service.BusService;
import com.example.bus_station_management_system.service.BusStationService;
import com.example.bus_station_management_system.service.BusTripService;
import com.example.bus_station_management_system.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/route")
public class RouteController extends BaseController<Route> {

    private final BusStationService stationService;
    private final BusTripService busTripService;
    private final BusService busService;

    public RouteController(RouteService service, BusStationService stationService,
                           BusTripService busTripService, BusService busService) {
        super(service, "route", "route",  "routes");
        this.stationService = stationService;
        this.busTripService = busTripService;
        this.busService = busService;
    }

    @Override
    protected Route createEmptyEntity() {
        return new Route();
    }

    @Override
    protected void addReferenceData(Model model) {
        model.addAttribute("stationLabels", stationService.labels());
    }

    @Override
    protected void addDetailsData(String id, Model model) {
        model.addAttribute("trips", busTripService.findByRouteId(id));
        model.addAttribute("busLabels", busService.labels());
    }
}
