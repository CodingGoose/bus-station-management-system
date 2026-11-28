package com.example.bus_station_management_system.controller;

import com.example.bus_station_management_system.model.Passenger;
import com.example.bus_station_management_system.service.BusTripService;
import com.example.bus_station_management_system.service.PassengerService;
import com.example.bus_station_management_system.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/passenger")
public class PassengerController extends BaseController<Passenger> {

    private final TicketService ticketService;
    private final BusTripService busTripService;

    public PassengerController(PassengerService service, TicketService ticketService, BusTripService busTripService) {
        super(service, "passenger", "passenger",  "passengers");
        this.ticketService = ticketService;
        this.busTripService = busTripService;
    }

    @Override
    protected Passenger createEmptyEntity() {
        return new Passenger();
    }

    @Override
    protected void addDetailsData(String id, Model model) {
        model.addAttribute("tickets", ticketService.findByPassengerId(id));
        model.addAttribute("tripLabels", busTripService.labels());
    }
}
