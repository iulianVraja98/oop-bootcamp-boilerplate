package oop;

import java.util.ArrayList;

public class ParkingAssistant {
    private ArrayList<ParkingLot> parkingLotList;
    private CarParkingStrategy carParking;
    private boolean certified = false;

    public ParkingAssistant(ArrayList<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public void parkCar(Car car) {
        if (!car.isFancy() || this.certified) {
            CarParkingStrategy carParkingStrategy = car.chooseCarParkingStrategy();
            carParkingStrategy.park(car, parkingLotList);
        }
    }

    public Car executeRetrieveCarByNumber(String carNumber) {
        for (ParkingLot parkingLot : parkingLotList) {
            return parkingLot.retrieveTheCarBy(carNumber);
        }

        return null;
    }

    public void setCertified(boolean certified) {
        this.certified = certified;
    }
}