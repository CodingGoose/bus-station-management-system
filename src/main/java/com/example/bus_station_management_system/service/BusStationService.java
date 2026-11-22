package com.example.bus_station_management_system.service;
import com.example.bus_station_management_system.model.BusStation;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.stereotype.Service;

@Service
public class BusStationService extends BaseService<BusStation> {

    public BusStationService(IRepository<BusStation> repository) {
        super(repository);
    }

    @Override
    protected String label(BusStation station) {
        return station.getName();
    }
}
