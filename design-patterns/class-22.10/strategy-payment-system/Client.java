public class Client {
  public static void main(String[] args) {
    // O contexto que gerencia o pagamento
    PaymentContext paymentContext = new PaymentContext(new CreditCardPayment());
    // Realizando um pagamento com cartão de crédito
    paymentContext.executePayment(100.0);

    // Alterando a estratégia para PayPal
    paymentContext.setPaymentStrategy(new PayPalPayment());
    // Realizando um pagamento com PayPal
    paymentContext.executePayment(200.0);

    // Alterando a estratégia para Transferência Bancária
    paymentContext.setPaymentStrategy(new BankTransferPayment());
    // Realizando um pagamento com Bitcoin
    paymentContext.executePayment(300.0);
  }
}
