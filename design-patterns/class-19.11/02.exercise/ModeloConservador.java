public class ModeloConservador implements CalculoRiscoStrategy {
  @Override
  public void calcular(double valorInvestido) {
    System.out.println("Aplicando Modelo CONSERVADOR:");
    System.out.println(" - Foco total em Tesouro Direto e CDBs.");
    System.out.println(" - Risco calculado: Baixo. Potencial de retorno: " + (valorInvestido * 0.04));
  }
}