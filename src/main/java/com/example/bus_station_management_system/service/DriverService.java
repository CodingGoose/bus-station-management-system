package com.example.bus_station_management_system.service;
import com.example.bus_station_management_system.model.Driver;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverService extends BaseService<Driver> {
    public DriverService(IRepository<Driver> repository) {
        super(repository);
    }

    @Override
    protected String label(Driver driver) {
        return driver.getName();
    }
}
