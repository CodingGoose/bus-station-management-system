package com.example.bus_station_management_system.controller;

import com.example.bus_station_management_system.model.Passenger;
import com.example.bus_station_management_system.service.PassengerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/passengers")
public class PassengerController extends BaseController<Passenger, String> {
    public PassengerController(PassengerService service) {
        super(service);
    }
}
