package oop;

import java.util.ArrayList;
import java.util.List;

public class ParkingAssistant {
    private List<ParkingLot> parkingLotList;

    private List<ParkingAssistant> parkingAssistantList = new ArrayList<>();
    private boolean certified = false;

    public ParkingAssistant(List<ParkingLot> parkingLotList) {
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

    public ParkingAssistant hireAssistant(List<ParkingLot> parkingLot1) {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLot1);
        for (ParkingLot parkingLot : parkingLot1) {
            for (ParkingLot parkingLotAssistant : parkingLotList) {
                if (parkingLot.getId() == parkingLotAssistant.getId()) {
                    parkingLotList.remove(parkingLotAssistant);
                }
            }
        }
        parkingAssistantList.add(parkingAssistant);
        return parkingAssistant;
    }
}