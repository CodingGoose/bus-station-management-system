package com.example.bus_station_management_system.service;
import com.example.bus_station_management_system.model.Bus;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.stereotype.Service;

@Service
public class BusService extends BaseService<Bus> {

    public BusService(IRepository<Bus> repository) {
        super(repository);
    }

    @Override
    protected String label(Bus bus) {
        return bus.getRegistrationNumber();
    }
}
