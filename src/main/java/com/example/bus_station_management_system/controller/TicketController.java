package com.example.bus_station_management_system.controller;

import com.example.bus_station_management_system.model.Ticket;
import com.example.bus_station_management_system.service.BusTripService;
import com.example.bus_station_management_system.service.PassengerService;
import com.example.bus_station_management_system.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ticket")
public class TicketController extends BaseController<Ticket> {

    private final BusTripService tripService;
    private final PassengerService passengerService;

    public TicketController(TicketService service, BusTripService tripService, PassengerService passengerService) {
        super(service, "ticket", "ticket",  "tickets");
        this.tripService = tripService;
        this.passengerService = passengerService;
    }

    @Override
    protected Ticket createEmptyEntity() {
        return new Ticket();
    }

    @Override
    protected void addReferenceData(Model model) {
        model.addAttribute("tripLabels", tripService.labels());
        model.addAttribute("passengerLabels", passengerService.labels());
    }
}
