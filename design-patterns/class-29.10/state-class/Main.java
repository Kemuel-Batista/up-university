public class Main {
  public static void main(String[] args) {
    VendingMachine vendingMachine = new VendingMachine();
    vendingMachine.setState(new NoCoinState(vendingMachine));

    vendingMachine.selectProduct(); // Insert coin first.
    vendingMachine.insertCoin();    // Coin inserted.
    vendingMachine.selectProduct(); // Product selected. Dispensing product...
    vendingMachine.ejectCoin();     // No coin to eject.
  }
}
