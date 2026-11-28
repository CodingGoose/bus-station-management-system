package com.example.bus_station_management_system.repository.in_sql;

import com.example.bus_station_management_system.model.BusStation;
import com.example.bus_station_management_system.model.Route;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Profile("mysql")
public class SqlRouteRepository extends SqlRepository<Route> {

    private final BusStationJpaRepository busStationJpaRepository;

    public SqlRouteRepository(RouteJpaRepository jpaRepository, BusStationJpaRepository busStationJpaRepository) {
        super(jpaRepository);
        this.busStationJpaRepository = busStationJpaRepository;
    }

    @Override
    @Transactional
    public Route create(Route entity) {
        attachStations(entity);
        return super.create(entity);
    }

    @Override
    @Transactional
    public Route update(Route entity) {
        attachStations(entity);
        return super.update(entity);
    }

    private void attachStations(Route route) {
        if (route.getOrigin() != null && route.getOrigin().getId() != null) {
            BusStation origin = busStationJpaRepository.findById(route.getOrigin().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Origin station not found: " + route.getOrigin().getId()));
            route.setOrigin(origin);
        }
        if (route.getDestination() != null && route.getDestination().getId() != null) {
            BusStation destination = busStationJpaRepository.findById(route.getDestination().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Destination station not found: " + route.getDestination().getId()));
            route.setDestination(destination);
        }
    }
}

interface RouteJpaRepository extends JpaRepository<Route, String> {
}
