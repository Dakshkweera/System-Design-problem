public class Slot {
    private String slotId;
    private Item item;
    private int quantity;

    public Slot(String slotId, Item item, int quantity) {
        this.slotId = slotId;
        this.item = item;
        this.quantity = quantity;
    }

    public String getSlotId() {
        return slotId;
    }
    
    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isEmpty() {
        return quantity == 0;
    }

    public void dispenseItem(){
        if(isEmpty()){
            System.out.println("Slot is empty. Cannot dispense item.");
        } else {
            quantity--;
            System.out.println("Dispensed: " + item.getName());
        }
    }

    public void add(int qt){
        quantity+=qt;
    }
}
