public class LinkedInApi {
  private String oauthToken;

  public void authenticate(String token) {
    this.oauthToken = token;
  }

  public String shareArticle(String comment, String url) {
    if (oauthToken == null)
      throw new RuntimeException("[LinkedInApi] ERROR: Not authenticated.");
    System.out.println("[LinkedInApi] Sharing article: " + url + " with comment: '" + comment + "'");
    return "https://linkedin.com/feed/update/" + System.currentTimeMillis();
  }
}
