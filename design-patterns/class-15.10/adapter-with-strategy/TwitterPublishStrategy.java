public class TwitterPublishStrategy implements IPublishStrategy {
  private final ISocialMediaAdapter adapter;

  public TwitterPublishStrategy(ISocialMediaAdapter adapter) {
    this.adapter = adapter;
  }

  @Override
  public boolean executeAuth(String user, String secret) {
    System.out.println("[TwitterStrategy] Delegating auth to adapter...");
    return this.adapter.authenticate(user, secret);
  }

  @Override
  public Publication executePublish(Content content) {
    System.out.println("[TwitterStrategy] Delegating publication to adapter...");
    return this.adapter.publish(content);
  }
}