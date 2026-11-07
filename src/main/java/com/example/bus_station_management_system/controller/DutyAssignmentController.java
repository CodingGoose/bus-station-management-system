package com.example.bus_station_management_system.controller;

import com.example.bus_station_management_system.model.DutyAssignment;
import com.example.bus_station_management_system.service.DutyAssignmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/duty-assignments")
public class DutyAssignmentController extends BaseController<DutyAssignment, String> {
    public DutyAssignmentController(DutyAssignmentService service) {
        super(service, "duty-assignment", "duty-assignments");
    }

    @Override
    protected DutyAssignment createEmptyEntity() {
        return new DutyAssignment();
    }
}
