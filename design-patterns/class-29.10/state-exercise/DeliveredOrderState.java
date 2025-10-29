// Estado Concreto: Entregue (Estado Final)
public class DeliveredOrderState implements OrderState {
  private final Order order;

  public DeliveredOrderState(Order order) {
    this.order = order;
  }

  @Override
  public void pay() {
    System.out.println("Ação inválida: O pedido já foi entregue.");
  }

  @Override
  public void ship() {
    System.out.println("Ação inválida: O pedido já foi entregue.");
  }

  @Override
  public void deliver() {
    System.out.println("Ação inválida: O pedido já foi entregue.");
  }

  @Override
  public void cancel() {
    System.out.println("Ação inválida: Não é possível cancelar um pedido entregue.");
  }
}