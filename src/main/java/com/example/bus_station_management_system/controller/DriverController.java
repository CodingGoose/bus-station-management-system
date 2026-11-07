package com.example.bus_station_management_system.controller;

import com.example.bus_station_management_system.model.Driver;
import com.example.bus_station_management_system.service.DriverService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drivers")
public class DriverController extends BaseController<Driver, String> {
    public DriverController(DriverService service) {
        super(service, "driver", "drivers");
    }

    @Override
    protected Driver createEmptyEntity() {
        return new Driver();
    }
}
