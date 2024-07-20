package factories;

import models.ParkingSpotAssignmentStrategyType;
import strategies.NearestParkingSpotAssignment;
import strategies.ParkingSpotAssignmentStrategy;
import strategies.RandomSpotAssignmentStrategy;

public class ParkingSpotAssignmentStrategyFactory {
    public static ParkingSpotAssignmentStrategy getParkingSpotAssignmentStrategy(
            ParkingSpotAssignmentStrategyType strategyType) {
        if(strategyType.equals(ParkingSpotAssignmentStrategyType.NEAREST)){
            return new NearestParkingSpotAssignment();
        }
        return new RandomSpotAssignmentStrategy();
    }
}