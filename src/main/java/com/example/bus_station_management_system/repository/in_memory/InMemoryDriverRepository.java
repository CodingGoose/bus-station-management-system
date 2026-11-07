package com.example.bus_station_management_system.repository.in_memory;

import com.example.bus_station_management_system.model.Driver;
import com.example.bus_station_management_system.repository.DriverRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryDriverRepository extends InMemoryRepository<Driver, String> implements DriverRepository {
    // Inherits all save, find, and delete methods automatically
}
