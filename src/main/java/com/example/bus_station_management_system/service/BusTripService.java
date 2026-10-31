package com.example.bus_station_management_system.service;
import com.example.bus_station_management_system.model.BusTrip;
import com.example.bus_station_management_system.repository.BusTripRepository;
import org.springframework.stereotype.Service;

@Service
public class BusTripService extends BaseService<BusTrip, String> {

    public BusTripService(BusTripRepository repository) {
        super(repository);
    }
}
