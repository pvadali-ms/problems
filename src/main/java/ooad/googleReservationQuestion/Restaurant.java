package ooad.googleReservationQuestion;

import org.joda.time.LocalTime;

import javax.xml.datatype.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by PV029500 on 4/17/2017.
 */
public class Restaurant {

    public Map<Integer, Duration> reservationDurationsPerPartySize;
    private List<Table> tables;
    private LocalTime openTime;
    private LocalTime closeTime;

    // Returns a Table if Reservation could be booked, null otherwise
    // Booking rules:
    // 1) Reservation could be made only when the Restaurant is open.
    // 2) Only one Reservation can be seated a Table at any time.
    // 3) Reservation can be seatted only at a Table of the same or a bigger size.
    // 4) Reservation should stay on the same Table for the whole Duration.
    // 5) Reservation Duration is determined by PartySize.
    private Restaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.tables = new ArrayList<Table>(10);
        restaurant.openTime = new LocalTime();
        restaurant.closeTime = new LocalTime();
    }

    public Table bookReservation(Reservation reservation) {
        //fill this method
        Table table = getNextTable();
        if (table != null) {
            if (this.openTime.isBefore(reservation.startTime) && this.closeTime.isAfter(reservation.endTime)) {
                int numOfTables = (int) Math.ceil(reservation.partySize / table.maxPartySize);
                while (numOfTables-- > 0) {
                    tables.remove(0);
                }
                return table;
            }
        }
        return null;
    }


    private Table getNextTable() {
        return tables.size() > 0 ? tables.get(0) : null;
    }
}
