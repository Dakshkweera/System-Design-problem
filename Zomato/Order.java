import java.util.List;

public class Order {
    private int id;
    private User user;
    private Restaurant restaurant;
    private List<OrderItem> orderItems;
    private OrderType orderType;
    private Payment payment;
    private OrderStatus orderStatus;
    private int totalPrice;

    public Order(int id, User user, Restaurant restaurant, List<OrderItem> orderItems, OrderType orderType, Payment payment, int totalPrice) {
        this.id = id;
        this.user = user;
        this.restaurant = restaurant;
        this.orderItems = orderItems;
        this.orderType = orderType;
        this.payment = payment;
        this.totalPrice = totalPrice;
        this.orderStatus = OrderStatus.PENDING;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public Payment getPayment() {
        return payment;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
