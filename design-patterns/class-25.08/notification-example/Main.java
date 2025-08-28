public class Main {
  public static void main(String[] args) {
    NotificationService service = new NotificationService();
    
    service.sendNotification(new EmailFactory(), "Hello via Email!");

    service.sendNotification(new SMSFactory(), "Hello via SMS!");

    service.sendNotification(new PushFactory(), "Hello via Push Notification!");
  }
}