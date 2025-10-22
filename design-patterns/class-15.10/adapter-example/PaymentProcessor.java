public interface PaymentProcessor {
  void processPayment(double amount);
  boolean validateCard(String cardNumber);
}