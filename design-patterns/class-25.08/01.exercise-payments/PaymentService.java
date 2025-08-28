public class PaymentService {
  public void processPayment(PaymentFactory factory, double value) {
    Payment payment = factory.createPayment();
    payment.processPayment(value);
  }
}