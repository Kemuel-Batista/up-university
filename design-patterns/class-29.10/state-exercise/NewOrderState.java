// Estado Concreto: Novo
public class NewOrderState implements OrderState {

  private final Order order;

  public NewOrderState(Order order) {
    this.order = order;
  }

  @Override
  public void pay() {
    System.out.println("Pagamento recebido. Pedido agora está 'Pago'.");
    order.setState(new PaidOrderState(order));
  }

  @Override
  public void ship() {
    System.out.println("Erro: Não é possível enviar um pedido que não foi pago.");
  }

  @Override
  public void deliver() {
    System.out.println("Erro: Não é possível entregar um pedido que não foi pago.");
  }

  @Override
  public void cancel() {
    System.out.println("Pedido cancelado.");
    order.setState(new CanceledOrderState(order));
  }
}