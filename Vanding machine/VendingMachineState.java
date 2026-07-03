public interface VendingMachineState {
    void selectItem(VendingMachine m, String code);
    void insertMoney(VendingMachine m, int amount);
    void dispense(VendingMachine m);
    void cancel(VendingMachine m);
    void addItem(VendingMachine m, String code, Item item, int qty);
    void collectCash(VendingMachine m);
}
