public class CreditCardFactory extends PaymentFactory {
  private String cardNumber;

  public CreditCardFactory(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  @Override
  public Payment createPayment() {
    if (cardNumber == null || !cardNumber.matches("\\d{16}")) {
      throw new IllegalArgumentException("Número de cartão inválido: deve conter exatamente 16 dígitos.");
    }

    return new CreditCardPayment(this.cardNumber);
  }
}
