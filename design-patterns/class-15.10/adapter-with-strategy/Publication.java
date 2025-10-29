public class Publication {
  private String id;
  private String platformUrl;

  public Publication(String id, String platformUrl) {
    this.id = id;
    this.platformUrl = platformUrl;
  }

  @Override
  public String toString() {
    return "Publication [id=" + id + ", url=" + platformUrl + "]";
  }
}
