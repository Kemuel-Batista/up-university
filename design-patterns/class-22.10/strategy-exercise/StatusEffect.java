/**
 * Classe auxiliar para gerenciar efeitos de status (Sangramento, Queimadura,
 * Atordoado).
 */
public class StatusEffect {
  private String nome;
  private int duracao;
  private int danoPorTurno;
  private boolean atordoa;

  public StatusEffect(String nome, int duracao, int danoPorTurno, boolean atordoa) {
    this.nome = nome;
    this.duracao = duracao;
    this.danoPorTurno = danoPorTurno;
    this.atordoa = atordoa;
  }

  public void aplicar(Personagem alvo) {
    if (duracao > 0) {
      System.out.println(alvo.getNome() + " sofre com " + nome + "...");
      if (danoPorTurno > 0) {
        alvo.receberDano(danoPorTurno);
      }
      if (atordoa) {
        alvo.setAtordoado(true);
        System.out.println(alvo.getNome() + " está atordoado e perdeu o turno!");
      }
      duracao--;
    }
  }

  public boolean estaAtivo() {
    return duracao > 0;
  }

  public String getNome() {
    return nome;
  }
}