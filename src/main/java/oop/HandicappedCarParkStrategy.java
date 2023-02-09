package oop;

import java.util.List;

public class HandicappedCarParkStrategy implements CarParkingStrategy {


  @Override
  public void park(Car car, List<ParkingLot> parkingLots) {
    for (ParkingLot parkingLot : parkingLots) {
      if (parkingLot.getAcceptingHandicappedCars() && parkingLot.park(car)) {
        break;
      }
    }
  }


}
