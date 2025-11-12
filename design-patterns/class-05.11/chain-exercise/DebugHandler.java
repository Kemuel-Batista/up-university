/**
 * ConcreteHandler 1: Processa logs DEBUG e imprime no console.
 */
public class DebugHandler extends AbstractLogHandler {
  public DebugHandler() {
    super("DEBUG");
  }

  @Override
  protected void handle(LogMessage log) {
    // Ação específica: Imprimir no console
    System.out.println("[CONSOLE DEBUG]: " + log.getTimestamp() + " - " + log.getMensagem());
  }
}