package com.example.bus_station_management_system.repository.in_memory;

import com.example.bus_station_management_system.model.DutyAssignment;
import com.example.bus_station_management_system.repository.DutyAssignmentRepository;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryDutyAssignmentRepository extends InMemoryRepository<DutyAssignment, String> implements DutyAssignmentRepository {
    // Inherits all save, find, and delete methods automatically
}
