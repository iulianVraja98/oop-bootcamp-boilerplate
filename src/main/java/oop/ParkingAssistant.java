package oop;

import java.util.ArrayList;

public class ParkingAssistant {
    private ArrayList<ParkingLot> parkingLotList;

    public ParkingAssistant(ArrayList<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public void executeCarParking(Car car) {
        for (ParkingLot parkingLot : parkingLotList ) {
            parkingLot.parkTheCar(car);
            break;
        }
    }

    public Car executeRetrieveCarByNumber(String carNumber) {
        for (ParkingLot parkingLot : parkingLotList ) {
            return parkingLot.retrieveTheCarByNumber(carNumber);
        }

        return null;
    }
}
