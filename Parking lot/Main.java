public class Main {
    public static void main(String[]arg){
        Parkinglot parkinglot = new Parkinglot();
        Vehicle vehicle1 = new Vehicle(Vehicletype.Car,"DL-01-AB-1234");
        Vehicle vehicle2 = new Vehicle(Vehicletype.Truck, "DL-01-AB-5678");


        ParkingSpot spot1 = new ParkingSpot(Vehicletype.Car, 1);
        ParkingSpot spot2 = new ParkingSpot(Vehicletype.Truck,2);

        Parkingfloor floor1 = new Parkingfloor(1);
        floor1.add(spot1);
        Parkingfloor floor2 = new Parkingfloor(2);
        floor2.add(spot2);

        parkinglot.add(floor1);
        parkinglot.add(floor2);

        Ticket ticket1 = parkinglot.park(vehicle1);

        Ticket ticket2 = parkinglot.park(vehicle2);
        System.out.println(ticket1.getEntryTime());
        parkinglot.exit(ticket1);
        parkinglot.exit(ticket2);
    }
}
