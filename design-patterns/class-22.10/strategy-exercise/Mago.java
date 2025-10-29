public class Mago extends Personagem {

  public Mago(String nome) {
    // Nome, Vida, Mana, Força, Destreza, Inteligência
    super(nome, 70, 150, 5, 7, 18);
  }

  @Override
  public boolean podeUsarTipoArma(ArmaStrategy arma) {
    // Mago pode usar Cajados e Adagas
    return (arma instanceof CajadoArcano || arma instanceof AdagaSombria);
  }

  @Override
  public void aplicarPassiva() {
    // Passiva: "Regeneração de Mana" +10 mana por turno
    this.mana = Math.min(this.manaMaxima, this.mana + 10);
    System.out.println(nome + " regenera 10 de mana. (Mana atual: " + this.mana + ")");
  }
}