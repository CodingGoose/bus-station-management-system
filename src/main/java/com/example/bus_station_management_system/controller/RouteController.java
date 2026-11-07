package com.example.bus_station_management_system.controller;
import com.example.bus_station_management_system.model.Route;
import com.example.bus_station_management_system.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/routes")
public class RouteController extends BaseController<Route, String> {
    public RouteController(RouteService service) {
        super(service, "route", "routes");
    }

    @Override
    protected Route createEmptyEntity() {
        return new Route();
    }
}
