package controller;

import dto.InvoiceRequestObject;
import models.Invoice;
import service.InvoiceService;
import service.TicketService;

public class InvoiceController {
    InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService)
    {
        this.invoiceService = invoiceService;
    }

    public Invoice createInvoice(InvoiceRequestObject invoiceRequestObject) {
        Invoice invoice = invoiceService.createInvoice(invoiceRequestObject.getTicket(),invoiceRequestObject.getExitGate());
        return  invoice;
    }
}
