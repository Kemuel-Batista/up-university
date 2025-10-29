public class Order {

  private OrderState state;
  private String orderId;

  public Order(String orderId) {
    this.orderId = orderId;
    // O estado inicial de todo pedido é "Novo"
    this.state = new NewOrderState(this);
    System.out.println("Pedido #" + orderId + " criado. Estado: " + this.getCurrentStateName());
  }

  // Método para permitir que os estados alterem o estado do contexto
  public void setState(OrderState state) {
    this.state = state;
    System.out.println("--- Pedido #" + orderId + " mudou para: " + this.getCurrentStateName() + " ---");
  }

  // Métodos delegados para o estado atual
  public void pay() {
    state.pay();
  }

  public void ship() {
    state.ship();
  }

  public void deliver() {
    state.deliver();
  }

  public void cancel() {
    state.cancel();
  }

  // Método auxiliar para depuração
  public String getCurrentStateName() {
    return state.getClass().getSimpleName();
  }
}