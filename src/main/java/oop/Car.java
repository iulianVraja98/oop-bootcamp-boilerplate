package oop;

public class Car {

    private boolean fancy = false;
    private String carNumber;
    private boolean large;
    private boolean handicapped = false;

    public Car(String carNumber, boolean large) {
        this.carNumber = carNumber;
        this.large = large;
    }

    public Car(String carNumber, boolean large, boolean handicapped) {
        this.carNumber = carNumber;
        this.large = large;
        this.handicapped = handicapped;
    }

    public Car(String carNumber, boolean large, boolean handicapped, boolean fancy) {
        this.carNumber = carNumber;
        this.large = large;
        this.handicapped = handicapped;
        this.fancy = fancy;
    }

    public Car(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public boolean isLarge() {
        return large;
    }

    public boolean isHandicapped() {
        return handicapped;
    }

    public boolean isFancy() {
        return fancy;
    }

    public CarParkingStrategy chooseCarParkingStrategy() {
        if (!this.isLarge() && this.isHandicapped()) {
            return new HandicappedCarParkStrategy();
        }
        if (this.isLarge() && this.isHandicapped()) {
            return new LargeHandicappedParkStrategy();
        }
        if (this.isLarge() && !this.isHandicapped()) {
            return new LargeCarParkStrategy();
        }
        return new NormalCarParkStrategy();
    }
}
