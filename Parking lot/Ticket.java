import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private ParkingSpot parkingSpot;
    private LocalDateTime EntryTime;
    private Integer floorNo;


    public Ticket(String ticketId, ParkingSpot parkingSpot, LocalDateTime entryTime, Integer floorNo) {
        this.ticketId = ticketId;
        this.parkingSpot = parkingSpot;
        this.EntryTime = entryTime;
        this.floorNo = floorNo;
    }   

    public String getTicketId() {
        return ticketId;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getEntryTime() {
        return EntryTime;
    }
}
