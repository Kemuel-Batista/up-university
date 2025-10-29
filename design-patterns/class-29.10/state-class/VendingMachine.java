public class VendingMachine {
  private State state;

  public VendingMachine() {
    this.state = new NoCoinState(this);
  }

  public void setState(State state) {
    this.state = state;
  }

  public void insertCoin() {
    state.insertCoin();
  }

  public void ejectCoin() {
    state.ejectCoin();
  }

  public void selectProduct() {
    state.selectProduct();
  }
}
