package com.example.bus_station_management_system.repository;
import com.example.bus_station_management_system.model.Route;
import org.springframework.stereotype.Repository;

@Repository
public class RouteRepository extends InMemoryRepository<Route, String> {
}
