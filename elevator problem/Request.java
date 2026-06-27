public class Request {
    private int floor;
    private Requesttype rq;

    public Request(int floor, Requesttype rq){
        this.floor = floor;
        this.rq = rq;
    }

    public int getfloor(){
        return floor;
    }

    public Requesttype getreq(){
        return rq;
    }
}
