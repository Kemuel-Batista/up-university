import java.util.Stack;

public class ValidationClient {

  public static void main(String[] args) {

    // 1. Monta a Cadeia de Validadores
    AbstractValidator chain = new XmlSchemaValidator(100);

    chain.setNext(new CertificadoDigitalValidator(300))
        .setNext(new RegrasFiscaisValidator(500))
        .setNext(new DbDuplicidadeValidator(200)) // Com Rollback
        .setNext(new SefazValidator(150)); // Condicional e com Timeout

    // 2. Cria o Documento e o Contexto
    NFeDocument doc = new NFeDocument("<nfe>...</nfe>");
    ValidationContext context = new ValidationContext(doc);

    System.out.println("--- INICIANDO VALIDAÇÃO DA NF-e ---");

    // 3. Inicia a cadeia
    try {
      chain.validate(context);
    } catch (Exception e) {
      System.err.println("Erro fatal no motor de validação: " + e.getMessage());
    }

    System.out.println("--- VALIDAÇÃO CONCLUÍDA ---");

    // 4. PÓS-PROCESSAMENTO: Verificação de Falhas e Rollback
    if (context.hasFailures()) {
      System.out.println("\nResultado: FALHA NA VALIDAÇÃO.");
      System.out.println("Erros encontrados:");
      context.getFailures().forEach(err -> System.out.println("- " + err));

      // REQUISITO 4: O Cliente orquestra o rollback
      if (!context.getRollbackStack().isEmpty()) {
        System.err.println("\n--- INICIANDO ROLLBACK (devido a falhas) ---");
        Stack<Rollbackable> stack = context.getRollbackStack();
        while (!stack.isEmpty()) {
          stack.pop().rollback(context);
        }
      }
    } else {
      System.out.println("\nResultado: SUCESSO. NFe validada e processada.");
      // Aqui você faria o "commit" final no DB (mudar de PENDENTE para APROVADO)
    }
  }
}