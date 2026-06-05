import java.util.ArrayList;
import java.util.List;

public class Parkingfloor {
    private Integer floorNo;
    private List<ParkingSpot> parkingSpots;

    Parkingfloor(Integer floorNo){
        this.floorNo = floorNo;
        this.parkingSpots = new ArrayList<>();
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void add(ParkingSpot parkingSpot){
        this.parkingSpots.add(parkingSpot);
    }

    public Boolean check(ParkingSpot spot ,Vehicletype type){
        if(spot.getType() == type){
            return true;
        }
        return false;
    }

    public ParkingSpot getParkingSpots(Vehicletype type){
        for(var parkingSpot : this.parkingSpots){
            if(check(parkingSpot, type) && parkingSpot.isempty()){
                return parkingSpot;
            }
        }
        return null;
    }
}
