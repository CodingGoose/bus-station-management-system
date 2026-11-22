package com.example.bus_station_management_system.controller;

import com.example.bus_station_management_system.model.DutyAssignment;
import com.example.bus_station_management_system.service.BusTripService;
import com.example.bus_station_management_system.service.DriverService;
import com.example.bus_station_management_system.service.DutyAssignmentService;
import com.example.bus_station_management_system.service.TripManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/duty-assignment")
public class DutyAssignmentController extends BaseController<DutyAssignment> {

    private final BusTripService tripService;
    private final DriverService driverService;
    private final TripManagerService tripManagerService;

    public DutyAssignmentController(DutyAssignmentService service, BusTripService tripService,
                                    DriverService driverService, TripManagerService tripManagerService) {
        super(service, "duty-assignment", "dutyAssignment",  "dutyAssignments");
        this.tripService = tripService;
        this.driverService = driverService;
        this.tripManagerService = tripManagerService;
    }

    @Override
    protected DutyAssignment createEmptyEntity() {
        return new DutyAssignment();
    }

    @Override
    protected void addReferenceData(Model model) {
        model.addAttribute("tripLabels", tripService.labels());

        // Staff can be a driver or a trip manager, so both go into one dropdown.
        Map<String, String> staffLabels = new LinkedHashMap<>();
        driverService.labels().forEach((id, name) -> staffLabels.put(id, name + " (Driver)"));
        tripManagerService.labels().forEach((id, name) -> staffLabels.put(id, name + " (Trip manager)"));
        model.addAttribute("staffLabels", staffLabels);
    }
}
