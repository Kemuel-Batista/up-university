import java.util.List;
import java.util.Random;

/**
 * Extensão: Classe Híbrida (Paladino).
 * Usa Força e Inteligência. Pode usar Espadas e Cajados.
 */
public class Paladino extends Personagem {
  private Random rand = new Random();

  public Paladino(String nome) {
    // Nome, Vida, Mana, Força, Destreza, Inteligência
    super(nome, 110, 80, 12, 8, 12);
  }

  @Override
  public boolean podeUsarTipoArma(ArmaStrategy arma) {
    // Paladino pode usar Espadas e Cajados
    return (arma instanceof EspadaLonga || arma instanceof CajadoArcano);
  }

  @Override
  public void aplicarPassiva() {
    // Passiva "Cura Leve" é aplicada no método atacar
  }

  @Override
  public void atacar(Personagem alvo, List<Personagem> inimigos) {
    super.atacar(alvo, inimigos); // Executa o ataque normal

    // Passiva: "Cura Leve" - 20% de chance no ataque de se curar
    if (this.estaVivo() && rand.nextDouble() < 0.20) {
      int cura = 10;
      this.vida = Math.min(this.vidaMaxima, this.vida + cura);
      System.out.println(nome + " invoca a Luz e se cura em " + cura + " HP!");
    }
  }
}