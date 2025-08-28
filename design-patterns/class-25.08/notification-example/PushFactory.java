public class PushFactory extends NotificationFactory {
  @Override
  public Notificacao createNotification() {
    return new NotificationPush();
  }
}