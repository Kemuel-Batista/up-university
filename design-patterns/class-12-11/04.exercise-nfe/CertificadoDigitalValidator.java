public class CertificadoDigitalValidator extends AbstractValidator {
  public CertificadoDigitalValidator(int timeout) {
    super(timeout);
  }

  protected String getName() {
    return "Certificado Digital";
  }

  @Override
  protected void performValidation(ValidationContext context) {
    // Simulação: Falha 2
    // context.addFailure("Certificado expirado.");

    // Simulação: Passou
    System.out.println("   ... Certificado OK.");
  }
}