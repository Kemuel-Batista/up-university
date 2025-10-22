public class PayPalPayment implements PaymentStrategy {
  @Override
  public void pay(double amount) {
    System.out.println(String.format("Pagamento de R$ %.2f efetuado via PayPal.", amount));
    System.out.println("Redirecionando para o gateway do PayPal...");
  }
}
