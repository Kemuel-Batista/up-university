/**
 * A classe Context (Contexto).
 * Esta classe mantém uma referência a um objeto Strategy (a estratégia atual).
 * Ela não conhece a implementação concreta, apenas a interface.
 */
public class ProcessadorDeRisco {

  // A referência para a estratégia atual
  private RiscoStrategy estrategiaAtual;

  // O conjunto de dados complexos que será passado para a estratégia
  private ContextoRisco contextoFinanceiro;

  /**
   * Construtor que define o contexto e a estratégia inicial.
   */
  public ProcessadorDeRisco(ContextoRisco contexto, RiscoStrategy estrategiaInicial) {
    this.contextoFinanceiro = contexto;
    this.estrategiaAtual = estrategiaInicial;
  }

  /**
   * Este é o método chave que permite a troca da estratégia
   * em tempo de execução.
   */
  public void setEstrategia(RiscoStrategy novaEstrategia) {
    this.estrategiaAtual = novaEstrategia;
    System.out.println("\n[SISTEMA] Estratégia de risco alterada para: " + novaEstrategia.getClass().getSimpleName());
  }

  /**
   * O cliente chama este método. O Contexto, por sua vez,
   * delega a execução para a estratégia que está
   * configurada no momento.
   */
  public void executarCalculoDeRisco() {
    if (estrategiaAtual == null) {
      System.out.println("Erro: Nenhuma estratégia de risco foi definida.");
      return;
    }
    // Delega a chamada para o objeto strategy encapsulado
    this.estrategiaAtual.calcular(this.contextoFinanceiro);
  }
}