package oop;

import java.util.List;

public class LargeHandicappedParkStrategy implements CarParkingStrategy {

  @Override
  public void park(Car car, List<ParkingLot> parkingLots) {
    ParkingLot minParkingLot = minOf(parkingLots.get(0), parkingLots.get(1));
    for (ParkingLot parkingLot : parkingLots) {
      if (!car.isHandicapped()) {
        minParkingLot = minOf(minParkingLot, parkingLot);
      } else {
        if (minOf(minParkingLot, parkingLot).getAcceptingHandicappedCars()) {
          minParkingLot = minOf(minParkingLot, parkingLot);
        }
      }
    }
    minParkingLot.park(car);
  }

  public ParkingLot minOf(ParkingLot parkingLot1, ParkingLot parkingLot2) {
    if (parkingLot1.getNumberOfCars() > parkingLot2.getNumberOfCars()) {
      return parkingLot2;
    }
    return parkingLot1;

  }
}
