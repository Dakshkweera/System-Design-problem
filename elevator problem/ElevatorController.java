import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    
    private List<Elevator> elevators;

    // constructor — initialize 3 elevators
    public ElevatorController() {
        elevators = new ArrayList<>();
        elevators.add(new Elevator());
        elevators.add(new Elevator());
        elevators.add(new Elevator());
    }

    // entry point — someone on a floor presses UP or DOWN
    public boolean requestElevator(int floor, Requesttype type) {
        
        // validate floor
        if (floor < 0 || floor > 9) {
            System.err.println("Invalid floor");
            return false;
        }

        // hall calls only — DESTINATION goes directly to elevator
        if (type == Requesttype.DESTINATION) {
            System.err.println("Use elevator directly for destination");
            return false;
        }

        // pick best elevator and assign request
        Elevator best = selectBestElevator(floor, type);
        best.addreq(new Request(floor, type));
        return true;
    }

    // advance all elevators one tick
    public void step() {
        for (Elevator e : elevators) {
            e.step();
        }
    }

    // expose elevators for simulation
    public List<Elevator> getElevators() {
        return elevators;
    }

    // dispatch logic — pick best elevator for request
    private Elevator selectBestElevator(int floor, Requesttype type) {

        Direction requestDir = type == Requesttype.PICKUP_UP 
                               ? Direction.UP 
                               : Direction.DOWN;

        // priority 1 — elevator already going same direction
        //              and hasn't passed the floor yet
        Elevator best = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator e : elevators) {
            if (e.getdirection() != requestDir) continue;

            // check elevator hasn't passed the floor
            if (requestDir == Direction.UP   && e.getfloor() > floor) continue;
            if (requestDir == Direction.DOWN && e.getfloor() < floor) continue;

            int distance = Math.abs(e.getfloor() - floor);
            if (distance < minDistance) {
                minDistance = distance;
                best = e;
            }
        }

        if (best != null) return best;

        // priority 2 — idle elevator, pick nearest
        minDistance = Integer.MAX_VALUE;
        for (Elevator e : elevators) {
            if (e.getdirection() != Direction.IDLE) continue;

            int distance = Math.abs(e.getfloor() - floor);
            if (distance < minDistance) {
                minDistance = distance;
                best = e;
            }
        }

        if (best != null) return best;

        // priority 3 — any elevator, pick nearest
        minDistance = Integer.MAX_VALUE;
        for (Elevator e : elevators) {
            int distance = Math.abs(e.getfloor() - floor);
            if (distance < minDistance) {
                minDistance = distance;
                best = e;
            }
        }

        return best;
    }
}