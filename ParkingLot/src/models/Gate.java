package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder@Setter@Getter
public class Gate {
    private int gateId;
    private ParkingAttendant parkingAttendant;
    private GateType gateType;
}
