package com.example.bus_station_management_system.controller;

import com.example.bus_station_management_system.model.TripManager;
import com.example.bus_station_management_system.service.TripManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/trip-managers")
public class TripManagerController extends BaseController<TripManager, String> {
    public TripManagerController(TripManagerService service) {
        super(service);
    }
}
