package oop;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private List<Car> carList = new ArrayList<>();
    private static final int CAPACITY=10;

    public boolean parkTheCar(Car car) {
        if(haveEnoughCapacity()) {
            carList.add(car);
            return true;
        }
        return false;
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

    public boolean haveEnoughCapacity(){
        int maxCapacity=CAPACITY*80/100-1;
        if(carList.size()>maxCapacity){
            return false;
        }
        return true;
    }
    public int getNumberOfCars() {
        return carList.size();
    }

}

