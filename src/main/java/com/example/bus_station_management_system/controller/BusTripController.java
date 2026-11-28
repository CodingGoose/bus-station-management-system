package com.example.bus_station_management_system.controller;
import com.example.bus_station_management_system.model.BusTrip;
import com.example.bus_station_management_system.service.BusService;
import com.example.bus_station_management_system.service.BusTripService;
import com.example.bus_station_management_system.service.DutyAssignmentService;
import com.example.bus_station_management_system.service.PassengerService;
import com.example.bus_station_management_system.service.RouteService;
import com.example.bus_station_management_system.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bus-trip")
public class BusTripController extends BaseController<BusTrip> {

    private final RouteService routeService;
    private final BusService busService;
    private final TicketService ticketService;
    private final PassengerService passengerService;
    private final DutyAssignmentService dutyAssignmentService;

    public BusTripController(BusTripService service, RouteService routeService, BusService busService,
                             TicketService ticketService, PassengerService passengerService,
                             DutyAssignmentService dutyAssignmentService) {
        super(service, "bus-trip", "busTrip", "busTrips");
        this.routeService = routeService;
        this.busService = busService;
        this.ticketService = ticketService;
        this.passengerService = passengerService;
        this.dutyAssignmentService = dutyAssignmentService;
    }

    @Override
    protected BusTrip createEmptyEntity() {
        return new BusTrip();
    }

    @Override
    protected void addReferenceData(Model model) {
        model.addAttribute("routeLabels", routeService.labels());
        model.addAttribute("busLabels", busService.labels());
    }

    @Override
    protected void addDetailsData(String id, Model model) {
        model.addAttribute("tickets", ticketService.findByTripId(id));
        model.addAttribute("passengerLabels", passengerService.labels());
        model.addAttribute("assignments", dutyAssignmentService.findByTripId(id));
        model.addAttribute("staffLabels", dutyAssignmentService.staffLabels());
    }
}
