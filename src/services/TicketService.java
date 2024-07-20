package services;

import exceptions.GateNotFoundException;
import factories.ParkingSpotAssignmentStrategyFactory;
import models.*;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import strategies.ParkingSpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private ParkingLotRepository parkingLotRepository;
    private VehicleRepository vehicleRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository,
                         ParkingLotRepository parkingLotRepository,
                         VehicleRepository vehicleRepository,
                         TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(Long gateId, String vehicleNumber,
                              String vehicleOwnerName,
                              VehicleType vehicleType) throws GateNotFoundException {

        /*
        1. get the Gate object from gateId.
        2. Check if the vehicle eith the given number is already present in DB.
        3. if yes, proceed. if not, save the vehicle in the DB
        4. Assign the parking spot
        5. create the object
        */
        Optional<Gate> optionalGate = gateRepository.findGateID(gateId);

        if (optionalGate.isEmpty()) {
            throw new GateNotFoundException("Gate not found with id " +gateId+ "doesn't exist");
        }

        //Operator operator = optionalGate.get().getOperator();
        Gate gate = optionalGate.get();
        Ticket ticket = new Ticket();
        ticket.setGate(gate);
        ticket.setEntryTime(new Date());

        //get the Vehicle object
        Optional<Vehicle> optionalVehicle =vehicleRepository.findVehicleByVehicleNumber(vehicleNumber);
        Vehicle savedVehicle = null;
        if (optionalVehicle.isEmpty()) {
            //create and save to DB
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle.setOwnerName(vehicleOwnerName);
            savedVehicle = vehicleRepository.save(vehicle);
        }
        else{
            savedVehicle = optionalVehicle.get();
        }
        ticket.setVehicle(savedVehicle);

        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.getparkingLotByGateId(gateId);
        if(optionalParkingLot.isEmpty()){
            throw new RuntimeException("Invalid ParkingLot");
        }

        ParkingLot parkingLot = optionalParkingLot.get();

        ParkingSpotAssignmentStrategyType strategyType=
                parkingLot.getParkingSpotAssignmentStrategyType();

        ParkingSpotAssignmentStrategy assignmentStrategy =
                ParkingSpotAssignmentStrategyFactory.getParkingSpotAssignmentStrategy(strategyType);
        ParkingSpot parkingSpot = assignmentStrategy.assignParkingSpot(gate, savedVehicle);
        ticket.setParkingSpot(parkingSpot);

        return ticketRepository.save(ticket);
    }

}
