package com.example.bus_station_management_system.config;

import com.example.bus_station_management_system.model.Bus;
import com.example.bus_station_management_system.model.BusStation;
import com.example.bus_station_management_system.model.BusTrip;
import com.example.bus_station_management_system.model.Driver;
import com.example.bus_station_management_system.model.DutyAssignment;
import com.example.bus_station_management_system.model.Identifiable;
import com.example.bus_station_management_system.model.Passenger;
import com.example.bus_station_management_system.model.Route;
import com.example.bus_station_management_system.model.Ticket;
import com.example.bus_station_management_system.model.TripManager;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.List;

public abstract class AbstractJsonDataSeeder implements CommandLineRunner {

    private final JsonMapper mapper;
    private final IRepository<BusStation> busStationRepository;
    private final IRepository<Bus> busRepository;
    private final IRepository<Driver> driverRepository;
    private final IRepository<TripManager> tripManagerRepository;
    private final IRepository<Passenger> passengerRepository;
    private final IRepository<Route> routeRepository;
    private final IRepository<BusTrip> busTripRepository;
    private final IRepository<Ticket> ticketRepository;
    private final IRepository<DutyAssignment> dutyAssignmentRepository;

    protected AbstractJsonDataSeeder(JsonMapper mapper,
                                     IRepository<BusStation> busStationRepository,
                                     IRepository<Bus> busRepository,
                                     IRepository<Driver> driverRepository,
                                     IRepository<TripManager> tripManagerRepository,
                                     IRepository<Passenger> passengerRepository,
                                     IRepository<Route> routeRepository,
                                     IRepository<BusTrip> busTripRepository,
                                     IRepository<Ticket> ticketRepository,
                                     IRepository<DutyAssignment> dutyAssignmentRepository) {
        this.mapper = mapper;
        this.busStationRepository = busStationRepository;
        this.busRepository = busRepository;
        this.driverRepository = driverRepository;
        this.tripManagerRepository = tripManagerRepository;
        this.passengerRepository = passengerRepository;
        this.routeRepository = routeRepository;
        this.busTripRepository = busTripRepository;
        this.ticketRepository = ticketRepository;
        this.dutyAssignmentRepository = dutyAssignmentRepository;
    }

    protected boolean areAllRepositoriesEmpty() {
        return List.of(
                busStationRepository,
                busRepository,
                driverRepository,
                tripManagerRepository,
                passengerRepository,
                routeRepository,
                busTripRepository,
                ticketRepository,
                dutyAssignmentRepository
        ).stream().allMatch(repo -> repo.findAll().isEmpty());
    }

    protected void seedAll() {
        // Entities that reference nothing
        seed("bus-station.json", BusStation.class, busStationRepository);
        seed("bus.json", Bus.class, busRepository);
        seed("driver.json", Driver.class, driverRepository);
        seed("trip-manager.json", TripManager.class, tripManagerRepository);
        seed("passenger.json", Passenger.class, passengerRepository);
        // Entities that reference the ones above
        seed("route.json", Route.class, routeRepository);
        seed("bus-trip.json", BusTrip.class, busTripRepository);
        seed("ticket.json", Ticket.class, ticketRepository);
        seed("duty-assignment.json", DutyAssignment.class, dutyAssignmentRepository);
    }

    private <T extends Identifiable> void seed(String fileName, Class<T> type, IRepository<T> repository) {
        ClassPathResource resource = new ClassPathResource("data/" + fileName);
        try (InputStream in = resource.getInputStream()) {
            List<T> entities = mapper.readValue(in, mapper.getTypeFactory().constructCollectionType(List.class, type));
            entities.forEach(repository::create);
        } catch (IOException e) {
            throw new UncheckedIOException("Could not read seed file " + fileName, e);
        }
    }
}
