public class ModeloModerado implements CalculoRiscoStrategy {
  @Override
  public void calcular(double valorInvestido) {
    System.out.println("Aplicando Modelo MODERADO:");
    System.out.println(" - Balanceamento entre FIIs e Renda Fixa.");
    System.out.println(" - Risco calculado: Médio. Potencial de retorno: " + (valorInvestido * 0.08));
  }
}