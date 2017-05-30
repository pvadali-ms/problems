package ooad.elevator;

/**
 * Created by PV029500 on 4/23/2017.
 */
public class RequestProcessor extends Thread {

    Request request;

    RequestProcessor(Request request) {
        this.request = request;
    }

    void startElevator(Request request) throws InterruptedException {
        while (request.getCar().currentFloor != request.getDestination()) {
            Thread.sleep(10);
            request.getCar().currentFloor.floorNumber += 1;
        }
        stopElevator();
    }

    void stopElevator() {
        this.interrupt();
    }

    @Override
    public void run(){
        try {
            startElevator(request);
        } catch (InterruptedException e) {

        }
    }
}
