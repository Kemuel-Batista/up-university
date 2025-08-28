public class NotificationPush implements Notificacao {
  @Override
  public void enviar(String mensagem) {
    System.out.println("Enviando push notification: " + mensagem);
  }
}