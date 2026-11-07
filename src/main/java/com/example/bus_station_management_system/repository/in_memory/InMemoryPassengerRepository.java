package com.example.bus_station_management_system.repository.in_memory;

import com.example.bus_station_management_system.model.Passenger;
import com.example.bus_station_management_system.repository.PassengerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryPassengerRepository extends InMemoryRepository<Passenger, String> implements PassengerRepository {
    // Inherits all save, find, and delete methods automatically
}
