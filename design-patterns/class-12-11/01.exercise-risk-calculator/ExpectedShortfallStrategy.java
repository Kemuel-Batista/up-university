/**
 * Uma Estratégia Concreta.
 * Implementa o cálculo (dummy) para Expected Shortfall (ES).
 */
public class ExpectedShortfallStrategy implements RiscoStrategy {
  @Override
  public void calcular(ContextoRisco contexto) {
    System.out.println("--- Calculando Expected Shortfall (ES) ---");
    System.out.println("Calculando a média das perdas além do VaR de " + (contexto.getTaxaConfianca() * 100) + "%");
    System.out.println("Cálculo dummy: A perda média esperada em cenários extremos é de $1,750,000.00");
  }
}