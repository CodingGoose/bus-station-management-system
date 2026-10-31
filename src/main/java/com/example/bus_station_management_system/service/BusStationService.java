package com.example.bus_station_management_system.service;
import com.example.bus_station_management_system.model.BusStation;
import com.example.bus_station_management_system.repository.BusStationRepository;
import org.springframework.stereotype.Service;

@Service
public class BusStationService extends BaseService<BusStation, String> {

    public BusStationService(BusStationRepository repository) {
        super(repository);
    }
}
