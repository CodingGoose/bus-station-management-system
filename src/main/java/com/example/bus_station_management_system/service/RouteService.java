package com.example.bus_station_management_system.service;
import com.example.bus_station_management_system.model.BusStation;
import com.example.bus_station_management_system.model.Route;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.stereotype.Service;

@Service
public class RouteService extends BaseService<Route> {

    private final BusStationService stationService;

    public RouteService(IRepository<Route> repository, BusStationService stationService) {
        super(repository);
        this.stationService = stationService;
    }

    @Override
    protected String label(Route route) {
        return stationService.labelOf(idOf(route.getOrigin())) + " → " + stationService.labelOf(idOf(route.getDestination()));
    }

    private static String idOf(BusStation station) {
        return station == null ? null : station.getId();
    }
}
