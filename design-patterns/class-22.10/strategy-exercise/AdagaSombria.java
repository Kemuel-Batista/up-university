import java.util.List;
import java.util.Random;

public class AdagaSombria implements ArmaStrategy {
  private static final int DANO_BASE = 10;
  private static final int REQ_DESTREZA = 12;
  private static final int CUSTO_MANA = 10;
  private Random rand = new Random();

  @Override
  public boolean podeEquipar(Personagem p) {
    return p.getDestreza() >= REQ_DESTREZA;
  }

  @Override
  public void usar(Personagem atacante, Personagem alvoPrincipal, List<Personagem> inimigos) {
    if (atacante.getMana() < CUSTO_MANA) {
      System.out.println(atacante.getNome() + " não tem mana para o Ataque Furtivo!");
      return;
    }

    atacante.gastarMana(CUSTO_MANA);
    System.out.println(atacante.getNome() + " prepara um Ataque Furtivo em " + alvoPrincipal.getNome() + "!");

    int danoFinal = DANO_BASE;

    // Efeito Especial: Dano triplo se o inimigo estiver desprevenido (Atordoado)
    if (alvoPrincipal.estaAtordoado()) {
      System.out.println("O alvo está atordoado! Ataque Furtivo causa dano massivo!");
      danoFinal *= 3;
    }

    // Lógica de Crítico (Extensão)
    if (rand.nextDouble() < 0.15) {
      danoFinal = (danoFinal == DANO_BASE) ? danoFinal * 2 : danoFinal; // Crítico não acumula com furtivo
      System.out.println("ACERTO CRÍTICO!");
    }

    alvoPrincipal.receberDano(danoFinal);
  }
}