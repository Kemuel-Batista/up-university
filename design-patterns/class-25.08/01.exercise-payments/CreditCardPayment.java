public class CreditCardPayment implements Payment {
  @Override
  public void processPayment(double value) {
    System.out.println("Pagamento de R$" + value + " realizado com cartão de crédito.");
  }
}