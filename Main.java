package SystemDesign.ParkingLot;

import SystemDesign.ParkingLot.entity.ParkingSlotType;
import SystemDesign.ParkingLot.entity.Vehicle;
import SystemDesign.ParkingLot.entity.VehicleType;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {

        ConcurrentHashMap<VehicleType, List<ParkingSlot>> parkingSlots = new ConcurrentHashMap<>();
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleType(VehicleType.FOUR_WHEELER);
        vehicle.setVehicleId("KA-01-MA-9999");
        List<ParkingSlot> fourWheelerSlotList = Arrays.asList(new ParkingSlot("A1", ParkingSlotType.FOURWHEELER),
                new ParkingSlot("A2", ParkingSlotType.FOURWHEELER),new ParkingSlot("A3", ParkingSlotType.FOURWHEELER)
        );
        List<ParkingSlot> twoWheelerSlotList = Arrays.asList(new ParkingSlot("B1", ParkingSlotType.TWOWHEELER),
                new ParkingSlot("B2", ParkingSlotType.TWOWHEELER)
        );

        parkingSlots.put(VehicleType.FOUR_WHEELER, fourWheelerSlotList);
        parkingSlots.put(VehicleType.TWO_WHEELER, twoWheelerSlotList);

        ParkingLot parkingLot = new ParkingLot(parkingSlots);
        parkingLot.parkVehicle(vehicle);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        parkingLot.payAndExit(vehicle);
    }

}
