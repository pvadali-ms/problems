package ooad.CarReservationTableau;

import ooad.amazonfresh.User;

import java.util.Date;

/**
 * Created by PV029500 on 4/9/2017.
 */
class Reservation {
    Long id;
    CarType carType;
    User user;
    Date fromDate;
    Date toDate;
    Double price;
    Status status;

    double calculatePrice(Date fromDate, Date toDate, CarType carType) {
        return 0;
    }

}
