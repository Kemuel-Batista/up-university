class LinkedInPublishStrategy implements IPublishStrategy {
  private final ISocialMediaAdapter adapter;

  public LinkedInPublishStrategy(ISocialMediaAdapter adapter) {
    this.adapter = adapter;
  }

  @Override
  public boolean executeAuth(String user, String secret) {
    System.out.println("[LinkedInStrategy] Delegating auth to adapter...");
    return this.adapter.authenticate(user, secret);
  }

  @Override
  public Publication executePublish(Content content) {
    System.out.println("[LinkedInStrategy] Delegating publication to adapter...");
    return this.adapter.publish(content);
  }
}