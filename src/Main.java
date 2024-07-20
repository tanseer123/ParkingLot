import controllers.TicketController;
import dtos.IssueTicketRequestDto;
import dtos.IssueTicketResponseDto;
import models.VehicleType;
import repositories.GateRepository;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import repositories.VehicleRepository;
import services.TicketService;

public class Main {
    public static void main(String[] args) {

        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

        TicketService ticketService =new TicketService(gateRepository,parkingLotRepository,
                vehicleRepository,ticketRepository);

        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDto requestDto = new IssueTicketRequestDto();
        requestDto.setGateId(1);
        requestDto.setOwnerName("ABC");
        requestDto.setVehicleNumber("KA34XX1234");
        requestDto.setVehicleType(VehicleType.SEDAN);

        IssueTicketResponseDto responseDto = ticketController.issueTicket(requestDto);
        System.out.println(responseDto.getResponseStatus());

    }
}