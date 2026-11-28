package com.example.bus_station_management_system.repository.in_sql;

import com.example.bus_station_management_system.model.Passenger;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("mysql")
public class SqlPassengerRepository extends SqlRepository<Passenger> {
    public SqlPassengerRepository(PassengerJpaRepository jpaRepository) {
        super(jpaRepository);
    }
}

interface PassengerJpaRepository extends JpaRepository<Passenger, String> {
}
