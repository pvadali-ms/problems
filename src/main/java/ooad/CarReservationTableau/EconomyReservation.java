package ooad.CarReservationTableau;

import java.util.Date;

/**
 * Created by PV029500 on 4/9/2017.
 */
public class EconomyReservation extends Reservation {

    @Override
    public double calculatePrice(Date fromDate, Date toDate, CarType carType) {
        return 0;
    }
}
