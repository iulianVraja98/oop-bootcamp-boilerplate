package oop;

import java.util.List;

public class NormalCarParkStrategy implements CarParkingStrategy {

  @Override
  public void park(Car car, List<ParkingLot> parkingLots) {
    for (ParkingLot parkingLot : parkingLots) {
      if (parkingLot.park(car)) {
        break;
      }
    }
  }
}
