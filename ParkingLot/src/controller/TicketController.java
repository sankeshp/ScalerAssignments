package controller;

import dto.InvoiceRequestObject;
import dto.TicketRequestObject;
import models.*;
import service.InvoiceService;
import service.TicketService;

public class TicketController {

    TicketService ticketService;

    public TicketController(TicketService ticketService)
    {
        this.ticketService = ticketService;
    }
    public Ticket createTicket(TicketRequestObject ticketRequestObject) throws Exception {
        Ticket ticket= ticketService.createTicket(ticketRequestObject.getVehicle(),ticketRequestObject.getEntryGate());
        return ticket;
    }
}
