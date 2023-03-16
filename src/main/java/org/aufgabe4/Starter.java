package org.aufgabe4;

public class Starter {

        public static void main(String[] args) {
            int numCars = 25;
            int[] capacity = new int[10];
            for (int i = 0; i < capacity.length; i++) {
                capacity[i] = -1;
            }
            ParkingLot parkingLot = new ParkingLot(capacity);

            for (int i = 1; i <= numCars; i++) {
                Car car = new Car(i, parkingLot);
                car.start();
            }
        }

}
