package observer_patter;

interface User{
    void update(String name,int price);
}

class Investor implements User{
    String name;

    Investor(String name){
        this.name = name;
    }

    public void update(String name,int price){
        System.out.println("Investor "+this.name+" has been notified that "+name+" stock price is now "+price);
    }
}
