package com.example.bus_station_management_system.repository.in_memory;

import com.example.bus_station_management_system.model.BusStation;
import com.example.bus_station_management_system.repository.BusStationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryBusStationRepository extends InMemoryRepository<BusStation, String> implements BusStationRepository {
    // Inherits all save, find, and delete methods automatically
}