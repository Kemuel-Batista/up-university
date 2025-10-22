public class BankTransferPayment implements PaymentStrategy {
  @Override
  public void pay(double amount) {
    // Simula a lógica de geração de PIX ou dados de transferência
    System.out.println(String.format("Pagamento de R$ %.2f efetuado via Transferência Bancária.", amount));
    System.out.println("Gerando código PIX/Dados da conta para transferência...");
  }
}
