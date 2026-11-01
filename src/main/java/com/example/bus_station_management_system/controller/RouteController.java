package com.example.bus_station_management_system.controller;
import com.example.bus_station_management_system.model.Route;
import com.example.bus_station_management_system.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/routes")
public class RouteController extends BaseController<Route, String> {
    public RouteController(RouteService service) {
        super(service);
    }
}
