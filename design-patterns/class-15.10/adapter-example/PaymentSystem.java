public class PaymentSystem {
  public static void main(String[] args) {
    PaymentProcessor processor = new PaymentGatewayAdapter(new LegacyPaymentGateway());

    String cardNumber = "1234567812345678";
    if (processor.validateCard(cardNumber)) {
      processor.processPayment(150.0);
    }
  }
}