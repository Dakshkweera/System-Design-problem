class SoldOutState implements VendingMachineState {
    
    @Override
    public void selectItem(VendingMachine m, String code) {
        System.out.println("All items are out of stock. Please restock.");
    }
    
    @Override
    public void insertMoney(VendingMachine m, int amount) { 
        System.out.println("All items are out of stock. Please restock.");
    }   

    @Override
    public void dispense(VendingMachine m){
        System.out.println("All items are out of stock. Please restock.");
    }

    @Override
    public void cancel(VendingMachine m) {
        System.out.println("All items are out of stock. Please restock.");
    }

    @Override
    public void addItem(VendingMachine m, String code, Item item, int qty) {
        Slot slot = m.getSlot(code);
        if(slot == null){
            slot = new Slot(code, item, qty);
            m.addSlot(code, slot);
            System.out.println("Added new slot " + code + " with " + qty + " of " + item.getName());
        }
        else {
            slot.add(qty);
            System.out.println("Added " + qty + " of " + item.getName() + " to slot " + code);
        }
        m.setState(m.getIdleState());
    }

    @Override
    public void collectCash(VendingMachine m) {
        int cash = m.collectAllCash();
        System.out.println("Collected cash: " + cash);
    }
}
