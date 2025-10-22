public class PayPalFactory extends PaymentFactory {
  private final String email;

  PayPalFactory(String email) {
    this.email = email;
  }

  @Override
  public Payment createPayment() {
    if (!validarContaPayPal(email)) {
      throw new IllegalArgumentException("E-mail não está vinculado a uma conta PayPal.");
    }

    return new PayPalPayment();
  }

  private boolean validarContaPayPal(String email) {
    // Aqui seria integração real com a API do PayPal.
    // No exemplo, vamos supor que apenas e-mails terminados com "@paypal.com" são válidos.
    return email != null && email.contains("@") && email.endsWith("@paypal.com");
}
}
