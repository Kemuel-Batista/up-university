public class Content {
  private String text;
  private byte[] image; // Used by Instagram
  private String articleUrl; // Used by LinkedIn

  public Content(String text) {
    this.text = text;
  }

  public Content(String text, byte[] image) {
    this.text = text;
    this.image = image;
  }

  public Content(String text, String articleUrl) {
    this.text = text;
    this.articleUrl = articleUrl;
  }

  // Getters
  public String getText() {
    return text;
  }

  public byte[] getImage() {
    return image;
  }

  public String getArticleUrl() {
    return articleUrl;
  }
}
