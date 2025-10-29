// Estado Concreto: Enviado
public class ShippedOrderState implements OrderState {

  private final Order order;

  public ShippedOrderState(Order order) {
    this.order = order;
  }

  @Override
  public void pay() {
    System.out.println("Erro: O pedido já foi pago.");
  }

  @Override
  public void ship() {
    System.out.println("Erro: O pedido já foi enviado.");
  }

  @Override
  public void deliver() {
    System.out.println("Pedido confirmado como 'Entregue' ao cliente.");
    order.setState(new DeliveredOrderState(order));
  }

  @Override
  public void cancel() {
    System.out.println("Erro: Não é possível cancelar um pedido que já foi enviado.");
  }
}