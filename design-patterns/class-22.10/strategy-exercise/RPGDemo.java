import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * O StrategyDemo.
 * Configura o cenário de RPG e inicia a batalha.
 */
public class RPGDemo {
  public static void main(String[] args) {

    // 1. Criar as armas (As Estratégias)
    ArmaStrategy espada = new EspadaLonga();
    ArmaStrategy arco = new ArcoElfico();
    ArmaStrategy cajado = new CajadoArcano();
    ArmaStrategy machado = new MachadoDeGuerra();
    ArmaStrategy adaga = new AdagaSombria();

    // 2. Criar os personagens (Os Contextos)
    Personagem garen = new Guerreiro("Garen");
    Personagem ashe = new Arqueiro("Ashe");
    Personagem veigar = new Mago("Veigar");

    // Extensão: Personagem Híbrido
    Personagem uther = new Paladino("Uther");

    // 3. Equipar armas (Definir a Estratégia)
    garen.equiparArma(espada); // garen.setStrategy(new EspadaLonga())
    ashe.equiparArma(arco); // ashe.setStrategy(new ArcoElfico())
    uther.equiparArma(cajado); // uther.setStrategy(new CajadoArcano())

    System.out.println("--- Teste de Requisito Falho ---");
    garen.equiparArma(cajado); // Guerreiro não pode usar Cajado (falha tipo)
    veigar.equiparArma(machado); // Mago não tem Força para Machado (falha atributo)
    System.out.println("---------------------------------");

    // Mago inimigo equipa sua arma
    veigar.equiparArma(cajado);

    // 4. Configurar a Batalha
    List<Personagem> herois = new ArrayList<>(Arrays.asList(garen, ashe, uther));
    List<Personagem> inimigos = new ArrayList<>(Arrays.asList(veigar));

    Batalha arena = new Batalha(herois, inimigos);

    // 5. Iniciar a Batalha (Executar as Estratégias)
    arena.iniciarBatalha();
  }
}