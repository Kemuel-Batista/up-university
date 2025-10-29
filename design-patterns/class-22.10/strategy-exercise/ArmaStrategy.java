import java.util.List;

/**
 * A interface Strategy (Estratégia).
 * Define o contrato para um "algoritmo" de ataque. Cada arma concreta
 * implementará esta interface, fornecendo sua própria lógica de dano
 * e efeitos especiais.
 */
public interface ArmaStrategy {

  /**
   * Executa o algoritmo de ataque da arma.
   * 
   * @param atacante      O personagem que está usando a arma (O Contexto).
   * @param inimigos      A lista de todos os inimigos em batalha.
   * @param alvoPrincipal O alvo primário selecionado (pode ser null se a arma for
   *                      em área).
   */
  void usar(Personagem atacante, Personagem alvoPrincipal, List<Personagem> inimigos);

  /**
   * Verifica se o personagem atende aos requisitos de atributos para equipar esta
   * arma.
   * 
   * @param p O personagem.
   * @return true se puder equipar, false caso contrário.
   */
  boolean podeEquipar(Personagem p);
}