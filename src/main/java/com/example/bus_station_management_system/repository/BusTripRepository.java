package com.example.bus_station_management_system.repository;
import com.example.bus_station_management_system.model.BusTrip;
import org.springframework.stereotype.Repository;

@Repository
public class BusTripRepository extends InMemoryRepository<BusTrip, String> {
}