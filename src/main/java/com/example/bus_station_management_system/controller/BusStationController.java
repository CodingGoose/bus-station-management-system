package com.example.bus_station_management_system.controller;
import com.example.bus_station_management_system.model.BusStation;
import com.example.bus_station_management_system.service.BusStationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/bus-station")
public class BusStationController extends BaseController<BusStation, String> {
    public BusStationController(BusStationService service) {
        super(service, "bus-station", "bus-stations");
    }

    @Override
    protected BusStation createEmptyEntity() {
        return new BusStation();
    }
}
