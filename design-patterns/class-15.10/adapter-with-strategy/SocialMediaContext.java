public class SocialMediaContext {
  private IPublishStrategy strategy;

  public SocialMediaContext(IPublishStrategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(IPublishStrategy strategy) {
    this.strategy = strategy;
    System.out.println("\n[Context] Strategy has been changed to: " + strategy.getClass().getSimpleName());
  }

  public boolean executeAuth(String user, String secret) {
    return this.strategy.executeAuth(user, secret);
  }

  public Publication executePublish(Content content) {
    return this.strategy.executePublish(content);
  }
}
