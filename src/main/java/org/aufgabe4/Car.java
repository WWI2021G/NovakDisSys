package org.aufgabe4;




public class Car extends Thread {
    private int carId;
    private ParkingLot parkingLot;

    public Car(int carId, ParkingLot parkingLot) {
        this.carId = carId;
        this.parkingLot = parkingLot;
    }

    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 10000));
            parkingLot.enter(carId);
            Thread.sleep((int) (Math.random() * 10000));
            parkingLot.exit(carId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}