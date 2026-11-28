package com.example.bus_station_management_system.controller;

import com.example.bus_station_management_system.model.Driver;
import com.example.bus_station_management_system.service.BusTripService;
import com.example.bus_station_management_system.service.DriverService;
import com.example.bus_station_management_system.service.DutyAssignmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/driver")
public class DriverController extends BaseController<Driver> {

    private final DutyAssignmentService dutyAssignmentService;
    private final BusTripService busTripService;

    public DriverController(DriverService service, DutyAssignmentService dutyAssignmentService,
                            BusTripService busTripService) {
        super(service, "driver", "driver",  "drivers");
        this.dutyAssignmentService = dutyAssignmentService;
        this.busTripService = busTripService;
    }

    @Override
    protected Driver createEmptyEntity() {
        return new Driver();
    }

    @Override
    protected void addDetailsData(String id, Model model) {
        model.addAttribute("assignments", dutyAssignmentService.findByStaffId(id));
        model.addAttribute("tripLabels", busTripService.labels());
    }
}
