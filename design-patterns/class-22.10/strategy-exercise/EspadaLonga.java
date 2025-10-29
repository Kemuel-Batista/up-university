import java.util.List;
import java.util.Random;

public class EspadaLonga implements ArmaStrategy {
  private static final int DANO_BASE = 15;
  private static final int REQ_FORCA = 10;
  private static final double CHANCE_SANGRAR = 0.30;
  private Random rand = new Random();

  @Override
  public boolean podeEquipar(Personagem p) {
    return p.getForca() >= REQ_FORCA;
  }

  @Override
  public void usar(Personagem atacante, Personagem alvoPrincipal, List<Personagem> inimigos) {
    System.out.println(atacante.getNome() + " ataca " + alvoPrincipal.getNome() + " com a Espada Longa!");

    // Lógica de Crítico (Extensão)
    int danoFinal = DANO_BASE;
    if (rand.nextDouble() < 0.15) { // 15% de chance de crítico
      danoFinal *= 2;
      System.out.println("ACERTO CRÍTICO!");
    }

    alvoPrincipal.receberDano(danoFinal);

    // Efeito Especial: Corte Profundo
    if (rand.nextDouble() < CHANCE_SANGRAR) {
      System.out.println("Corte Profundo! O alvo está sangrando.");
      alvoPrincipal.aplicarStatus(new StatusEffect("Sangramento", 3, 5, false));
    }
  }
}