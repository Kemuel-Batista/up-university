public class InstagramApi {
  public boolean login(String u, String p) {
    return true;
  }

  public String publishPhoto(byte[] data, String caption) {
    System.out.println("[InstagramApi] Uploading image (" + data.length + " bytes). Caption: '" + caption + "'");
    return "https://instagram.com/p/" + System.currentTimeMillis();
  }
}
