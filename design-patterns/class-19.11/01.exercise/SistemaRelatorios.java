public class SistemaRelatorios {
  public void processarRelatorio(RelatorioFactory factory) {
    // O sistema não sabe se é diário ou semanal, ele apenas pede para criar e gerar
    Relatorio relatorio = factory.criarRelatorio();
    relatorio.gerar();
  }
}
