public interface IPublishStrategy {
  boolean executeAuth(String user, String secret);

  Publication executePublish(Content content);
}