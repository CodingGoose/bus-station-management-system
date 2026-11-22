package com.example.bus_station_management_system.service;
import com.example.bus_station_management_system.model.DutyAssignment;
import com.example.bus_station_management_system.repository.IRepository;
import org.springframework.stereotype.Service;

@Service
public class DutyAssignmentService extends BaseService<DutyAssignment> {
    public DutyAssignmentService(IRepository<DutyAssignment> repository) {
        super(repository);
    }
}
