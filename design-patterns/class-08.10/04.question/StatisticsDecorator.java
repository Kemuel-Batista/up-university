public class StatisticsDecorator extends ReportDecorator {
  public StatisticsDecorator(Report report) {
    super(report);
  }

  @Override
  public String generate() {
    // 1. Pega o relatório anterior (do objeto embrulhado)
    String baseReport = super.generate();

    // 2. Adiciona sua própria funcionalidade
    String statistics = "\n+ [Adicionando Estatísticas de Faturamento ...]";

    return baseReport + statistics;
  }
}