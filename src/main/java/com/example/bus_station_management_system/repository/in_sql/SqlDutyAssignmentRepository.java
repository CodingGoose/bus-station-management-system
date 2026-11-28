package com.example.bus_station_management_system.repository.in_sql;

import com.example.bus_station_management_system.model.DutyAssignment;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("mysql")
public class SqlDutyAssignmentRepository extends SqlRepository<DutyAssignment> {
    public SqlDutyAssignmentRepository(DutyAssignmentJpaRepository jpaRepository) {
        super(jpaRepository);
    }
}

interface DutyAssignmentJpaRepository extends JpaRepository<DutyAssignment, String> {
}
