import java.util.HashSet;
import java.util.Set;

public class Elevator {
    private Set<Request> requests;
    private int floor;
    private Direction direction;

    public Elevator(){
        this.direction=Direction.IDLE;
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

    public void step(){
        // case 1
        if(requests.isEmpty()){
            direction = Direction.IDLE;
            return;
        }

        // case2
        if(direction==Direction.IDLE){
            int minDis = Integer.MAX_VALUE;
            Request r = null;

            for(Request rq:requests){
                int dis = Math.abs(rq.getfloor()-floor);
                
                if(minDis>dis || (minDis==dis && r != null && rq.getfloor()<r.getfloor())){
                    minDis = dis;
                    r = rq;
                }
            }

            direction = floor<r.getfloor()? Direction.UP:Direction.DOWN;

        }

        // case3
        Requesttype pickup = direction == Direction.DOWN? Requesttype.PICKUP_DOWN:Requesttype.PICKUP_UP;

        Request r1 = new Request(floor, pickup);
        Request r2 = new Request(floor, Requesttype.DESTINATION);

        if(requests.contains(r2) || requests.contains(r1)){
            requests.remove(r2);
            requests.remove(r1);

            if(requests.isEmpty()){
                direction = Direction.IDLE;
            }
            return;
        }

        // case4
        if(!aheadus()){
            direction = Direction.UP==direction?Direction.DOWN:Direction.UP;
            return;
        }

        // case5
        if(direction==Direction.DOWN)floor--;
        if(direction==Direction.UP)floor++;
    }

    private boolean aheadus(){
        for(Request r : requests){
            if(direction==Direction.UP && r.getfloor()>floor)return true;
            if(direction==Direction.DOWN && r.getfloor()<floor)return true;
        }
        return false;
    }
}
