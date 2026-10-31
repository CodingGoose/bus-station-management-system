package com.example.bus_station_management_system.service;
import com.example.bus_station_management_system.model.Bus;
import com.example.bus_station_management_system.repository.BusRepository;
import org.springframework.stereotype.Service;

@Service
public class BusService extends BaseService<Bus, String> {

    public BusService(BusRepository repository) {
        super(repository);
    }
}
