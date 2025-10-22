import java.util.ArrayList;
import java.util.List;

public class Topic {
  private String name;
  private String latestArticleTitle;
  private List<TopicListener> subscribers = new ArrayList<TopicListener>();

  public Topic(String name) {
    this.name = name;
  }

  // Método que muda o estado e notifica os observadores
  public void publishNewArticle(String articleTitle) {
    this.latestArticleTitle = articleTitle;
    System.out.println("\n[SISTEMA] Nova notícia publicada no tópico '" + this.name + "': " + articleTitle);

    // Notifica todos os inscritos
    this.notifyAllSubscribers();
  }

  // Método de notificação
  private void notifyAllSubscribers() {
    for (TopicListener obs : this.subscribers) {
      obs.process();
    }
  }

  // Método de inscrição
  public void attach(TopicListener observer) {
    this.subscribers.add(observer);
  }

  // Método de remoção
  public void detach(TopicListener observer) {
    this.subscribers.remove(observer);
  }

  // Getters para que os observadores possam "puxar" (pull) a informação
  public String getName() {
    return this.name;
  }

  public String getLatestArticleTitle() {
    return this.latestArticleTitle;
  }
}