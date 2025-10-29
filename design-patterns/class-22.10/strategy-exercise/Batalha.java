import java.util.List;
import java.util.stream.Collectors;

public class Batalha {
  private List<Personagem> timeHerois;
  private List<Personagem> timeInimigos;
  private int turno;

  public Batalha(List<Personagem> timeHerois, List<Personagem> timeInimigos) {
    this.timeHerois = timeHerois;
    this.timeInimigos = timeInimigos;
    this.turno = 0;
  }

  public void iniciarBatalha() {
    System.out.println("====== A BATALHA COMEÇA! ======");

    while (!batalhaTerminou()) {
      turno++;
      System.out.println("\n====== TURNO " + turno + " ======");

      // Turno dos Heróis
      executarTurnos(timeHerois, timeInimigos);

      if (batalhaTerminou())
        break;

      // Turno dos Inimigos
      executarTurnos(timeInimigos, timeHerois);

      // Simulação de troca de arma (Extensão)
      if (turno == 2) {
        // Supondo que o guerreiro esteja no time de heróis
        Personagem guerreiro = timeHerois.stream()
            .filter(p -> p instanceof Guerreiro)
            .findFirst().orElse(null);
        if (guerreiro != null) {
          System.out.println("\n[EVENTO] " + guerreiro.getNome() + " troca de arma no meio da batalha!");
          guerreiro.equiparArma(new MachadoDeGuerra()); // Troca para o Machado
        }
      }
    }

    System.out.println("\n====== A BATALHA TERMINOU! ======");
    if (getInimigosVivos(timeHerois).isEmpty()) {
      System.out.println("Os Inimigos venceram!");
    } else {
      System.out.println("Os Heróis venceram!");
    }
  }

  private void executarTurnos(List<Personagem> atacantes, List<Personagem> defensores) {
    List<Personagem> defensoresVivos = getInimigosVivos(defensores);
    if (defensoresVivos.isEmpty())
      return;

    for (Personagem atacante : atacantes) {
      if (!atacante.estaVivo())
        continue;

      // 1. Processar passivas de início de turno e status (queimadura, etc.)
      atacante.processarTurno();

      // 2. Verificar se o personagem está vivo e não atordoado
      if (atacante.estaVivo() && !atacante.estaAtordoado()) {
        // Lógica de seleção de alvo (simplificada: ataca o primeiro vivo)
        Personagem alvoPrincipal = defensoresVivos.get(0);

        // 3. Atacar (delegar para a Strategy)
        atacante.atacar(alvoPrincipal, defensoresVivos);

        // Atualizar lista de defensores vivos
        defensoresVivos = getInimigosVivos(defensores);
        if (defensoresVivos.isEmpty())
          break;
      } else if (atacante.estaAtordoado()) {
        System.out.println(atacante.getNome() + " está atordoado e não pode agir!");
      }
    }
  }

  private boolean batalhaTerminou() {
    return getInimigosVivos(timeHerois).isEmpty() || getInimigosVivos(timeInimigos).isEmpty();
  }

  private List<Personagem> getInimigosVivos(List<Personagem> time) {
    return time.stream().filter(Personagem::estaVivo).collect(Collectors.toList());
  }
}