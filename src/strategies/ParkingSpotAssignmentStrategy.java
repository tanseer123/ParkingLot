package strategies;

import models.Gate;
import models.ParkingSpot;
import models.Vehicle;
import models.VehicleType;

public interface ParkingSpotAssignmentStrategy {

    ParkingSpot assignParkingSpot(Gate gate, Vehicle vehicle);

}
