import java.util.*;
public class Cart {
    private List<CartItem> cartitems;
    private int id;
    private Restaurant restaurant;
    private int totalPrice;

    public Cart(int id) {
        this.cartitems = new ArrayList<>();
        this.id = id;
        this.restaurant = null;
        this.totalPrice = 0;
    }

    public List<CartItem> getItems() {
        return cartitems ;
    }

    public int getId() {
        return id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void addcartItem(Restaurant restaurant, MenuItem menuItem, int quantity){
        if(this.restaurant == null){
            this.restaurant = restaurant;
        }
        else if(!this.restaurant.equals(restaurant)){
            System.out.println("Cannot add items from different restaurants to the same cart.");
            return;
        }

        Menu item = restaurant.getMenu();
        List<MenuItem> menuItems = item.getItems();
        if(!menuItems.contains(menuItem)){
            System.out.println("Item not found in the restaurant's menu.");
            return;
        }

        CartItem cartItem = new CartItem(menuItem, quantity);
        cartitems.add(cartItem);
    }

    public void removeCartItem(CartItem cartitem){
        if(cartitems == null || cartitems.isEmpty()){
            System.out.println("Cart is empty.");
            return;
        }

        if(!cartitems.contains(cartitem)){
            System.out.println("Item not found in the cart.");
            return;
        }

        cartitems.remove(cartitem);
    }

    public int getTotalPrice() {
        totalPrice = 0;
        for (CartItem cartItem : cartitems) {
            totalPrice += cartItem.getTotalPrice();
        }
        return totalPrice;
    }

    public void clearCart() {
        cartitems.clear();
        restaurant = null;
        totalPrice = 0;
    }
}
