public class PdfDecorator extends ReportDecorator {
  public PdfDecorator(Report report) {
    super(report);
  }

  @Override
  public String generate() {
    // 1. Pega o relatório anterior
    String baseReport = super.generate();

    // 2. Adiciona sua própria funcionalidade
    String pdf = "\n+ [Exportando para PDF ...]";

    return baseReport + pdf;
  }
}