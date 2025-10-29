public class Guerreiro extends Personagem {

  public Guerreiro(String nome) {
    // Nome, Vida, Mana, Força, Destreza, Inteligência
    super(nome, 120, 50, 15, 8, 5);
  }

  @Override
  public boolean podeUsarTipoArma(ArmaStrategy arma) {
    // Guerreiro pode usar Espadas e Machados
    return (arma instanceof EspadaLonga || arma instanceof MachadoDeGuerra);
  }

  @Override
  public void aplicarPassiva() {
    // Passiva "Pele Dura" é aplicada no método receberDano
  }

  @Override
  public void receberDano(int dano) {
    // Passiva: "Pele Dura" - Reduz dano recebido em 20%
    int danoReduzido = (int) (dano * 0.80);
    System.out.println(nome + " usa Pele Dura! Dano reduzido.");
    super.receberDano(danoReduzido);
  }
}