package service;

import models.*;

import java.util.Date;

public class InvoiceService {

    ParkingSlotService parkingSlotService = new ParkingSlotService();

    public Invoice createInvoice(Ticket ticket, Gate exitGate) {

        Date entryTime = ticket.getEntryTime();
        long start_millis = entryTime.getTime();

        Date exitTime = new Date();
        long end_millis = exitTime.getTime();
        double amount = (end_millis-start_millis)*10;

        Payment payment = Payment.builder().paymentId(1111).paymentMode(PaymentMode.Cash)
                .amount(amount).build();

        Invoice invoice = Invoice.builder().invoiceId(121).exitGate(exitGate).exitTime(exitTime)
                .ticket(ticket).payment(payment).build();

        parkingSlotService.setParkingSlot(ticket.getParkingSlot(),Status.Avaialble);

        return invoice;
    }
}
