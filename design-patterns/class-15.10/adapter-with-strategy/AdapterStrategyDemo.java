public class AdapterStrategyDemo {
  public static void main(String[] args) {
    // --- Cria os conteúdos ---
    Content twitterPost = new Content("This shows all layers: Context > Strategy > Adapter > Adaptee");
    byte[] myPhoto = new byte[] { 0x1, 0x2, 0x3 };
    Content instagramPost = new Content("Clear separation of concerns!", myPhoto);
    Content linkedInPost = new Content("Design Patterns in practice.", "https://my.blog/layered-patterns");

    // --- EXECUTANDO O TWITTER ---
    System.out.println("==================================================");
    System.out.println("EXECUTING TWITTER STRATEGY");
    System.out.println("==================================================");

    // 1. Cria o Adaptee (A API Legada)
    TwitterApi twitterApi = new TwitterApi();
    // 2. Cria o Adapter, injetando o Adaptee
    ISocialMediaAdapter twitterAdapter = new LegacyTwitterAdapter(twitterApi);
    // 3. Cria a Strategy, injetando o Adapter
    IPublishStrategy twitterStrategy = new TwitterPublishStrategy(twitterAdapter);
    // 4. Cria o Context, injetando a Strategy
    SocialMediaContext context = new SocialMediaContext(twitterStrategy);

    // 5. O Cliente usa o Context, que delega para a Strategy...
    context.executeAuth("ignored", "myTwitterApiKey123");
    // ...que delega para o Adapter, que traduz para o Adaptee.
    Publication pubTwitter = context.executePublish(twitterPost);
    System.out.println("Success! " + pubTwitter);

    // --- EXECUTANDO O INSTAGRAM ---
    System.out.println("\n==================================================");
    System.out.println("EXECUTING INSTAGRAM STRATEGY");
    System.out.println("==================================================");

    // 1. Cria o Adaptee
    InstagramApi instagramApi = new InstagramApi();
    // 2. Cria o Adapter
    ISocialMediaAdapter instagramAdapter = new LegacyInstagramAdapter(instagramApi);
    // 3. Cria a Strategy
    IPublishStrategy instaStrategy = new InstagramPublishStrategy(instagramAdapter);

    // 4. O Cliente apenas troca a Strategy no Context
    context.setStrategy(instaStrategy);

    // 5. O Context executa a nova Strategy
    context.executeAuth("myInstaUser", "myInstaPassword456");
    Publication pubInsta = context.executePublish(instagramPost);
    System.out.println("Success! " + pubInsta);

    // --- EXECUTANDO O LINKEDIN ---
    System.out.println("\n==================================================");
    System.out.println("EXECUTING LINKEDIN STRATEGY");
    System.out.println("==================================================");

    // O cliente pode criar e trocar a Strategy + Adapter em uma linha
    context.setStrategy(
        new LinkedInPublishStrategy(
            new LegacyLinkedInAdapter(
                new LinkedInApi())));

    context.executeAuth("ignored", "myLinkedInOAuthToken789");
    Publication pubLinkedIn = context.executePublish(linkedInPost);
    System.out.println("Success! " + pubLinkedIn);
  }
}
