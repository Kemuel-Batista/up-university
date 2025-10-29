// Estado Concreto: Cancelado (Estado Final)
public class CanceledOrderState implements OrderState {
  private final Order order;

  public CanceledOrderState(Order order) {
    this.order = order;
  }

  @Override
  public void pay() {
    System.out.println("Erro: Não é possível pagar por um pedido cancelado.");
  }

  @Override
  public void ship() {
    System.out.println("Erro: Não é possível enviar um pedido cancelado.");
  }

  @Override
  public void deliver() {
    System.out.println("Erro: Não é possível entregar um pedido cancelado.");
  }

  @Override
  public void cancel() {
    System.out.println("Erro: O pedido já está cancelado.");
  }
}