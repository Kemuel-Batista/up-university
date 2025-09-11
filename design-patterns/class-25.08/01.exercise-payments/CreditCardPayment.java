public class CreditCardPayment implements Payment {
  public String cardNumber;

  public CreditCardPayment(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  @Override
  public void processPayment(double value) {
    System.out.println("Pagamento de R$" + value + " realizado com cartão de crédito.");
  }
}