public class LegacyTwitterAdapter implements ISocialMediaAdapter {
  private final TwitterApi twitterApi; // The Adaptee
  private String apiKey;

  public LegacyTwitterAdapter(TwitterApi twitterApi) {
    this.twitterApi = twitterApi;
  }

  @Override
  public boolean authenticate(String user, String secret) {
    // Adaptation logic
    this.apiKey = secret;
    System.out.println("TwitterAdapter: API Key stored.");
    return this.apiKey != null;
  }

  @Override
  public Publication publish(Content content) {
    if (apiKey == null)
      throw new RuntimeException("TwitterAdapter: Authentication required.");
    // Adaptation logic
    String url = twitterApi.postTweet(this.apiKey, content.getText());
    return new Publication(url.substring(url.lastIndexOf('/') + 1), url);
  }
}
