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
        Car car = new Car("random8109", "small");

        parkingAssistant.executeCarParking(car);

        assertEquals(parkingLot1.getNumberOfCars(), 1);
    }

    @Test
    public void itShouldRetrieveACar() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);
        Car car = new Car("random8109", "small");
        parkingAssistant.executeCarParking(car);

        Car actualCar = parkingAssistant.executeRetrieveCarByNumber("random8109");

        assertEquals(actualCar.getCarNumber(), "random8109");
    }

    @Test
    public void itShouldParkingToAFirstFreeParkingLot() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);
        Car car = new Car("random8109", "small");

        parkingAssistant.executeCarParking(car);

        assertEquals(parkingLot1.getNumberOfCars(), 1);
        assertEquals(parkingLot2.getNumberOfCars(), 0);
    }

    @Test
    public void itShouldBeEnoughCapacity() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);

        for (int numberOfCar = 1; numberOfCar <= 7; numberOfCar++) {
            parkingAssistant.executeCarParking(new Car("" + numberOfCar, "small"));
        }

        assertEquals(parkingLot1.haveEnoughCapacity(), true);

    }

    @Test
    public void itShouldNotBeEnoughCapacity() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);

        for (int numberOfCar = 1; numberOfCar <= 8; numberOfCar++) {
            parkingAssistant.executeCarParking(new Car("" + numberOfCar, "small"));
        }

        assertEquals(parkingLot1.haveEnoughCapacity(), false);

    }

    @Test
    public void itShouldParkingToSecondFreeParkingLot() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);
        for (int numberOfCar = 1; numberOfCar <= 8; numberOfCar++) {
            parkingAssistant.executeCarParking(new Car("" + numberOfCar, "small"));
        }

        Car car = new Car("random8109", "small");

        parkingAssistant.executeCarParking(car);

        assertEquals(parkingLot1.getNumberOfCars(), 8);
        assertEquals(parkingLot2.getNumberOfCars(), 1);
    }

    @Test
    public void itShouldShowMessage(){

        ParkingLot observable = new ParkingLot();
        ParkingLotObserver observer = new ParkingLotObserver();
        observable.addPropertyChangeListener(observer);

        for (int numberOfCar = 1; numberOfCar <= 8; numberOfCar++) {
            observable.park(new Car("" + numberOfCar, "small"));
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
        Car car=new Car("1","small");
        Car car1=new Car("1","small");
        parkingLot1.park(car);
        parkingLot1.park(car1);

        Car car2=new Car("1","small");
        parkingLot2.park(car2);


        parkingAssistant.executeCarParking(new Car("1","large"));

        assertEquals(parkingLot2.getNumberOfCars(),2);
    }

    @Test
    public void itShouldParkHandicappedCarInFirstParkingLotThatAcceptIt() {
        ParkingAssistant parkingAssistant = new ParkingAssistant(parkingLots);
        Car car=new Car("1","small");
        Car car1=new Car("1","small");
        parkingLot1.park(car);
        parkingLot1.park(car1);

        Car car2=new Car("1","small");
        parkingLot2.park(car2);


        parkingLot1.setAcceptingHandicappedCars(false);
        parkingLot2.setAcceptingHandicappedCars(true);

        parkingAssistant.executeCarParking(new Car("1","small",true));

        assertEquals(parkingLot2.getNumberOfCars(),2);
    }

}