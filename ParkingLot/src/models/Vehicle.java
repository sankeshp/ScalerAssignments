package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Vehicle {
    private int licenceNo;
    private VehicleType vehicleType;
}
