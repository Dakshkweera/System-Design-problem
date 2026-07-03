public class Main {
    public static void main(String[] args) {

        VendingMachine vm = new VendingMachine();

        // admin stocks machine
        vm.addItem("A1", new Item("Chips", 20), 2);
        vm.addItem("B1", new Item("Water", 15), 1);

        System.out.println("\n--- Test 1: Happy path ---");
        vm.selectItem("A1");       // select chips
        vm.insertMoney(10);        // not enough
        vm.insertMoney(15);        // total 25, enough, change 5 returned

        System.out.println("\n--- Test 2: Cancel flow ---");
        vm.selectItem("A1");       // select chips
        vm.insertMoney(10);        // insert some money
        vm.cancel();               // cancel, refund 10

        System.out.println("\n--- Test 3: Buy water ---");
        vm.selectItem("B1");       // select water
        vm.insertMoney(15);        // exact amount

        System.out.println("\n--- Test 4: Last chips → sold out ---");
        vm.selectItem("A1");       // last chips
        vm.insertMoney(20);        // machine goes SOLD_OUT after

        System.out.println("\n--- Test 5: Try buying when sold out ---");
        vm.selectItem("A1");       // blocked

        System.out.println("\n--- Test 6: Admin restocks ---");
        vm.addItem("A1", new Item("Chips", 20), 5);
        vm.selectItem("A1");       // works again
        vm.insertMoney(20);

        System.out.println("\n--- Test 7: Admin collects cash ---");
        vm.collectCash();
    }
}