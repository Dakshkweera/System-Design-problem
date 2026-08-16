import java.util.*;

public class User {
    private String name;
    private int id;

    private List<Order> orders;
    private Cart cart;
    public User(String name, int id, Cart cart) {
        this.name = name;
        this.id = id;

        this.cart = cart;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
    
    public List<Order> getOrders() {
        return orders;
    }

    public Cart getCart() {
        return cart;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
