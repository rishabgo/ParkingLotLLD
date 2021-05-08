package SystemDesign.ParkingLot;

import SystemDesign.ParkingLot.entity.ParkingSlotType;
import SystemDesign.ParkingLot.entity.Vehicle;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ParkingSlot {

    String parkingSlotId;
    Vehicle vehicle;
    ParkingSlotType parkingSlotType;
    Boolean isAvailable;

    public ParkingSlot(String slotId, ParkingSlotType parkingSlotType) {
        this.parkingSlotId = slotId;
        this.parkingSlotType = parkingSlotType;
        this.isAvailable = true;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isAvailable = false;
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicle = null;
        this.isAvailable = true;
    }

}
