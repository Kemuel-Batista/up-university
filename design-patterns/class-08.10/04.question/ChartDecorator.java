public class ChartDecorator extends ReportDecorator {
  public ChartDecorator(Report report) {
    super(report);
  }

  @Override
  public String generate() {
    // 1. Pega o relatório anterior
    String baseReport = super.generate();

    // 2. Adiciona sua própria funcionalidade
    String chart = "\n+ [Adicionando Gráficos de Vendas ...]";

    return baseReport + chart;
  }
}