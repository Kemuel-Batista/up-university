public class LegacyPaymentGateway {
  public void makePayment(double amount) {
    System.out.println("Processing payment of $" + amount + " through Legacy Payment Gateway.");
  }

  public boolean checkCreditCard(String cardNumber) {
    // Simulate card validation logic
    return cardNumber != null && cardNumber.length() == 16;
  }
}