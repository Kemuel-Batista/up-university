import java.util.Random;

public class Arqueiro extends Personagem {
  private Random rand = new Random();
  private static final double CHANCE_ESQUIVA = 0.25;

  public Arqueiro(String nome) {
    // Nome, Vida, Mana, Força, Destreza, Inteligência
    super(nome, 90, 80, 8, 15, 7);
  }

  @Override
  public boolean podeUsarTipoArma(ArmaStrategy arma) {
    // Arqueiro pode usar Arcos e Adagas
    return (arma instanceof ArcoElfico || arma instanceof AdagaSombria);
  }

  @Override
  public void aplicarPassiva() {
    // Passiva "Esquiva" é aplicada no método receberDano
  }

  @Override
  public void receberDano(int dano) {
    // Passiva: "Esquiva" - 25% de chance de evitar um ataque
    if (rand.nextDouble() < CHANCE_ESQUIVA) {
      System.out.println(nome + " se esquivou do ataque!");
    } else {
      super.receberDano(dano);
    }
  }
}