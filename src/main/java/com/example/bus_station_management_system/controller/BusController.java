package com.example.bus_station_management_system.controller;
import com.example.bus_station_management_system.model.Bus;
import com.example.bus_station_management_system.service.BusService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/buses")
public class BusController extends BaseController<Bus, String> {

    public BusController(BusService service) {
        super(service);
    }
}
