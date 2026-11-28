package com.example.bus_station_management_system.repository.in_sql;

import com.example.bus_station_management_system.model.Driver;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("mysql")
public class SqlDriverRepository extends SqlRepository<Driver> {
    public SqlDriverRepository(DriverJpaRepository jpaRepository) {
        super(jpaRepository);
    }
}

interface DriverJpaRepository extends JpaRepository<Driver, String> {
}
