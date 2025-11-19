public class PlataformaInvestimento {
  private CalculoRiscoStrategy strategy;

  // Construtor define uma estratégia inicial
  public PlataformaInvestimento(CalculoRiscoStrategy strategy) {
    this.strategy = strategy;
  }

  // Setter permite a troca dinâmica (Runtime)
  public void setStrategy(CalculoRiscoStrategy strategy) {
    this.strategy = strategy;
  }

  public void executarAnaliseRisco(double valor) {
    strategy.calcular(valor);
  }
}
