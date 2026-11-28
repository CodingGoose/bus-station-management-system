package com.example.bus_station_management_system.repository.in_sql;

import com.example.bus_station_management_system.model.BusTrip;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("mysql")
public class SqlBusTripRepository extends SqlRepository<BusTrip> {
    public SqlBusTripRepository(BusTripJpaRepository jpaRepository) {
        super(jpaRepository);
    }
}

interface BusTripJpaRepository extends JpaRepository<BusTrip, String> {
}
