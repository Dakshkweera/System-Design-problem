import java.util.*;
import java.time.LocalDateTime;


public class Parkinglot {
    private List<Parkingfloor> floors;
    private Integer ticketcnt;

    Parkinglot(){
        this.floors = new ArrayList<>();
        ticketcnt = 1;
    }

    public void add(Parkingfloor floor){
        this.floors.add(floor);
    }
    public LocalDateTime getcurtime(){
        return LocalDateTime.now();
    }
    public Ticket park(Vehicle vehicel){
        for(var floor : this.floors){
            ParkingSpot spot = floor.getParkingSpots(vehicel.gettype());
            if(spot == null){
                continue;
            }
            spot.park(vehicel);
            String ticketId = "T" + ticketcnt++;
            Ticket ticket = new Ticket(ticketId, spot, getcurtime(), floor.getFloorNo());
            System.out.println("Vehicle parked with ticket ID: " + ticket.getTicketId());
            return ticket;
        }

        System.out.println("No parking spot available");
        return null;
    }

    public void exit(Ticket ticket){
        ParkingSpot spot = ticket.getParkingSpot();
        spot.unpark();
        System.out.println("Vehicle with ticket ID: " + ticket.getTicketId() + " has exited.");
    }
}
