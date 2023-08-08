package service;

import models.*;

import java.util.Date;

public class TicketService {
    ParkingSlotService parkingSlotService = new ParkingSlotService();
    public Ticket createTicket(Vehicle vehicle, Gate gate) throws Exception {
        ParkingSlot parkingSlot = parkingSlotService.findAvailableParkingSlot(vehicle);

        if(parkingSlot == null)
        {
            throw new Exception("parkingSlot not found");
        }

        Ticket ticket = Ticket.builder().ticketId(1).entryGate(gate).entryTime(new Date())
                .vehicle(vehicle).parkingSlot(parkingSlot).build();

        parkingSlotService.setParkingSlot(parkingSlot, Status.Occupied);

        return ticket;
    }
}
