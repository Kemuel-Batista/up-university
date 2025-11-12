import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe que representa a solicitação (Request) a ser passada pela cadeia.
 * Contém os dados do log.
 */
public class LogMessage {
  private final String nivel;
  private final String mensagem;
  private final LocalDateTime timestamp;

  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  public LogMessage(String nivel, String mensagem) {
    this.nivel = nivel;
    this.mensagem = mensagem;
    this.timestamp = LocalDateTime.now();
  }

  // Getters
  public String getNivel() {
    return nivel;
  }

  public String getMensagem() {
    return mensagem;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  @Override
  public String toString() {
    return "LogMessage [" +
        "nivel='" + nivel + '\'' +
        ", mensagem='" + mensagem + '\'' +
        ", timestamp=" + timestamp.format(FORMATTER) +
        ']';
  }
}