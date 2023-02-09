package oop;

import java.util.List;

public interface CarParkingStrategy {

  void park(Car car, List<ParkingLot> parkingLots);

}
