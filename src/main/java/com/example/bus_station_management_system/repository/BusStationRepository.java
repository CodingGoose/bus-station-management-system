package com.example.bus_station_management_system.repository;
import com.example.bus_station_management_system.model.BusStation;
import org.springframework.stereotype.Repository;

@Repository
public class BusStationRepository extends InMemoryRepository<BusStation, String> {
}
