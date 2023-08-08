package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import models.Gate;
import models.Vehicle;

import java.util.Date;

@Builder
@Setter
@Getter
public class TicketRequestObject {
    private Gate entryGate;
    private Vehicle vehicle;
}
