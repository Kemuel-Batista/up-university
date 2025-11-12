/**
 * A classe Cliente (Client).
 * Ela é responsável por montar a cadeia e iniciar as solicitações.
 * Ela só conhece o *primeiro* handler.
 */
public class LogProcessorClient {

  public static void main(String[] args) {

    // --- 1. Montagem da Cadeia ---

    // Precisamos guardar a referência do infoHandler para checar a lista no final
    InfoHandler infoHandler = new InfoHandler();

    // O primeiro handler é o ponto de entrada
    AbstractLogHandler chain = new DebugHandler();

    // Configura a cadeia: Debug -> Info -> Warning -> Error
    chain.setNext(infoHandler)
        .setNext(new WarningHandler())
        .setNext(new ErrorHandler());

    // --- 2. Envio das Solicitações (Logs) ---

    System.out.println("--- Iniciando Processamento de Logs ---");

    // Teste 1: Deve ser pego pelo ErrorHandler
    chain.processarLog(new LogMessage("ERROR", "Falha crítica na conexão com o banco de dados."));

    // Teste 2: Deve ser pego pelo InfoHandler
    chain.processarLog(new LogMessage("INFO", "Usuário 'admin' logado com sucesso."));

    // Teste 3: Deve ser pego pelo DebugHandler
    chain.processarLog(new LogMessage("DEBUG", "Valor da variável X = 10 na linha 52."));

    // Teste 4: Deve ser pego pelo WarningHandler
    chain.processarLog(new LogMessage("WARNING", "API de pagamento demorando mais de 5s para responder."));

    // Teste 5: Deve ser pego pelo InfoHandler
    chain.processarLog(new LogMessage("INFO", "Processo de batch 'JOB_X' iniciado."));

    // Teste 6: Não deve ser pego por ninguém
    chain.processarLog(new LogMessage("FATAL", "Nível de log desconhecido."));

    System.out.println("--- Fim do Processamento de Logs ---");

    // --- 3. Verificação (Regra Adicional) ---

    // Verifica a lista em memória do InfoHandler
    infoHandler.printStoredLogs();
  }
}