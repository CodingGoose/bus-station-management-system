package com.example.bus_station_management_system.repository.in_sql;

import com.example.bus_station_management_system.model.Bus;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("mysql")
public class SqlBusRepository extends SqlRepository<Bus> {
    public SqlBusRepository(BusJpaRepository jpaRepository) {
        super(jpaRepository);
    }
}

interface BusJpaRepository extends JpaRepository<Bus, String> {
}
