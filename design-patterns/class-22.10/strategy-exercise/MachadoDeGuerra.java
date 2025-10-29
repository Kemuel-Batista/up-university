import java.util.List;
import java.util.Random;

public class MachadoDeGuerra implements ArmaStrategy {
  private static final int DANO_BASE = 18;
  private static final int REQ_FORCA = 15;
  private static final int CUSTO_MANA = 5;
  private static final double CHANCE_ATordoar = 0.25;
  private Random rand = new Random();

  @Override
  public boolean podeEquipar(Personagem p) {
    return p.getForca() >= REQ_FORCA;
  }

  @Override
  public void usar(Personagem atacante, Personagem alvoPrincipal, List<Personagem> inimigos) {
    if (atacante.getMana() < CUSTO_MANA) {
      System.out.println(atacante.getNome() + " não tem mana para o Golpe Esmagador!");
      return;
    }

    atacante.gastarMana(CUSTO_MANA);
    System.out.println(atacante.getNome() + " usa um Golpe Esmagador em " + alvoPrincipal.getNome() + "!");

    // Lógica de Crítico (Extensão)
    int danoFinal = DANO_BASE;
    if (rand.nextDouble() < 0.15) {
      danoFinal *= 2;
      System.out.println("ACERTO CRÍTICO!");
    }

    alvoPrincipal.receberDano(danoFinal);

    // Efeito Especial: Golpe Esmagador
    if (rand.nextDouble() < CHANCE_ATordoar) {
      System.out.println("O golpe foi tão forte que atordoou o alvo!");
      alvoPrincipal.aplicarStatus(new StatusEffect("Atordoado", 1, 0, true));
    }
  }
}