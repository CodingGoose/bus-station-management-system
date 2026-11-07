package com.example.bus_station_management_system.repository.in_memory;

import com.example.bus_station_management_system.model.BusTrip;
import com.example.bus_station_management_system.repository.BusTripRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryBusTripRepository extends InMemoryRepository<BusTrip, String> implements BusTripRepository {
    // Inherits all save, find, and delete methods automatically
}