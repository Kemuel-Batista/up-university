import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ConcreteHandler 3: Processa logs WARNING e escreve em um arquivo.
 */
public class WarningHandler extends AbstractLogHandler {

  private final String logFile = "warnings.log";

  public WarningHandler() {
    super("WARNING");
  }

  @Override
  protected void handle(LogMessage log) {
    String logEntry = "[FILE WARNING]: " + log.getTimestamp() + " - " + log.getMensagem();
    System.out.println("(Log WARNING sendo escrito em " + logFile + ")");

    try (FileWriter fw = new FileWriter(logFile, true);
        PrintWriter pw = new PrintWriter(fw)) {

      pw.println(logEntry);

    } catch (IOException e) {
      System.err.println("Falha ao escrever log de WARNING: " + e.getMessage());
    }
  }
}