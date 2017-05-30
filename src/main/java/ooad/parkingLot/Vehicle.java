package ooad.parkingLot;

/**
 * Created by PV029500 on 4/23/2017.
 */
public class Vehicle {

    Long id;
    VehicleType vehicleType;
    SlotType slotType;
    Slot parkedSlot;

    public Vehicle(Long id, VehicleType vehicleType, SlotType slotType) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.slotType = slotType;
    }
}
