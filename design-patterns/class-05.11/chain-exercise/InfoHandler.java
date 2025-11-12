import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteHandler 2: Processa logs INFO e armazena em uma lista interna.
 */
public class InfoHandler extends AbstractLogHandler {
  private final List<LogMessage> infoLogs = new ArrayList<>();

  public InfoHandler() {
    super("INFO");
  }

  @Override
  protected void handle(LogMessage log) {
    System.out.println("(Log INFO armazenado na lista)");
    infoLogs.add(log);
  }

  public void printStoredLogs() {
    System.out.println("\n--- Logs INFO Armazenados ---");
    if (infoLogs.isEmpty()) {
      System.out.println("(Nenhum log INFO foi processado)");
    } else {
      infoLogs.forEach(System.out::println);
    }
    System.out.println("-----------------------------\n");
  }
}