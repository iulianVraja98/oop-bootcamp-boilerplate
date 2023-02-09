package oop;

import java.util.ArrayList;

public class ParkingAssistant {
    private ArrayList<ParkingLot> parkingLotList;

    public ParkingAssistant(ArrayList<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public void executeCarParking(Car car) {

        if (car.getSize().equals("small")) {
            for (ParkingLot parkingLot : parkingLotList) {
                if (!car.isHandicapped()) {
                    if (parkingLot.park(car)) {
                        break;
                    }
                } else {
                    if (parkingLot.getAcceptingHandicappedCars()) {
                        if (parkingLot.park(car)) {
                            break;
                        }
                    }
                }
            }
        } else {
            ParkingLot minParkingLot = minOf(parkingLotList.get(0), parkingLotList.get(1));
            for (ParkingLot parkingLot : parkingLotList) {
                if (!car.isHandicapped()) {
                    minParkingLot = minOf(minParkingLot, parkingLot);
                } else {
                    if (minOf(minParkingLot, parkingLot).getAcceptingHandicappedCars()) {
                        minParkingLot = minOf(minParkingLot, parkingLot);
                    }
                }
            }
            minParkingLot.park(car);
        }
    }

    public ParkingLot minOf(ParkingLot parkingLot1, ParkingLot parkingLot2) {
        if (parkingLot1.getNumberOfCars() > parkingLot2.getNumberOfCars()) {
            return parkingLot2;
        }
        return parkingLot1;

    }

    public Car executeRetrieveCarByNumber(String carNumber) {
        for (ParkingLot parkingLot : parkingLotList) {
            return parkingLot.retrieveTheCarBy(carNumber);
        }

        return null;
    }
}