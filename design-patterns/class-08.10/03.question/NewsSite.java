// Consumidor (Cliente)
public class NewsSite {
  public static void main(String[] args) {
    // 1. Criar os múltiplos tópicos (Sujeitos)
    Topic politics = new Topic("Política");
    Topic sports = new Topic("Esportes");
    Topic technology = new Topic("Tecnologia");

    // 2. Criar os múltiplos leitores e inscrevê-los
    // A leitora "Ana" se inscreve em Política e Tecnologia
    ReaderSubscription anaPolitics = new ReaderSubscription("Ana", politics);
    ReaderSubscription anaTech = new ReaderSubscription("Ana", technology);

    // O leitor "Bruno" se inscreve apenas em Esportes
    ReaderSubscription brunoSports = new ReaderSubscription("Bruno", sports);

    // A leitora "Carla" se inscreve em todos os tópicos
    ReaderSubscription carlaPolitics = new ReaderSubscription("Carla", politics);
    ReaderSubscription carlaSports = new ReaderSubscription("Carla", sports);
    ReaderSubscription carlaTech = new ReaderSubscription("Carla", technology);

    // 3. Publicar notícias (mudar o estado dos Sujeitos)
    // Apenas Ana e Carla devem ser notificadas
    politics.publishNewArticle("Novas Medidas Econômicas Anunciadas");

    // Apenas Bruno e Carla devem ser notificados
    sports.publishNewArticle("Resultado da Final do Campeonato");

    // Apenas Ana e Carla devem ser notificadas
    technology.publishNewArticle("Lançamento do Novo Processador");

    // 4. Demonstração da remoção (detach)
    System.out.println("\n[SISTEMA] Ana cancelou a inscrição em 'Tecnologia'.");
    technology.detach(anaTech); // 'anaTech' é o objeto observador

    // Agora, apenas Carla deve ser notificada sobre Tecnologia
    technology.publishNewArticle("Atualização de Segurança Crítica");
  }
}