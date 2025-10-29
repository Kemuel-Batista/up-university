public class StateExerciseMain {
  public static void main(String[] args) {
    System.out.println("===== Cenário 1: Fluxo Feliz (Pedido 123) =====");
    Order order1 = new Order("123");

    // Tenta enviar antes de pagar (inválido)
    order1.ship(); // Erro: Não é possível enviar...

    // Paga o pedido
    order1.pay(); // Pagamento recebido...

    // Tenta pagar de novo (inválido)
    order1.pay(); // Erro: O pedido já foi pago.

    // Envia o pedido
    order1.ship(); // Pedido enviado...

    // Entrega o pedido
    order1.deliver(); // Pedido confirmado como 'Entregue'...

    // Tenta cancelar (inválido)
    order1.cancel(); // Ação inválida: ... pedido entregue.

    System.out.println("\nEstado final do Pedido 123: " + order1.getCurrentStateName());

    System.out.println("\n===== Cenário 2: Pedido Cancelado (Pedido 456) =====");
    Order order2 = new Order("456");

    // Cancela o pedido
    order2.cancel(); // Pedido cancelado.

    // Tenta pagar (inválido)
    order2.pay(); // Erro: Não é possível pagar...

    System.out.println("\nEstado final do Pedido 456: " + order2.getCurrentStateName());
  }
}