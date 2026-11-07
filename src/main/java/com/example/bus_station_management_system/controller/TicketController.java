package com.example.bus_station_management_system.controller;

import com.example.bus_station_management_system.model.Ticket;
import com.example.bus_station_management_system.service.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tickets")
public class TicketController extends BaseController<Ticket, String> {
    public TicketController(TicketService service) {
        super(service, "ticket", "tickets");
    }

    @Override
    protected Ticket createEmptyEntity() {
        return new Ticket();
    }
}