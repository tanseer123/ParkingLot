package models;

import strategies.ParkingSpotAssignmentStrategy;

import java.util.List;

public class ParkingLot extends BaseModel {
        private List<ParkingFloor> parkingFloors;
        private List<Gate> gates;
        private ParkingSpotAssignmentStrategyType parkingSpotAssignmentStrategyType;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public ParkingSpotAssignmentStrategyType getParkingSpotAssignmentStrategyType() {
        return parkingSpotAssignmentStrategyType;
    }

    public void setParkingSpotAssignmentStrategyType(ParkingSpotAssignmentStrategyType parkingSpotAssignmentStrategyType) {
        this.parkingSpotAssignmentStrategyType = parkingSpotAssignmentStrategyType;
    }
}
