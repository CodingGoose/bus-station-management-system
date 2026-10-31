package com.example.bus_station_management_system.service;
import com.example.bus_station_management_system.model.Route;
import com.example.bus_station_management_system.repository.RouteRepository;
import org.springframework.stereotype.Service;

@Service
public class RouteService extends BaseService<Route, String> {

    public RouteService(RouteRepository repository) {
        super(repository);
    }
}
