public class UPI implements Payment{
    @Override
    public boolean pay(double amount) {
        System.out.println("Paid ₹ " + amount + " using UPI");
        return true; // Return true if payment is successful
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded ₹ " + amount + " using UPI");
    }
}
