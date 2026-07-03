class HasMoneyState implements VendingMachineState {

    @Override
    public void selectItem(VendingMachine m, String code) {
        System.out.println("Item already selected. Insert money or cancel.");
    }

    @Override
    public void insertMoney(VendingMachine m, int amount) {
        m.addInserted(amount);
        System.out.println("Inserted: ₹" + amount
                         + " | Total: ₹" + m.getTotalInserted());

        int price = m.getSelectedSlot().getItem().getPrice();

        if (m.getTotalInserted() >= price) {
            System.out.println("Payment complete. Dispensing...");
            m.setState(m.getDispensingState());
            m.dispense();  // DispensingState.dispense() runs now
        } else {
            int remaining = price - m.getTotalInserted();
            System.out.println("Insert ₹" + remaining + " more.");
        }
    }

    @Override
    public void dispense(VendingMachine m) {
        System.out.println("Please insert money first.");
    }

    @Override
    public void cancel(VendingMachine m) {
        int refund = m.getTotalInserted();
        m.resetInserted();
        m.setSelectedSlot(null);
        m.setState(m.getIdleState());
        System.out.println("Cancelled. Refunding: ₹" + refund);
    }

    @Override
    public void addItem(VendingMachine m, String code, Item item, int qty) {
        System.out.println("Transaction in progress. Cannot restock.");
    }

    @Override
    public void collectCash(VendingMachine m) {
        System.out.println("Transaction in progress. Cannot collect cash.");
    }
}