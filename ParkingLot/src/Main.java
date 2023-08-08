import controller.InvoiceController;
import controller.TicketController;
import dto.InvoiceRequestObject;
import dto.TicketRequestObject;
import models.*;
import service.InvoiceService;
import service.TicketService;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world! Welcome to car parking lot");

        ParkingAttendant parkingAttendant1 = ParkingAttendant.builder().attendantId(1)
                .name("attendant1").build();
        Gate gate1 = Gate.builder().gateId(1).gateType(GateType.Entry)
                .parkingAttendant(parkingAttendant1).build();

        TicketService ticketService = new TicketService();
        TicketController ticketController = new TicketController(ticketService);

        Vehicle vehicle = Vehicle.builder().licenceNo(111).vehicleType(VehicleType.Car).build();
        TicketRequestObject ticketRequestObject = TicketRequestObject.builder().entryGate(gate1)
                .vehicle(vehicle).build();
        Ticket ticket = ticketController.createTicket(ticketRequestObject);

        Vehicle vehicle1 = Vehicle.builder().licenceNo(122).vehicleType(VehicleType.Car).build();
        ticketRequestObject = TicketRequestObject.builder().entryGate(gate1)
                .vehicle(vehicle).build();
        Ticket ticket1 = ticketController.createTicket(ticketRequestObject);

       // System.out.println(ticket1.getTicketId()+" "+ticket1.getParkingSlot().getSlotId()+" "
       // +ticket1.getParkingSlot().getParkingFloor().getFloorId()+" "+ticket1.getEntryTime()+" "+ticket1.getVehicle().getLicenceNo());


        InvoiceService invoiceService = new InvoiceService();
        InvoiceController invoiceController = new InvoiceController(invoiceService);

        Gate gate2 = Gate.builder().gateId(1).gateType(GateType.Exit)
                .parkingAttendant(parkingAttendant1).build();

        InvoiceRequestObject invoiceRequestObject = InvoiceRequestObject.builder().ticket(ticket)
                .exitGate(gate2).build();

        Invoice invoice = invoiceController.createInvoice(invoiceRequestObject);

        System.out.println(invoice.getInvoiceId()+" "+invoice.getPayment().getAmount()+" "
        +invoice.getPayment().getPaymentMode()+" "+invoice.getExitTime());

        System.out.println(ticket.getParkingSlot().getStatus());
        System.out.println(ticket1.getParkingSlot().getStatus());
    }
}