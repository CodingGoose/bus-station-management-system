package com.example.bus_station_management_system.repository.in_sql;

import com.example.bus_station_management_system.model.TripManager;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("mysql")
public class SqlTripManagerRepository extends SqlRepository<TripManager> {
    public SqlTripManagerRepository(TripManagerJpaRepository jpaRepository) {
        super(jpaRepository);
    }
}

interface TripManagerJpaRepository extends JpaRepository<TripManager, String> {
}
