package ooad.parkingLot;

/**
 * Created by PV029500 on 4/23/2017.
 */
public class Slot {

    Long id;
    SlotType slotType;
    boolean isVacant;

    public Slot(Long id, SlotType slotType, boolean isVacant) {
        this.id = id;
        this.slotType = slotType;
        this.isVacant = isVacant;
    }
}
