package SystemDesign.ParkingLot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    String vehicleId;
    Long entryTime;
    VehicleType vehicleType;

}
