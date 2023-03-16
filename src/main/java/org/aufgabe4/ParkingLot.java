package org.aufgabe4;
import java.util.concurrent.Semaphore;

public class ParkingLot {
    private int[] capacity;
    private Semaphore[] spaces;

    public ParkingLot(int[] capacity) {
        this.capacity = capacity;
        this.spaces = new Semaphore[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            this.spaces[i] = new Semaphore(1);
        }
    }

    public void enter(int carId) {
        boolean parked = false;
        int i = 0;
        while (!parked && i < capacity.length) {
            System.out.println("Car " + carId + " is trying to park.");
            if (capacity[i] == -1 && spaces[i].tryAcquire()) {
                capacity[i] = carId;
                System.out.println("Car " + carId + " has parked in space " + i + ".");
                parked = true;
            } else {
                i++;
            }
        }
        if (!parked) {
            System.out.println("Car " + carId + " could not find a space to park.");
        }
    }

    public void exit(int carId) {
        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] == carId) {
                System.out.println("Car " + carId + " is leaving space " + i + ".");
                capacity[i] = -1;
                spaces[i].release();
            }
        }
    }
}