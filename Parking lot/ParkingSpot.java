public class ParkingSpot {
    private Vehicletype type;
    private Integer Sno;
    // private Boolean parked;
    Vehicle vehicle;

    ParkingSpot(Vehicletype type, Integer Sno){
        this.type = type;
        this.Sno = Sno;
        // this.parked = false;
        // this.vehicle = vehicle;
    }

    public Vehicletype getType() {
        return type;
    }

    public Integer getSno() {
        return Sno;
    }

    public Boolean isempty() {
        return vehicle == null;
    }

    // public Boolean canfit(Vehicle vehicle){
    //     if(vehicle.gettype() == this.type){
    //         return true;
    //     }
    //     return false;
    // }

    public void park(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public void unpark(){
        this.vehicle = null;
    }
}
