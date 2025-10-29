import java.util.List;
import java.util.Random;

public class CajadoArcano implements ArmaStrategy {
  private static final int DANO_BASE = 8;
  private static final int REQ_INT = 12;
  private static final int CUSTO_MANA = 25;
  private Random rand = new Random();

  @Override
  public boolean podeEquipar(Personagem p) {
    return p.getInteligencia() >= REQ_INT;
  }

  @Override
  public void usar(Personagem atacante, Personagem alvoPrincipal, List<Personagem> inimigos) {
    if (atacante.getMana() < CUSTO_MANA) {
      System.out.println(atacante.getNome() + " tenta usar o Cajado Arcano, mas não tem mana suficiente!");
      return;
    }

    atacante.gastarMana(CUSTO_MANA);
    System.out.println(atacante.getNome() + " conjura uma Bola de Fogo em " + alvoPrincipal.getNome() + "!");

    // Lógica de Crítico (Extensão)
    int danoFinal = DANO_BASE;
    if (rand.nextDouble() < 0.15) {
      danoFinal *= 2;
      System.out.println("ACERTO CRÍTICO!");
    }

    alvoPrincipal.receberDano(danoFinal);

    // Efeito Especial: Bola de Fogo (sempre aplica queimadura)
    System.out.println("O alvo está em chamas!");
    alvoPrincipal.aplicarStatus(new StatusEffect("Queimadura", 2, 10, false));
  }
}