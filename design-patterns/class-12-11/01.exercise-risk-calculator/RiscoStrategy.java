/**
 * A interface Strategy.
 * Define o contrato (o método) que todos os algoritmos de cálculo
 * de risco devem implementar.
 * Ela recebe o contexto complexo como parâmetro.
 */
public interface RiscoStrategy {

  /**
   * Executa o cálculo de risco.
   * 
   * @param contexto Os dados financeiros necessários para o cálculo.
   */
  void calcular(ContextoRisco contexto);
}