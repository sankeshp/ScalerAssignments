package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ParkingLot {
    private String name;
    private String address;
    private List<ParkingFloor> parkingFloorList;
    private List<Gate> entryGateList;
    private List<Gate> exitGateList;
}
