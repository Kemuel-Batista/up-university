public class LegacyLinkedInAdapter implements ISocialMediaAdapter {
  private final LinkedInApi linkedInApi; // The Adaptee

  public LegacyLinkedInAdapter(LinkedInApi linkedInApi) {
    this.linkedInApi = linkedInApi;
  }

  @Override
  public boolean authenticate(String user, String secret) {
    // Adaptation logic
    linkedInApi.authenticate(secret);
    return true;
  }

  @Override
  public Publication publish(Content content) {
    if (content.getArticleUrl() == null)
      throw new RuntimeException("LinkedInAdapter: ERROR: Content has no article URL.");
    // Adaptation logic
    String url = linkedInApi.shareArticle(content.getText(), content.getArticleUrl());
    return new Publication(url.substring(url.lastIndexOf('/') + 1), url);
  }
}