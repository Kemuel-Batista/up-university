public class RelatorioSemanalFactory implements RelatorioFactory {
  @Override
  public Relatorio criarRelatorio() {
    return new RelatorioSemanal();
  }
}