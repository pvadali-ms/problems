package ooad.elevator;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by PV029500 on 4/23/2017.
 */
public class ElevatorManagementSystem {

    List<Car> cars = new ArrayList<Car>();
    Queue<Request> requests = new LinkedList<Request>();

    public void callElevator(Floor source, Floor destination) {
        Request request = new Request(source, destination, false, new Timestamp(System.currentTimeMillis()));
        requests.add(request);
        Car car = getNextElevator(request);
        request.setCar(car);
        RequestProcessor requestProcessor = new RequestProcessor(request);
    }

    private Car getNextElevator(Request request) {
        for (Car car : cars) {
            if (!car.isProcessing) {
                car.isProcessing = true;
                return car;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ElevatorManagementSystem elevatorManagementSystem = new ElevatorManagementSystem();
        while (elevatorManagementSystem.requests.size() > 0) {
            elevatorManagementSystem.callElevator(new Floor(), new Floor());
        }
    }

}
