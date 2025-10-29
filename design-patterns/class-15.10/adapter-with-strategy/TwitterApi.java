public class TwitterApi {
  public String postTweet(String apiKey, String content) {
    System.out.println("[TwitterApi] Posting tweet: '" + content + "'");
    return "https://twitter.com/user/status/" + System.currentTimeMillis();
  }
}
