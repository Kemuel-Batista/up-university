public class PayPalPayment implements Payment {
  @Override
  public void processPayment(double value) {
    System.out.println("Pagamento de R$" + value + " realizado com PayPal.");
  }
}
