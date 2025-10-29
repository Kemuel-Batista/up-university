import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A classe Context (Contexto).
 * Este é o objeto que "tem" uma Estratégia (ArmaStrategy).
 * Ele delega a execução do ataque para a estratégia equipada.
 */
public abstract class Personagem {

  // Atributos
  protected String nome;
  protected int forca, destreza, inteligencia;
  protected int vida, vidaMaxima;
  protected int mana, manaMaxima;

  // O objeto Strategy
  protected ArmaStrategy armaEquipada;

  protected List<StatusEffect> statusEffects;
  protected boolean estaAtordoado = false;

  public Personagem(String nome, int vida, int mana, int forca, int destreza, int inteligencia) {
    this.nome = nome;
    this.vidaMaxima = vida;
    this.vida = vida;
    this.manaMaxima = mana;
    this.mana = mana;
    this.forca = forca;
    this.destreza = destreza;
    this.inteligencia = inteligencia;
    this.statusEffects = new ArrayList<>();
  }

  /**
   * Este é o método "setStrategy" do padrão.
   * Ele troca o algoritmo de ataque em tempo de execução.
   */
  public void equiparArma(ArmaStrategy novaArma) {
    if (podeUsarTipoArma(novaArma) && novaArma.podeEquipar(this)) {
      this.armaEquipada = novaArma;
      System.out.println(nome + " equipou " + novaArma.getClass().getSimpleName() + "!");
    } else {
      System.out
          .println(nome + " falhou em equipar " + novaArma.getClass().getSimpleName() + ". Requisitos não atendidos.");
    }
  }

  /**
   * Este é o método "executeStrategy" do padrão.
   * O Contexto (Personagem) delega a ação para a Estratégia (Arma).
   */
  public void atacar(Personagem alvo, List<Personagem> inimigos) {
    if (this.armaEquipada == null) {
      System.out.println(nome + " está desarmado e não pode atacar!");
      return;
    }
    if (this.mana < this.armaEquipada.getClass().getSimpleName().hashCode()) { // Apenas um exemplo de custo de mana
      // A lógica de custo de mana real está na própria arma
    }

    System.out.println("--- Turno de " + nome + " ---");
    this.armaEquipada.usar(this, alvo, inimigos);
  }

  // Métodos de gerenciamento de estado

  public void receberDano(int dano) {
    this.vida -= dano;
    System.out.println(nome + " recebeu " + dano + " de dano. Vida restante: " + this.vida);
    if (!estaVivo()) {
      System.out.println(nome + " foi derrotado!");
    }
  }

  public void gastarMana(int custo) {
    this.mana -= custo;
  }

  public void aplicarStatus(StatusEffect effect) {
    System.out.println(nome + " está sofrendo de " + effect.getNome() + "!");
    this.statusEffects.add(effect);
  }

  public void processarTurno() {
    // Resetar status de turno
    this.estaAtordoado = false;

    // Aplicar passiva da classe
    this.aplicarPassiva();

    // Processar efeitos de status (como sangramento, queimadura)
    Iterator<StatusEffect> iterator = statusEffects.iterator();
    while (iterator.hasNext()) {
      StatusEffect effect = iterator.next();
      effect.aplicar(this);
      if (!effect.estaAtivo()) {
        System.out.println(effect.getNome() + " acabou em " + nome + ".");
        iterator.remove();
      }
    }
  }

  // Métodos abstratos para subclasses
  public abstract boolean podeUsarTipoArma(ArmaStrategy arma);

  public abstract void aplicarPassiva();

  // Getters e Setters
  public boolean estaVivo() {
    return this.vida > 0;
  }

  public String getNome() {
    return nome;
  }

  public int getForca() {
    return forca;
  }

  public int getDestreza() {
    return destreza;
  }

  public int getInteligencia() {
    return inteligencia;
  }

  public int getMana() {
    return mana;
  }

  public boolean estaAtordoado() {
    return estaAtordoado;
  }

  public void setAtordoado(boolean atordoado) {
    this.estaAtordoado = atordoado;
  }

  @Override
  public String toString() {
    return String.format("%s (HP: %d/%d, MP: %d/%d)", nome, vida, vidaMaxima, mana, manaMaxima);
  }
}