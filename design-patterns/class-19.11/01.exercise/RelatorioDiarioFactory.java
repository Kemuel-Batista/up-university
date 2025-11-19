public class RelatorioDiarioFactory implements RelatorioFactory {
  @Override
  public Relatorio criarRelatorio() {
    return new RelatorioDiario();
  }
}