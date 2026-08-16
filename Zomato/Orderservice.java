import java.util.ArrayList;
import java.util.List;

public class Orderservice {
    private int OrderId;

    public Orderservice(){
        this.OrderId =0;
    }
    public Order createorder(User user, OrderType ordertype, Payment pay){
        Cart cart = user.getCart();
        if(cart.getItems().isEmpty()){
            System.out.println("Cart is empty. Cannot create order.");
            return null;
        }

        Restaurant restaurant = cart.getRestaurant();
        if(!restaurant.isOpen()){
            System.out.println("Restaurant is closed. Cannot create order.");
            return null;
        }
        List<OrderItem> orderItems = new ArrayList<>();
        for(CartItem cartItem : cart.getItems()){
            orderItems.add(new OrderItem(cartItem.getItem(), cartItem.getQuantity()));
        }

        int totalPrice = cart.getTotalPrice();
        Order order = new Order(++OrderId, user, restaurant, orderItems, ordertype, pay, totalPrice);

        pay.pay(totalPrice);
        order.setOrderStatus(OrderStatus.CONFIRMED);
        user.addOrder(order);
        return order;
    }

    public void cancelOrder(Order order){
        if(order.getOrderStatus() == OrderStatus.CANCELLED){
            System.out.println("Order is already cancelled.");
            return;
        }

        order.setOrderStatus(OrderStatus.CANCELLED);
        Payment payment = order.getPayment();
        payment.refund(order.getTotalPrice());
    }

    public void printOrderInvoice(Order order){
        System.out.println("Order Invoice:");
        System.out.println("Order ID: " + order.getId());
        System.out.println("User: " + order.getUser().getName());
        System.out.println("Restaurant: " + order.getRestaurant().getName());
        System.out.println("Order Type: " + order.getOrderType());
        System.out.println("Order Status: " + order.getOrderStatus());
        System.out.println("Total Price: ₹" + order.getTotalPrice());
    }
}
