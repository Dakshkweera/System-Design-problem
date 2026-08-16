public class Card implements Payment {
    @Override
    public boolean pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Card");
        return true; // Simulate successful payment
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded ₹" + amount + " to Card");
    }
}