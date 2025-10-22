public class ReaderSubscription extends TopicListener {
  private String readerName;

  public ReaderSubscription(String readerName, Topic topic) {
    this.readerName = readerName;
    this.topic = topic;
    this.topic.attach(this);
    System.out.println("[SISTEMA] " + readerName + " acabou de se inscrever em '" + topic.getName() + "'.");
  }

  @Override
  void process() {
    String topicName = this.topic.getName();
    String articleTitle = this.topic.getLatestArticleTitle();

    System.out.println("  -> [NOTIFICAÇÃO] Olá, " + this.readerName + "! Chegou uma nova notícia em '" + topicName
        + "': " + articleTitle);
  }
}