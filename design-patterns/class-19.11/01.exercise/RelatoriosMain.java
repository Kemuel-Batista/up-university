public class RelatoriosMain {
  public static void main(String[] args) {
    SistemaRelatorios sistema = new SistemaRelatorios();

    // Gerando um relatório diário
    sistema.processarRelatorio(new RelatorioDiarioFactory());

    // Gerando um relatório semanal
    sistema.processarRelatorio(new RelatorioSemanalFactory());

    // Se no futuro precisarmos do "RelatorioEmergencial",
    // basta criar a classe do relatório e sua factory, sem tocar no
    // "SistemaRelatorios".
  }
}
