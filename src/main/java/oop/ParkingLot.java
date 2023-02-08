package oop;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private List<Car> carList = new ArrayList<>();

    public void parkTheCar(Car car) {
        carList.add(car);
    }

    public Car retrieveTheCarByNumber(String carNumber) {
        for (Car car : carList) {
            if (car.getCarNumber().equals(carNumber)) {
                carList.remove(car);
                return car;
            }
        }
        return null;
    }

    public int getNumberOfCars() {
        return carList.size();
    }

}

