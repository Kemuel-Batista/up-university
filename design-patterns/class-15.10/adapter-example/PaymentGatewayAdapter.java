public class PaymentGatewayAdapter implements PaymentProcessor {
  private final LegacyPaymentGateway legacyPaymentGateway;

  public PaymentGatewayAdapter(LegacyPaymentGateway legacyPaymentGateway) {
    this.legacyPaymentGateway = legacyPaymentGateway;
  }

  @Override
  public void processPayment(double amount) {
    legacyPaymentGateway.makePayment(amount);
  }

  @Override
  public boolean validateCard(String cardNumber) {
    return legacyPaymentGateway.checkCreditCard(cardNumber);
  }
}