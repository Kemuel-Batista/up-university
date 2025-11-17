public class SefazValidator extends AbstractValidator {
  public SefazValidator(int timeout) {
    super(timeout);
  }

  protected String getName() {
    return "Consulta Serviço SEFAZ";
  }

  // REQUISITO 2: Só executa se anteriores passaram
  @Override
  protected boolean shouldSkip(ValidationContext context) {
    return context.hasFailures();
  }

  @Override
  protected void performValidation(ValidationContext context) throws Exception {
    System.out.println("   ... Consultando SEFAZ (Web Service)...");

    // Simulação 1: Timeout (REQUISITO 5)
    // Thread.sleep(200); // Simula uma consulta de 200ms

    // Simulação 2: Falha de negócio (que causará rollback no DB)
    // context.addFailure("SEFAZ rejeitou: Lote de NFe já processado.");

    // Simulação 3: Passou
    System.out.println("   ... SEFAZ OK.");
  }
}