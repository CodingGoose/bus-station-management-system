package com.example.bus_station_management_system.controller;

import com.example.bus_station_management_system.model.TripManager;
import com.example.bus_station_management_system.service.BusTripService;
import com.example.bus_station_management_system.service.DutyAssignmentService;
import com.example.bus_station_management_system.service.TripManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trip-manager")
public class TripManagerController extends BaseController<TripManager> {

    private final DutyAssignmentService dutyAssignmentService;
    private final BusTripService busTripService;

    public TripManagerController(TripManagerService service, DutyAssignmentService dutyAssignmentService,
                                 BusTripService busTripService) {
        super(service, "trip-manager", "tripManager",  "tripManagers");
        this.dutyAssignmentService = dutyAssignmentService;
        this.busTripService = busTripService;
    }

    @Override
    protected TripManager createEmptyEntity() {
        return new TripManager();
    }

    @Override
    protected void addDetailsData(String id, Model model) {
        model.addAttribute("assignments", dutyAssignmentService.findByStaffId(id));
        model.addAttribute("tripLabels", busTripService.labels());
    }
}
