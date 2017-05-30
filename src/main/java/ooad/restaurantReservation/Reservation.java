package ooad.restaurantReservation;

import java.util.Date;
import java.util.List;

/**
 * Created by PV029500 on 4/17/2017.
 */
public class Reservation {

    long id;
    List<Table> tables;
    Customer customer;
    Date startTime;
    Date endTime;
    Status status;
}
