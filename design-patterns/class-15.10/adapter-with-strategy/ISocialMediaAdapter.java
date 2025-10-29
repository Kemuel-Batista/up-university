public interface ISocialMediaAdapter {
  boolean authenticate(String user, String secret);

  Publication publish(Content content);
}
