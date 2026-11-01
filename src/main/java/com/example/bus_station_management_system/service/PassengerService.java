package com.example.bus_station_management_system.service;
import com.example.bus_station_management_system.model.*;
import com.example.bus_station_management_system.repository.*;
import org.springframework.stereotype.Service;

@Service
public class PassengerService extends BaseService<Passenger, String> {
    public PassengerService(PassengerRepository repository) {
        super(repository);
    }
}
