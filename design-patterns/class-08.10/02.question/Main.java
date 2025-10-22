public class Main {
  public static void main(String[] args) {
    PaymentService service = new PaymentService();

    service.processPayment(new CreditCardFactory("1234567891014587"), 150.0);

    service.processPayment(new PayPalFactory("kemuel@paypal.com"), 75.0);

    service.processPayment(new CryptocurrencyFactory(10, 300), 300.0);
  }
}
