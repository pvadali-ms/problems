package ooad.parkingLot;

/**
 * Created by PV029500 on 4/23/2017.
 */
public enum VehicleType {

    MOTORCYCLE(1), MINIVAN(2), CAR(2);

    int numOfSpots;

    VehicleType(int numOfSpots) {
        this.numOfSpots = numOfSpots;
    }
}
