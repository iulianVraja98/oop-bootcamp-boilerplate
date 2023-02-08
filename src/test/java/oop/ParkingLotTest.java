package oop;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ParkingLotTest {

    @Test
    public void itShouldParkACar() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLot);
        Car car = new Car("random8109");

        parkingAssistant.executeCarParking(car);

        assertEquals(parkingLot.getNumberOfCars(), 1);
    }

    @Test
    public void itShouldRetrieveACar() {
        ParkingLot parkingLot = new ParkingLot();
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLot);
        Car car = new Car("random8109");
        parkingAssistant.executeCarParking(car);

        Car actualCar = parkingAssistant.executeRetrieveCarByNumber("random8109");

        assertEquals(parkingLot.getNumberOfCars(), 0);
        assertEquals(actualCar.getCarNumber(), "random8109");
    }

}
