package oop;

public class Car {

    private String carNumber;
    private String size;

    private boolean handicapped = false;


    public Car(String carNumber, String size) {

        this.carNumber = carNumber;
        this.size = size;
    }

    public Car(String carNumber, String size, boolean handicapped) {
        this.carNumber = carNumber;
        this.size = size;
        this.handicapped = handicapped;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public String getSize() {
        return size;
    }

    public boolean isHandicapped() {
        return handicapped;
    }
}
