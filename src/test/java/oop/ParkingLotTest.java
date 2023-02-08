package oop;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class ParkingLotTest {

    private ParkingLot parkingLot1;
    private ParkingLot parkingLot2;
    private ArrayList<ParkingLot> parkingLots;

    @BeforeEach
    public void init() {
        parkingLots = new ArrayList<>();

        parkingLot1 = new ParkingLot();
        parkingLots.add(parkingLot1);

        parkingLot2 = new ParkingLot();
        parkingLots.add(parkingLot2);
    }

    @Test
    public void itShouldParkACar() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);
        Car car = new Car("random8109");

        parkingAssistant.executeCarParking(car);

        assertEquals(parkingLot1.getNumberOfCars(), 1);
    }

    @Test
    public void itShouldRetrieveACar() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);
        Car car = new Car("random8109");
        parkingAssistant.executeCarParking(car);

        Car actualCar = parkingAssistant.executeRetrieveCarByNumber("random8109");

        assertEquals(actualCar.getCarNumber(), "random8109");
    }

    @Test
    public void itShouldParkingToAFirstFreeParkingLot() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);
        Car car = new Car("random8109");

        parkingAssistant.executeCarParking(car);

        assertEquals(parkingLot1.getNumberOfCars(), 1);
        assertEquals(parkingLot2.getNumberOfCars(), 0);
    }

    @Test
    public void itShouldBeEnoughCapacity() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);

        for (int numberOfCar = 1; numberOfCar <= 7; numberOfCar++) {
            parkingAssistant.executeCarParking(new Car("" + numberOfCar));
        }

        assertEquals(parkingLot1.haveEnoughCapacity(), true);

    }

    @Test
    public void itShouldNotBeEnoughCapacity() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);

        for (int numberOfCar = 1; numberOfCar <= 8; numberOfCar++) {
            parkingAssistant.executeCarParking(new Car("" + numberOfCar));
        }

        assertEquals(parkingLot1.haveEnoughCapacity(), false);

    }

    @Test
    public void itShouldParkingToSecondFreeParkingLot() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);
        for (int numberOfCar = 1; numberOfCar <= 8; numberOfCar++) {
            parkingAssistant.executeCarParking(new Car("" + numberOfCar));
        }

        Car car = new Car("random8109");

        parkingAssistant.executeCarParking(car);

        assertEquals(parkingLot1.getNumberOfCars(), 8);
        assertEquals(parkingLot2.getNumberOfCars(), 1);
    }
}