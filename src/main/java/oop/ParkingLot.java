package oop;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private List<Car> carList = new ArrayList<>();
    private static final int CAPACITY = 10;

    private PropertyChangeSupport support;

    public ParkingLot(PropertyChangeSupport support) {
        this.support = support;
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setFull() {
        support.firePropertyChange("allMostFullCapacity", null, "You need to buy more land");
    }

    private boolean isCapacityMoreThan75Percent() {
        return carList.size() > CAPACITY * 75 / 100;
    }

    public boolean parkTheCar(Car car) {
        if (haveEnoughCapacity()) {
            carList.add(car);
            if(isCapacityMoreThan75Percent()) setFull();
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

    public boolean haveEnoughCapacity() {
        int maxCapacity = CAPACITY * 80 / 100 - 1;
        if (carList.size() > maxCapacity) {
            return false;
        }
        return true;
    }

    public int getNumberOfCars() {
        return carList.size();
    }

}

