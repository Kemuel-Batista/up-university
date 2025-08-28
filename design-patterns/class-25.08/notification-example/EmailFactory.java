public class EmailFactory extends NotificationFactory {
  @Override
  public Notificacao createNotification() {
    return new NotificationEmail();
  }
}