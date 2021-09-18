package ooad.parkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by PV029500 on 4/23/2017.
 */
public class ParkingLot {

    final UUID id;
    final List<Slot> slots;

    ParkingLot() {
        id = new UUID(1, 2);
        slots = new ArrayList<Slot>();
        for (int i = 0; i < 20; i++) {
            Slot slot = new Slot(1l, SlotType.REGULAR, true);
            slots.add(slot);
        }
    }

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        Vehicle v = null;
        while (v == null || parkingLot.isSpotAvailable()) {
            v = new Vehicle((long) Math.random(), VehicleType.CAR, SlotType.REGULAR);
            parkingLot.parkVehicle(v);
            System.out.println("YES!");
        }
        System.out.println("parking lot filled");
    }

    boolean parkVehicle(Vehicle vehicle) {
        Slot slot = getNextAvailableSlot(vehicle);
        vehicle.parkedSlot = slot;
        return slot != null;
    }

    private Slot getNextAvailableSlot(Vehicle vehicle) {
        int numOfSlotsNeeded = vehicle.vehicleType.numOfSpots;
        int numOfSlotsAvailable = 0;
        for (Slot slot : slots) {
            if (slot.slotType.equals(vehicle.slotType) && slot.isVacant) {
                numOfSlotsAvailable++;
                slot.isVacant = false;
            }
            if (slot.slotType.equals(vehicle.slotType) && numOfSlotsAvailable == numOfSlotsNeeded) {
                return slot;
            }
        }
        return null;
    }

    void removeVehicle(Vehicle vehicle) {
        Slot slot = vehicle.parkedSlot;
        slot.isVacant = true;
    }

    private boolean isSpotAvailable() {
        for (Slot slot : slots)
            if (slot.isVacant)
                return true;
        return false;
    }

}
