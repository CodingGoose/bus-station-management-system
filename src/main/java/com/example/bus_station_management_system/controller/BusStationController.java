package com.example.bus_station_management_system.controller;
import com.example.bus_station_management_system.model.BusStation;
import com.example.bus_station_management_system.service.BusService;
import com.example.bus_station_management_system.service.BusStationService;
import com.example.bus_station_management_system.service.BusTripService;
import com.example.bus_station_management_system.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/bus-station")
public class BusStationController extends BaseController<BusStation> {

    private final RouteService routeService;
    private final BusTripService busTripService;
    private final BusService busService;

    public BusStationController(BusStationService service, RouteService routeService,
                                BusTripService busTripService, BusService busService) {
        super(service, "bus-station", "busStation",  "busStations");
        this.routeService = routeService;
        this.busTripService = busTripService;
        this.busService = busService;
    }

    @Override
    protected BusStation createEmptyEntity() {
        return new BusStation();
    }

    @Override
    protected void addDetailsData(String id, Model model) {
        Set<String> routeIds = routeService.findIdsByStationId(id);
        model.addAttribute("trips", busTripService.findByRouteIds(routeIds));
        model.addAttribute("routeLabels", routeService.labels());
        model.addAttribute("busLabels", busService.labels());
    }
}
