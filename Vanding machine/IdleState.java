public class IdleState implements VendingMachineState {

    @Override
    public void selectItem(VendingMachine m, String code) {
        Slot slot = m.getSlot(code);
        if(slot == null) {
            System.out.println("Invalid slot code.");
            return;
        }

        if(slot.isEmpty()) {
            System.out.println("Selected slot is empty.");
            return;
        }

        m.setSelectedSlot(slot);
        m.setState(m.getItemSelectedState());
    }

    @Override
    public void insertMoney(VendingMachine m, int amount) {
        System.out.println("Please select an item first.");
    }

    @Override
    public void dispense(VendingMachine m) {
        System.out.println("Please select an item first.");
    }

    @Override
    public void cancel(VendingMachine m) {
        System.out.println("No transaction to cancel.");
    }

    @Override
    public void addItem(VendingMachine m, String code, 
                        Item item, int qty) {
        Slot slot = m.getSlot(code);
        if(slot == null){
            slot = new Slot(code, item, qty);
            m.addSlot(code, slot);
            System.out.println("Added new slot " + code + " with " + qty + " of " + item.getName());
        }
        else {slot.add(qty);
            System.out.println("Added " + qty + " of " + item.getName() + " to slot " + code);
        }
    }

    @Override
    public void collectCash(VendingMachine m) {
        int cash = m.collectAllCash();
        System.out.println("Collected cash: " + cash);
    }
}