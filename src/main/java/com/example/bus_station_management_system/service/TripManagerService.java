package com.example.bus_station_management_system.service;
import com.example.bus_station_management_system.model.TripManager;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.stereotype.Service;

@Service
public class TripManagerService extends BaseService<TripManager> {
    public TripManagerService(IRepository<TripManager> repository) {
        super(repository);
    }

    @Override
    protected String label(TripManager tripManager) {
        return tripManager.getName();
    }
}
