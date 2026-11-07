package com.example.bus_station_management_system.repository.in_memory;

import com.example.bus_station_management_system.model.TripManager;
import com.example.bus_station_management_system.repository.TripManagerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryTripManagerRepository extends InMemoryRepository<TripManager, String> implements TripManagerRepository {
    // Inherits all save, find, and delete methods automatically
}