public class RegrasFiscaisValidator extends AbstractValidator {
  public RegrasFiscaisValidator(int timeout) {
    super(timeout);
  }

  protected String getName() {
    return "Regras Fiscais (Impostos)";
  }

  // REQUISITO 2: Só executa se anteriores passaram
  @Override
  protected boolean shouldSkip(ValidationContext context) {
    return context.hasFailures();
  }

  @Override
  protected void performValidation(ValidationContext context) {
    // Simulação: Falha 3 (ativaria o Circuit Breaker)
    // context.addFailure("Cálculo de ICMS inconsistente.");

    // Simulação: Passou
    System.out.println("   ... Impostos OK.");
  }
}