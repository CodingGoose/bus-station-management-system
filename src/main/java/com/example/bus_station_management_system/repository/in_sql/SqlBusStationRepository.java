package com.example.bus_station_management_system.repository.in_sql;

import com.example.bus_station_management_system.model.BusStation;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("mysql")
public class SqlBusStationRepository extends SqlRepository<BusStation> {
    public SqlBusStationRepository(BusStationJpaRepository jpaRepository) {
        super(jpaRepository);
    }
}

interface BusStationJpaRepository extends JpaRepository<BusStation, String> {
}
