package service;

import models.*;
import repository.ParkingLotRepository;

public class ParkingSlotService {
    ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
    public ParkingSlot findAvailableParkingSlot(Vehicle vehicle) {
        ParkingLot parkingLot = parkingLotRepository.getParkingLot();

        for(ParkingFloor parkingFloor : parkingLot.getParkingFloorList())
        {
            for(ParkingSlot parkingSlot : parkingFloor.getParkingSlotList())
            {
                if(parkingSlot.getStatus().equals(Status.Avaialble) &&
                parkingSlot.getSupportedVehicleType().equals(vehicle.getVehicleType()))
                    return parkingSlot;
            }
        }

        return null;
    }

    public void setParkingSlot(ParkingSlot parkingSlot , Status status) {
        parkingSlot.setStatus(status);
    }
}
