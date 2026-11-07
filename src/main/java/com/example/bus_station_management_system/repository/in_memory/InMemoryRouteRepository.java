package com.example.bus_station_management_system.repository.in_memory;

import com.example.bus_station_management_system.model.Route;
import com.example.bus_station_management_system.repository.RouteRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryRouteRepository extends InMemoryRepository<Route, String> implements RouteRepository {
    // Inherits all save, find, and delete methods automatically
}
