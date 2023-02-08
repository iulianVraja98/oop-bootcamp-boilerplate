package oop;

public class ParkingAssistant {
    private ParkingLot parkingLot;

    public ParkingAssistant(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void executeCarParking(Car car) {
        parkingLot.parkTheCar(car);
    }

    public Car executeRetrieveCarByNumber(String carNumber) {
        return parkingLot.retrieveTheCarByNumber(carNumber);
    }
}
