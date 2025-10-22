public class CreditCardPayment implements PaymentStrategy {
  @Override
  public void pay(double amount) {
    System.out.println(String.format("Pagamento de R$ %.2f efetuado com Cartão de Crédito.", amount));
    System.out.println("Validando limite e cobrando valor...");
  }
}
