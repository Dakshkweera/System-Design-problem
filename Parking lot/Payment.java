interface payment{
    public void pay(int amount);
    public void getpaymentmethod();
}


class cashPayment implements payment{
    @Override
    public void pay(int amount) {
        System.out.println("Payment made with cash." + " Amount: " + amount);
    }

    @Override
    public void getpaymentmethod(){
        System.out.println("Payment method: Cash");
    }
}

class cardPayment implements payment{
    @Override
    public void pay(int amount) {
        System.out.println("Payment made with card." + " Amount: " + amount);
    }

    @Override
    public void getpaymentmethod(){
        System.out.println("Payment method: Card");
    }
}

class UPI implements payment{
    @Override
    public void pay(int amount) {
        System.out.println("Payment made with UPI payment." + " Amount: " + amount);
    }

    @Override
    public void getpaymentmethod(){
        System.out.println("Payment method: UPI");
    }
}