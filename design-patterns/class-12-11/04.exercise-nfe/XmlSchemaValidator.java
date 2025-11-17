public class XmlSchemaValidator extends AbstractValidator {
  public XmlSchemaValidator(int timeout) {
    super(timeout);
  }

  protected String getName() {
    return "Schema XML/XSD";
  }

  @Override
  protected void performValidation(ValidationContext context) {
    // Simulação: Falha 1
    // if (context.getDocument().getContent().contains("erro-xml")) {
    // context.addFailure("Formato XML inválido.");
    // }

    // Simulação: Passou
    System.out.println("   ... XML OK.");
  }
}