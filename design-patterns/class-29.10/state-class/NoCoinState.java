public class NoCoinState implements State {
  private VendingMachine vendingMachine;

  public NoCoinState(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void insertCoin() {
    System.out.println("Coin inserted.");
    vendingMachine.setState(new HasCoinState(vendingMachine));
  }

  @Override
  public void ejectCoin() {
    System.out.println("No coin to eject.");
  }

  @Override
  public void selectProduct() {
    System.out.println("Insert coin first.");
  }
}
