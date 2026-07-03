class ItemSelectedState implements VendingMachineState{
    @Override
    public void selectItem(VendingMachine m, String code) {
        System.out.println("Item already selected. Please insert money or cancel.");
    }

    @Override
    public void insertMoney(VendingMachine m, int amount) {
        m.addInserted(amount);
        System.out.println("Inserted: " + amount + ". Total inserted: " + m.getTotalInserted());
        m.setState(m.getHasMoneyState());
    }

    @Override
    public void dispense(VendingMachine m) {
        System.out.println("Please insert money first.");
    }

    @Override
    public void cancel(VendingMachine m){
        m.setSelectedSlot(null);
        System.out.println("Transaction cancelled. Returning to idle state.");
        m.setState(m.getIdleState());
    }

    @Override
    public void addItem(VendingMachine m, String code, Item item, int qty)  {
        System.out.println("Cannot add items while a transaction is in progress.");
    }
    
    @Override
    public void collectCash(VendingMachine m) {
        System.out.println("Cannot collect cash while a transaction is in progress.");
    }
}