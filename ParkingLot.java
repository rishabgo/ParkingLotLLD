package SystemDesign.ParkingLot;

import SystemDesign.ParkingLot.entity.Vehicle;
import SystemDesign.ParkingLot.entity.VehicleType;
import SystemDesign.ParkingLot.exception.ParkingSlotNotFoundException;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class ParkingLot {

    private static final Logger logger = Logger.getLogger("ParkingLot");

    ConcurrentHashMap<VehicleType, List<ParkingSlot>> slots;

    public ParkingLot(ConcurrentHashMap slots) {
        this.slots = slots;
    }

    // calculate Parking fees
    public Double payAndExit(Vehicle vehicle) {

        long diff = (System.currentTimeMillis() - vehicle.getEntryTime()) /1000;

        Double totalAmount = vehicle.getVehicleType().getPriceForParking(diff);

        logger.info("Parking amount is " + totalAmount + "euros " + " Parking time in seconds :" + diff);
        return totalAmount;
    }

    //check if parking is available
    public boolean checkAvailability(Vehicle vehicle) {

        VehicleType vehicleType = vehicle.getVehicleType();
        List<ParkingSlot> parkingSlotList = slots.get(vehicleType);
        return parkingSlotList.stream().anyMatch(slot -> slot.getIsAvailable());
    }

    public ParkingSlot getAvailableSlot(Vehicle vehicle) {

        ParkingSlot parkingSlot = slots.get(vehicle.getVehicleType()).stream()
                .filter(ParkingSlot::getIsAvailable)
                .findAny()
                .orElseThrow(() -> new ParkingSlotNotFoundException("No Parking slot available"));
        logger.info("Parking slot id " + parkingSlot.getParkingSlotId() + " is available");
        return parkingSlot;
    }

    //get parking slot and park vehicle
    public void parkVehicle(Vehicle vehicle) {

        if (checkAvailability(vehicle)) {
            ParkingSlot parkingSlot = getAvailableSlot(vehicle);
            parkingSlot.parkVehicle(vehicle);
            vehicle.setEntryTime(System.currentTimeMillis());
            logger.info("Vehicle " + vehicle.getVehicleId() + " parked");
        } else throw new ParkingSlotNotFoundException("No Parking available");


    }
}
