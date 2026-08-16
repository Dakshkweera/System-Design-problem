public class Main {
    public static void main(String[] args){
        MenuItem item1 = new MenuItem("Margherita Pizza", 8.99, 1);
        MenuItem item2 = new MenuItem("Pepperoni Pizza", 10.99
, 2);
        MenuItem item3 = new MenuItem("Veggie Pizza", 9.99, 3);

        Menu menu = new Menu(1);
        menu.addItem(item1);
        menu.addItem(item2);
        menu.addItem(item3);
        Restaurant restaurant1 = new Restaurant("Pizza Place", 1, menu, true);

        // Indian restaurant
        MenuItem item4 = new MenuItem("Butter Chicken", 12.99, 4);
        MenuItem item5 = new MenuItem("Paneer Tikka", 10.99, 5);
        Menu menu2 = new Menu(2);
        menu2.addItem(item4);
        menu2.addItem(item5);
        Restaurant restaurant2 = new Restaurant("Tandoori Delight", 2, menu2, true);


        Cart cart1 = new Cart(1);
        User user1 = new User("Alice", 1, cart1);

        cart1.addcartItem(restaurant1, item1, 2); // Adding 2 Margherita Pizzas
        cart1.addcartItem(restaurant1, item2, 1); // Adding 1 Pepperoni Pizza
        // cart1.addcartItem(restaurant2, item4, 1); // Adding 1 Butter Chicken

        Orderservice orderService = new Orderservice();
        Order order = orderService.createorder(user1, OrderType.DELIVERY, new UPI());

        orderService.printOrderInvoice(order);
    }
}
