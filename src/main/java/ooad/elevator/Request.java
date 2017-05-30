package ooad.elevator;

import java.sql.Timestamp;

/**
 * Created by PV029500 on 4/23/2017.
 */
public class Request {
    Car car;
    Floor source;
    Floor destination;
    boolean isRequestComplete;
    Timestamp timestamp;

    public Request(Floor source, Floor destination, boolean isRequestComplete, Timestamp timestamp) {
        this.source = source;
        this.destination = destination;
        this.isRequestComplete = isRequestComplete;
        this.timestamp = timestamp;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Floor getSource() {
        return source;
    }

    public void setSource(Floor source) {
        this.source = source;
    }

    public Floor getDestination() {
        return destination;
    }

    public void setDestination(Floor destination) {
        this.destination = destination;
    }

    public boolean isRequestComplete() {
        return isRequestComplete;
    }

    public void setRequestComplete(boolean requestComplete) {
        isRequestComplete = requestComplete;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
