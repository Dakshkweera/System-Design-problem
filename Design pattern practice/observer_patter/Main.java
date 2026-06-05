package observer_patter;

class Main{
    public static void main(String[] args){
        User u1 = new Investor("Daksh");
        User u2 = new Investor("kushi");
        User u3 = new Investor("Inika");

        Stockmarket sm = new TataSteel();
        sm.suscriber(u1);
        sm.suscriber(u2);
        sm.suscriber(u3);

        sm.unsuscriber(u2);

        sm.update();
    }
}