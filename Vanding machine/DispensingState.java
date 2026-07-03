class DispensingState implements VendingMachineState {

    @Override
    public void selectItem(VendingMachine m, String code) {
        System.out.println("Dispensing in progress. Please wait.");
    }

    @Override
    public void insertMoney(VendingMachine m, int amount) {
        System.out.println("Dispensing in progress. Please wait.");
    }

    @Override
    public void dispense(VendingMachine m) {
        Slot slot = m.getSelectedSlot();

        if (slot == null) {
            System.out.println("No item selected.");
            m.setState(m.getIdleState());
            return;
        }

        // calculate change before reset
        int price  = slot.getItem().getPrice();
        int change = m.getTotalInserted() - price;

        // dispense item
        slot.dispenseItem();

        // machine earns item price only
        m.addToTotalCash(price);

        // return change
        if (change > 0) {
            System.out.println("Change returned: ₹" + change);
        }

        // reset transaction
        m.resetInserted();
        m.setSelectedSlot(null);

        // transition — sold out or idle
        if (m.areAllSlotsEmpty()) {
            System.out.println("Machine is now sold out.");
            m.setState(m.getSoldOutState());
        } else {
            m.setState(m.getIdleState());
        }
    }

    @Override
    public void cancel(VendingMachine m) {
        System.out.println("Dispensing in progress. Cannot cancel.");
    }

    @Override
    public void addItem(VendingMachine m, String code, Item item, int qty) {
        System.out.println("Dispensing in progress. Cannot restock.");
    }

    @Override
    public void collectCash(VendingMachine m) {
        System.out.println("Dispensing in progress. Cannot collect cash.");
    }
}