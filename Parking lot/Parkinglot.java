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

    public int calculateamt(Ticket ticket){
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = getcurtime();
        long duration = java.time.Duration.between(entryTime, exitTime).toMinutes();
        int amount = 0;
        if(ticket.getParkingSpot().getType() == Vehicletype.Truck){
            amount += 50*duration+100;
        }
        else if(ticket.getParkingSpot().getType() == Vehicletype.Car){
            amount += 20*duration+50;
        }
        else if(ticket.getParkingSpot().getType() == Vehicletype.Bike){
            amount += 10*duration+20;
        }
        return amount;
    }
    public Recipt exit(Ticket ticket, payment pay){
        int amt = calculateamt(ticket);
        pay.pay(amt);
        ParkingSpot spot = ticket.getParkingSpot();
        spot.unpark();
        Recipt recipt = new Recipt(ticket.getTicketId(), amt, ticket.getEntryTime(), getcurtime(), pay);
        return recipt;
    }
}
