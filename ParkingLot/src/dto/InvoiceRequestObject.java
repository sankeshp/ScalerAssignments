package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.Gate;
import models.Payment;
import models.Ticket;

import java.util.Date;

@Builder
@Setter
@Getter
public class InvoiceRequestObject {
    private Ticket ticket;
    private Gate exitGate;
}
