package oop;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class ParkingLotTest {

    private ParkingLot parkingLot1;
    private ParkingLot parkingLot2;
    private ArrayList<ParkingLot> parkingLots;
    @BeforeTest
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
}