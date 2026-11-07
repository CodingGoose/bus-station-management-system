package com.example.bus_station_management_system.controller;
import com.example.bus_station_management_system.model.BusTrip;
import com.example.bus_station_management_system.service.BusTripService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bus-trip")
public class BusTripController extends BaseController<BusTrip, String> {
    public BusTripController(BusTripService service) {
        super(service, "bus-trip", "busTrip", "busTrips");
    }

    @Override
    protected BusTrip createEmptyEntity() {
        return new BusTrip();
    }
}
