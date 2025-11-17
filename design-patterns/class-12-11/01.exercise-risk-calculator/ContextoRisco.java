public class ContextoRisco {
  private double[] valoresPortfolio;
  private double taxaConfianca;
  private String cenarioMercado;
  private int periodoDias;

  // Construtor com os parâmetros
  public ContextoRisco(double[] valoresPortfolio, double taxaConfianca, String cenarioMercado, int periodoDias) {
    this.valoresPortfolio = valoresPortfolio;
    this.taxaConfianca = taxaConfianca;
    this.cenarioMercado = cenarioMercado;
    this.periodoDias = periodoDias;
  }

  // Getters para as estratégias usarem
  public double getTaxaConfianca() {
    return taxaConfianca;
  }

  public String getCenarioMercado() {
    return cenarioMercado;
  }

  public int getPeriodoDias() {
    return periodoDias;
  }

  public double[] getValoresPortfolio() {
    return valoresPortfolio;
  }
}