package ooad.CarReservationTableau;

/**
 * Created by PV029500 on 4/9/2017.
 */
public class ReservationWaitMonitor {

    public void checkWaitlist() {
        if (ProcessReservation.waitListed.get(0).fromDate.getTime() < System.currentTimeMillis() + 4 * 60 * 60 * 1000) {
            ProcessReservation.waitListed.remove(0);
        }
    }

}
