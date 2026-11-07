package com.example.bus_station_management_system.repository;
import com.example.bus_station_management_system.model.Bus;
import org.springframework.stereotype.Repository;

@Repository
public class BusRepository extends InMemoryRepository<Bus, String> {
}
