class OrderItem{
    private MenuItem item;
    private int quantity;
    private double totalPrice;

    public OrderItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.totalPrice = item.getPrice() * quantity;
    }

    public MenuItem getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}