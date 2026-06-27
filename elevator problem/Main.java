import java.util.List;

 class Main {
    public static void main(String[] args) {

        ElevatorController controller = new ElevatorController();

        // person on floor 5 presses UP
        controller.requestElevator(5, Requesttype.PICKUP_UP);

        // simulate 20 ticks
        for (int i = 0; i < 20; i++) {
            controller.step();
            System.out.println("Tick " + i + ":");
            List<Elevator> elevators = controller.getElevators();
            for (int j = 0; j < elevators.size(); j++) {
                System.out.println("  Elevator " + j 
                    + " | Floor: " + elevators.get(j).getfloor()
                    + " | Direction: " + elevators.get(j).getdirection());
            }
        }

        // person inside elevator 0 presses floor 8
        controller.getElevators()
                  .get(0)
                  .addreq(new Request(8, Requesttype.DESTINATION));

        // simulate more
        for (int i = 0; i < 20; i++) {
            controller.step();
            System.out.println("Tick " + i + ":");
            List<Elevator> elevators = controller.getElevators();
            for (int j = 0; j < elevators.size(); j++) {
                System.out.println("  Elevator " + j
                    + " | Floor: " + elevators.get(j).getfloor()
                    + " | Direction: " + elevators.get(j).getdirection());
            }
        }
    }
}