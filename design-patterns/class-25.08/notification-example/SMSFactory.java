public class SMSFactory extends NotificationFactory {
  @Override
  public Notificacao createNotification() {
    return new NotificationSMS();
  }
}