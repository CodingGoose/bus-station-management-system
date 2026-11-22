package com.example.bus_station_management_system.service;
import com.example.bus_station_management_system.model.Passenger;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.stereotype.Service;

@Service
public class PassengerService extends BaseService<Passenger> {
    public PassengerService(IRepository<Passenger> repository) {
        super(repository);
    }

    @Override
    protected String label(Passenger passenger) {
        return passenger.getName();
    }
}
