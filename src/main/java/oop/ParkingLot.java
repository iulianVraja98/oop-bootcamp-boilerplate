package oop;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Car> carList = new ArrayList<>();
    private static final int CAPACITY = 10;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }


    public void setFull(String newValue) {
        support.firePropertyChange("news", null, newValue);
    }

    public boolean parkTheCar(Car car) {
        if (haveEnoughCapacity()) {
            carList.add(car);
            if (isCapacityMoreThan75Percent()) {
                setFull("Buy more land!");
            }
            return true;
        }
        return false;
    }

    public Car retrieveTheCarByNumber(String carNumber) {
        for (Car car : carList) {
            if (car.getCarNumber().equals(carNumber)) {
                carList.remove(car);
                if (isCapacityLessThan20Percent()) {
                    setFull("Close down some parking slots");
                }
                return car;
            }
        }
        return null;
    }

    public boolean haveEnoughCapacity() {
        int maxCapacity = CAPACITY * 80 / 100 - 1;
        if (carList.size() > maxCapacity) {
            return false;
        }
        return true;
    }

    private boolean isCapacityMoreThan75Percent() {
        return carList.size() > CAPACITY * 75 / 100;
    }

    private boolean isCapacityLessThan20Percent() {
        return carList.size() < CAPACITY * 20 / 100;
    }
    public int getNumberOfCars() {
        return carList.size();
    }

}

