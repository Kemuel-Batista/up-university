public class ReportSystem {
  public static void main(String[] args) {

    // 1. Gerar um relatório básico
    Report basicReport = new BasicReport();
    System.out.println("--- Relatório Básico ---");
    System.out.println(basicReport.generate());
    System.out.println("------------------------\n");

    // 2. Gerar um relatório com estatísticas
    // Note que "decoramos" o relatório básico
    Report reportWithStats = new StatisticsDecorator(basicReport);
    System.out.println("--- Relatório com Estatísticas ---");
    System.out.println(reportWithStats.generate());
    System.out.println("----------------------------------\n");

    // 3. Gerar um relatório com estatísticas e gráficos
    // Note que "decoramos" o relatório que JÁ TINHA estatísticas
    Report reportWithStatsAndCharts = new ChartDecorator(reportWithStats);
    System.out.println("--- Relatório com Estatísticas e Gráficos ---");
    System.out.println(reportWithStatsAndCharts.generate());
    System.out.println("---------------------------------------------\n");

    // 4. Gerar um relatório completo (Estatísticas, Gráficos e PDF)
    // Podemos "embrulhar" tudo de uma vez só
    Report fullReport = new PdfDecorator(
        new ChartDecorator(
            new StatisticsDecorator(
                new BasicReport() // Um novo relatório básico
            )));

    System.out.println("--- Relatório Completo (Stats, Gráfico, PDF) ---");
    System.out.println(fullReport.generate());
    System.out.println("------------------------------------------------\n");

    // 5. Gerar um relatório com Gráficos e PDF (mas sem estatísticas)
    // Demonstrando a flexibilidade
    Report chartAndPdfReport = new PdfDecorator(
        new ChartDecorator(
            new BasicReport()));

    System.out.println("--- Relatório com Gráfico e PDF ---");
    System.out.println(chartAndPdfReport.generate());
    System.out.println("-----------------------------------\n");
  }
}