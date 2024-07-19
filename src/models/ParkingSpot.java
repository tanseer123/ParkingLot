package models;

import java.util.List;

public class ParkingSpot extends BaseModel{
    private int number;
    private List<VehicleType> supportedVehicleTypes;
    private ParkingSpot parkingSpotstatus;
    private Vehicle vehicle;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(List<VehicleType> supportedVehicleTypes) {
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public ParkingSpot getParkingSpotstatus() {
        return parkingSpotstatus;
    }

    public void setParkingSpotstatus(ParkingSpot parkingSpotstatus) {
        this.parkingSpotstatus = parkingSpotstatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
