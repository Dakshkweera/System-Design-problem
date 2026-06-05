package observer_patter;
import java.util.ArrayList;

interface Stockmarket {
    void suscriber(User u);
    void unsuscriber(User u);
    void update();
}

class TataSteel implements Stockmarket{
    ArrayList<User> num = new ArrayList<>();

    public void suscriber(User u){
        num.add(u);
    }

    public void unsuscriber(User u){
        num.remove(u);
    }

    public void update(){
        for(var it: num){
            it.update("Tata Steel", 223);
        }
    }
}
