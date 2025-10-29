// Estado Concreto: Pago
public class PaidOrderState implements OrderState {

  private final Order order;

  public PaidOrderState(Order order) {
    this.order = order;
  }

  @Override
  public void pay() {
    System.out.println("Erro: O pedido já foi pago.");
  }

  @Override
  public void ship() {
    System.out.println("Pedido enviado para o cliente.");
    order.setState(new ShippedOrderState(order));
  }

  @Override
  public void deliver() {
    System.out.println("Erro: O pedido precisa ser enviado antes de ser entregue.");
  }

  @Override
  public void cancel() {
    System.out.println("Pedido cancelado. Iniciando processo de reembolso.");
    order.setState(new CanceledOrderState(order));
  }
}