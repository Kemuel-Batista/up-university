/**
 * Uma Estratégia Concreta.
 * Implementa o cálculo (dummy) para Stress Testing.
 */
public class StressTestingStrategy implements RiscoStrategy {
  @Override
  public void calcular(ContextoRisco contexto) {
    System.out.println("--- Executando Stress Testing ---");
    System.out.println("Aplicando cenário de estresse: '" + contexto.getCenarioMercado() + "'");
    System.out.println("Cálculo dummy: A perda total no cenário de estresse é de $4,500,000.00");
  }
}