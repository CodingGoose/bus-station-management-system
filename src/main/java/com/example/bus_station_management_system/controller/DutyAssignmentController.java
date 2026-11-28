package com.example.bus_station_management_system.controller;

import com.example.bus_station_management_system.model.DutyAssignment;
import com.example.bus_station_management_system.service.BusTripService;
import com.example.bus_station_management_system.service.DutyAssignmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/duty-assignment")
public class DutyAssignmentController extends BaseController<DutyAssignment> {

    private final BusTripService tripService;
    private final DutyAssignmentService dutyAssignmentService;

    public DutyAssignmentController(DutyAssignmentService service, BusTripService tripService) {
        super(service, "duty-assignment", "dutyAssignment",  "dutyAssignments");
        this.dutyAssignmentService = service;
        this.tripService = tripService;
    }

    @Override
    protected DutyAssignment createEmptyEntity() {
        return new DutyAssignment();
    }

    @Override
    protected void addReferenceData(Model model) {
        model.addAttribute("tripLabels", tripService.labels());
        model.addAttribute("staffLabels", dutyAssignmentService.staffLabels());
    }
}
