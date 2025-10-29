public class LegacyInstagramAdapter implements ISocialMediaAdapter {
  private final InstagramApi instagramApi; // The Adaptee
  private boolean loggedIn = false;

  public LegacyInstagramAdapter(InstagramApi instagramApi) {
    this.instagramApi = instagramApi;
  }

  @Override
  public boolean authenticate(String user, String secret) {
    // Adaptation logic
    this.loggedIn = instagramApi.login(user, secret);
    return this.loggedIn;
  }

  @Override
  public Publication publish(Content content) {
    if (!loggedIn)
      throw new RuntimeException("InstagramAdapter: Login required.");
    if (content.getImage() == null)
      throw new RuntimeException("InstagramAdapter: ERROR: Content has no image.");
    // Adaptation logic
    String url = instagramApi.publishPhoto(content.getImage(), content.getText());
    return new Publication(url.substring(url.lastIndexOf('/') + 1), url);
  }
}