package oop;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ParkingLotTest {

    @Test
    public void itShouldParkACar() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("random8109");
        parkingLot.parkTheCar(car);

        assertEquals(parkingLot.getNumberOfCars(), 1);
    }

    @Test
    public void itShouldRetrieveACar() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car("random8109");
        parkingLot.parkTheCar(car);

        Car actualCar = parkingLot.retrieveTheCarByNumber("random8109");

        assertEquals(parkingLot.getNumberOfCars(), 0);
        assertEquals(actualCar.getCarNumber(), "random8109");
    }

}
