public interface Payment {
    boolean pay(double amount);
    void refund(double amount);
}
