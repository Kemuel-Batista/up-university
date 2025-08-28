public class NotificationService {
  public void sendNotification(NotificationFactory factory, String message) {
    Notificacao notification = factory.createNotification();
    notification.enviar(message);
  }
}