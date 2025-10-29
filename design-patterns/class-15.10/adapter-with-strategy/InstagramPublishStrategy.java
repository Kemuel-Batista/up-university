public class InstagramPublishStrategy implements IPublishStrategy {
  private final ISocialMediaAdapter adapter;

  public InstagramPublishStrategy(ISocialMediaAdapter adapter) {
    this.adapter = adapter;
  }

  @Override
  public boolean executeAuth(String user, String secret) {
    System.out.println("[InstagramStrategy] Delegating auth to adapter...");
    return this.adapter.authenticate(user, secret);
  }

  @Override
  public Publication executePublish(Content content) {
    System.out.println("[InstagramStrategy] Delegating publication to adapter...");
    return this.adapter.publish(content);
  }
}