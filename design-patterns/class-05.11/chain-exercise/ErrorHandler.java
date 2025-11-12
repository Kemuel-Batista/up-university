/**
 * ConcreteHandler 4: Processa logs ERROR e simula envio de e-mail.
 * Este é o último da cadeia.
 */
public class ErrorHandler extends AbstractLogHandler {
  public ErrorHandler() {
    super("ERROR");
  }

  @Override
  protected void handle(LogMessage log) {
    // Ação específica: Simular envio de e-mail
    System.out.println("\n>>> SIMULANDO ENVIO DE E-MAIL DE ALERTA <<<");
    System.out.println("Para: sysadmin@empresa.com");
    System.out.println("Assunto: ALERTA DE ERRO NO SISTEMA");
    System.out.println("Timestamp: " + log.getTimestamp());
    System.out.println("Mensagem: " + log.getMensagem());
    System.out.println(">>> FIM DA SIMULAÇÃO <<<\n");
  }
}