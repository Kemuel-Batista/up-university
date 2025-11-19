public class ModeloAgressivo implements CalculoRiscoStrategy {
  @Override
  public void calcular(double valorInvestido) {
    System.out.println("Aplicando Modelo AGRESSIVO:");
    System.out.println(" - Foco em ações e criptomoedas.");
    System.out.println(" - Risco calculado: Alto. Potencial de retorno: " + (valorInvestido * 0.15));
  }
}