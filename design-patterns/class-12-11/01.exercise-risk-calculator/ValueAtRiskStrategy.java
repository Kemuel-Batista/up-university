/**
 * Uma Estratégia Concreta.
 * Implementa o cálculo (dummy) para Value at Risk (VaR).
 */
public class ValueAtRiskStrategy implements RiscoStrategy {
  @Override
  public void calcular(ContextoRisco contexto) {
    System.out.println("--- Calculando Value at Risk (VaR) ---");
    System.out.println("Nível de Confiança: " + (contexto.getTaxaConfianca() * 100) + "%");
    System.out.println("Período: " + contexto.getPeriodoDias() + " dias");
    System.out.println("Cálculo dummy: A perda máxima esperada é de $1,000,000.00");
  }
}