public class HasCoinState implements State {
  private VendingMachine vendingMachine;

  public HasCoinState(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void insertCoin() {
    System.out.println("Coin already inserted.");
  }

  @Override
  public void ejectCoin() {
    System.out.println("Coin ejected.");
    vendingMachine.setState(new NoCoinState(vendingMachine));
  }

  @Override
  public void selectProduct() {
    System.out.println("Product selected. Dispensing product...");
    vendingMachine.setState(new NoCoinState(vendingMachine));
  }
}
