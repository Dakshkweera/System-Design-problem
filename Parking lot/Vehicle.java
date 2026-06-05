public class Vehicle {
    private Vehicletype type;
    private String licensePlate;

    public Vehicle(Vehicletype type, String lincensePlate) {
        this.type = type;
        this.licensePlate = licensePlate;
    }

    public Vehicletype gettype(){
        return this.type;
    }

    public String getLicensePlate(){
        return this.licensePlate;
    }
}