/**
 * A classe base abstrata (Handler).
 * Ela gerencia o próximo handler na cadeia e define a lógica
 * principal de processamento (passando a bola).
 */
public abstract class AbstractLogHandler {

  protected AbstractLogHandler nextHandler;
  protected String levelToHandle;

  /**
   * Define qual nível este handler específico irá tratar.
   */
  public AbstractLogHandler(String levelToHandle) {
    this.levelToHandle = levelToHandle;
  }

  /**
   * Método para construir a cadeia.
   * Retorna o próximo handler para permitir encadeamento (fluent interface).
   * ex: h1.setNext(h2).setNext(h3);
   */
  public AbstractLogHandler setNext(AbstractLogHandler handler) {
    this.nextHandler = handler;
    return handler;
  }

  /**
   * Este é o "Template Method". Ele define a lógica da cadeia.
   * A classe cliente (Client) só chama este método.
   */
  public void processarLog(LogMessage log) {
    // 1. Se eu sou o responsável por este nível, eu trato.
    if (this.levelToHandle.equals(log.getNivel())) {
      this.handle(log);
    }
    // 2. Se não sou eu, mas existe um próximo, eu passo adiante.
    else if (nextHandler != null) {
      nextHandler.processarLog(log);
    }
    // 3. Se não sou eu E não há próximo (fim da cadeia), o log não é tratado.
    else {
      System.err.println("FIM DA CADEIA: Log não tratado: " + log.getMensagem());
    }
  }

  /**
   * Método abstrato que as classes filhas (Concrete Handlers)
   * devem implementar com sua lógica específica.
   */
  protected abstract void handle(LogMessage log);
}