import java.util.List;
import java.util.Random;

public class ArcoElfico implements ArmaStrategy {
  private static final int DANO_BASE = 12;
  private static final int REQ_DESTREZA = 8;
  private static final int CUSTO_MANA = 15;
  private Random rand = new Random();

  @Override
  public boolean podeEquipar(Personagem p) {
    return p.getDestreza() >= REQ_DESTREZA;
  }

  @Override
  public void usar(Personagem atacante, Personagem alvoPrincipal, List<Personagem> inimigos) {
    if (atacante.getMana() < CUSTO_MANA) {
      System.out.println(atacante.getNome() + " não tem mana para a Chuva de Flechas!");
      return;
    }

    atacante.gastarMana(CUSTO_MANA);
    System.out.println(atacante.getNome() + " dispara uma Chuva de Flechas!");

    // Efeito Especial: Ataque em área
    for (Personagem inimigo : inimigos) {
      if (inimigo.estaVivo()) {
        System.out.println(inimigo.getNome() + " é atingido pela chuva!");

        // Lógica de Crítico (Extensão)
        int danoFinal = DANO_BASE;
        if (rand.nextDouble() < 0.15) {
          danoFinal *= 2;
          System.out.println("ACERTO CRÍTICO!");
        }

        inimigo.receberDano(danoFinal);
      }
    }
  }
}