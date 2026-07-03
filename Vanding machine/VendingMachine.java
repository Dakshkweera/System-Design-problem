import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    // data fields
    private Map<String, Slot> slots;
    private Slot selectedSlot;
    private int totalInserted;
    private int totalCash;

    // state instances
    private VendingMachineState currentState;
    private VendingMachineState idleState;
    private VendingMachineState itemSelectedState;
    private VendingMachineState hasMoneyState;
    private VendingMachineState dispensingState;
    private VendingMachineState soldOutState;

    public VendingMachine() {
        slots = new HashMap<>();
        totalInserted = 0;
        totalCash = 0;
        selectedSlot = null;

        // create all state instances
        idleState         = new IdleState();
        itemSelectedState = new ItemSelectedState();
        hasMoneyState     = new HasMoneyState();
        dispensingState   = new DispensingState();
        soldOutState      = new SoldOutState();

        // machine starts idle
        currentState = idleState;
    }

    // user actions — all delegate to current state
    public void selectItem(String code)               { currentState.selectItem(this, code); }
    public void insertMoney(int amount)               { currentState.insertMoney(this, amount); }
    public void dispense()                            { currentState.dispense(this); }
    public void cancel()                              { currentState.cancel(this); }
    public void addItem(String code, Item item, int qty) { currentState.addItem(this, code, item, qty); }
    public void collectCash()                         { currentState.collectCash(this); }

    // internal helpers — used by state classes
    public void setState(VendingMachineState state)   { this.currentState = state; }
    public Slot getSlot(String code)                  { return slots.get(code); }
    public void setSelectedSlot(Slot slot)            { this.selectedSlot = slot; }
    public Slot getSelectedSlot()                     { return selectedSlot; }
    public int getTotalInserted()                     { return totalInserted; }
    public void addInserted(int amount)               { totalInserted += amount; }
    public void resetInserted()                       { totalInserted = 0; }
    public void addToTotalCash(int amount)            { totalCash += amount; }
    public int collectAllCash()                       { int c = totalCash; totalCash = 0; return c; }

    public boolean areAllSlotsEmpty() {
        for (Slot s : slots.values()) {
            if (!s.isEmpty()) return false;
        }
        return true;
    }

    // state getters — used by states to transition
    public VendingMachineState getIdleState()         { return idleState; }
    public VendingMachineState getItemSelectedState() { return itemSelectedState; }
    public VendingMachineState getHasMoneyState()     { return hasMoneyState; }
    public VendingMachineState getDispensingState()   { return dispensingState; }
    public VendingMachineState getSoldOutState()      { return soldOutState; }

    // admin — add slot directly
    public void addSlot(String code, Slot slot)       { slots.put(code, slot); }
}