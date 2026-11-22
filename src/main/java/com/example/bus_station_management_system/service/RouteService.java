package com.example.bus_station_management_system.service;
import com.example.bus_station_management_system.model.Route;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.stereotype.Service;

@Service
public class RouteService extends BaseService<Route> {

    public RouteService(IRepository<Route> repository) {
        super(repository);
    }
}
