package oop;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

        parkingAssistant.parkCar(car);

        assertEquals(parkingLot1.getNumberOfCars(), 1);
    }

    @Test
    public void itShouldRetrieveACar() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);
        Car car = new Car("random8109");
        parkingAssistant.parkCar(car);

        Car actualCar = parkingAssistant.executeRetrieveCarByNumber("random8109");

        assertEquals(actualCar.getCarNumber(), "random8109");
    }

    @Test
    public void itShouldParkingToAFirstFreeParkingLot() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);
        Car car = new Car("random8109");

        parkingAssistant.parkCar(car);

        assertEquals(parkingLot1.getNumberOfCars(), 1);
        assertEquals(parkingLot2.getNumberOfCars(), 0);
    }

    @Test
    public void itShouldBeEnoughCapacity() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);

        for (int numberOfCar = 1; numberOfCar <= 7; numberOfCar++) {
            parkingAssistant.parkCar(new Car("" + numberOfCar));
        }

        assertEquals(parkingLot1.haveEnoughCapacity(), true);

    }

    @Test
    public void itShouldNotBeEnoughCapacity() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);

        for (int numberOfCar = 1; numberOfCar <= 8; numberOfCar++) {
            parkingAssistant.parkCar(new Car("" + numberOfCar));
        }

        assertEquals(parkingLot1.haveEnoughCapacity(), false);

    }

    @Test
    public void itShouldParkingToSecondFreeParkingLot() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);
        for (int numberOfCar = 1; numberOfCar <= 8; numberOfCar++) {
            parkingAssistant.parkCar(new Car("" + numberOfCar));
        }

        Car car = new Car("random8109");

        parkingAssistant.parkCar(car);

        assertEquals(parkingLot1.getNumberOfCars(), 8);
        assertEquals(parkingLot2.getNumberOfCars(), 1);
    }

    @Test
    public void itShouldShowMessage() {

        ParkingLot observable = new ParkingLot();
        ParkingLotObserver observer = new ParkingLotObserver();
        observable.addPropertyChangeListener(observer);

        for (int numberOfCar = 1; numberOfCar <= 8; numberOfCar++) {
            observable.park(new Car("" + numberOfCar));
        }

        assertEquals(observer.getNews(), "Buy more land!");

        for (int numberOfCar = 1; numberOfCar <= 7; numberOfCar++) {
            observable.retrieveTheCarBy("" + numberOfCar);
        }

        assertEquals(observer.getNews(), "Close down some parking slots");
    }

    @Test
    public void itShouldParkLargeCarInParkingLotWithLeastUsage() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);
        Car car = new Car("1");
        Car car1 = new Car("1");
        parkingLot1.park(car);
        parkingLot1.park(car1);

        Car car2 = new Car("1");
        parkingLot2.park(car2);


        parkingAssistant.parkCar(new Car("1", true));

        assertEquals(parkingLot2.getNumberOfCars(), 2);
    }

    @Test
    public void itShouldParkHandicappedCarInFirstParkingLotThatAcceptIt() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);
        Car car = new Car("1");
        Car car1 = new Car("1");
        parkingLot1.park(car);
        parkingLot1.park(car1);

        Car car2 = new Car("1");
        parkingLot2.park(car2);


        parkingLot1.setAcceptingHandicappedCars(false);
        parkingLot2.setAcceptingHandicappedCars(true);

        parkingAssistant.parkCar(new Car("1", false, true));

        assertEquals(parkingLot2.getNumberOfCars(), 2);
    }

    @Test
    public void itShouldNotParkFancyCarsIfAssistantIsNotCertified() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);
        parkingAssistant.setCertified(false);
        Car car = new Car("1", false, false, true);
        parkingAssistant.parkCar(car);

        assertEquals(parkingLot1.getNumberOfCars(), 0);
        assertEquals(parkingLot2.getNumberOfCars(), 0);
    }

    @Test
    public void itShouldParkFancyCarsIfAssistantIsCertified() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);
        parkingAssistant.setCertified(true);
        Car car = new Car("1", false, false, true);
        parkingAssistant.parkCar(car);

        assertEquals(parkingLot1.getNumberOfCars(), 1);
        assertEquals(parkingLot2.getNumberOfCars(), 0);
    }

    @Test
    public void itShouldDelegateParkingLotsToAnotherAssistants() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);

        ParkingAssistant assistant = parkingAssistant.hireAssistant(List.of(parkingLot1));

        Car car = new Car("1", false, false, false);

        assistant.parkCar(car);
        assertEquals(parkingLot1.getNumberOfCars(), 1);
        assertEquals(parkingLot2.getNumberOfCars(), 0);

        Car car2 = new Car("2", false, false, false);
        parkingAssistant.parkCar(car2);
        assertEquals(parkingLot2.getNumberOfCars(), 1);
    }


}