package com.example.bus_station_management_system.repository.in_memory;

import com.example.bus_station_management_system.model.Bus;
import com.example.bus_station_management_system.repository.BusRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryBusRepository extends InMemoryRepository<Bus, String> implements BusRepository {
    // Inherits all save, find, and delete methods automatically
}
