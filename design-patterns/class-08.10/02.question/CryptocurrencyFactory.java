public class CryptocurrencyFactory extends PaymentFactory {
  private final double saldoCarteira;
  private final double valorTransacao;

  public CryptocurrencyFactory(double saldoCarteira, double valorTransacao) {
    this.saldoCarteira = saldoCarteira;
    this.valorTransacao = valorTransacao;
  }

  @Override
  public Payment createPayment() {
    if (!verificarSaldo(saldoCarteira, valorTransacao)) {
      throw new IllegalArgumentException("Saldo insuficiente na carteira digital.");
    }

    return new CriptocurrencyPayment();
  }

  private boolean verificarSaldo(double saldo, double valor) {
    return saldo >= valor;
  }
}
