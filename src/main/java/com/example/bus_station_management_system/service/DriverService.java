package com.example.bus_station_management_system.service;
import com.example.bus_station_management_system.model.*;
import com.example.bus_station_management_system.repository.*;
import org.springframework.stereotype.Service;

@Service
public class DriverService extends BaseService<Driver, String> {
    public DriverService(DriverRepository repository) {
        super(repository);
    }
}
