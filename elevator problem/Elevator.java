import java.util.HashSet;
import java.util.Set;

public class Elevator {
    private Set<Request> requests;
    private int floor;
    private Direction direction;

    public Elevator(){
        this.direction=Direction.IDEL;
        this.floor=0;
        requests = new HashSet<>();
    }

    public void addreq(Request req){
        if(req.getfloor()<0 || req.getfloor()>9){
            System.err.println("This floor don't exist");
            return;
        }
        if (req.getfloor() == this.floor) {
            System.out.println("Already on this floor");
            return;  // no-op
        }
        requests.add(req);
    }

    public int getfloor(){
        return floor;
    }

    public Direction getdirection(){
        return direction;
    }


}
