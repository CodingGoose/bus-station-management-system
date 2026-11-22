package com.example.bus_station_management_system.repository.in_memory;

import com.example.bus_station_management_system.model.BusTrip;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Profile("memory")
public class InMemoryBusTripRepository extends InMemoryRepository<BusTrip>{
}