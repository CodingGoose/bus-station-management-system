package com.example.bus_station_management_system.config;

import com.example.bus_station_management_system.model.Bus;
import com.example.bus_station_management_system.model.BusStation;
import com.example.bus_station_management_system.model.BusTrip;
import com.example.bus_station_management_system.model.Driver;
import com.example.bus_station_management_system.model.DutyAssignment;
import com.example.bus_station_management_system.model.Passenger;
import com.example.bus_station_management_system.model.Route;
import com.example.bus_station_management_system.model.Ticket;
import com.example.bus_station_management_system.model.TripManager;
import com.example.bus_station_management_system.repository.IRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import tools.jackson.databind.json.JsonMapper;

@Component
@Profile("memory")
public class MemoryDataSeeder extends AbstractJsonDataSeeder {

    public MemoryDataSeeder(JsonMapper mapper,
                            IRepository<BusStation> busStationRepository,
                            IRepository<Bus> busRepository,
                            IRepository<Driver> driverRepository,
                            IRepository<TripManager> tripManagerRepository,
                            IRepository<Passenger> passengerRepository,
                            IRepository<Route> routeRepository,
                            IRepository<BusTrip> busTripRepository,
                            IRepository<Ticket> ticketRepository,
                            IRepository<DutyAssignment> dutyAssignmentRepository) {
        super(mapper, busStationRepository, busRepository, driverRepository, tripManagerRepository,
                passengerRepository, routeRepository, busTripRepository, ticketRepository, dutyAssignmentRepository);
    }

    @Override
    public void run(String @NonNull ... args) {
        seedAll();
    }
}
