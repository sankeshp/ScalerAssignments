package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Builder
public class ParkingSlot {
    private int slotId;
    private VehicleType supportedVehicleType;
    private Status status;
    private ParkingFloor parkingFloor;
}
