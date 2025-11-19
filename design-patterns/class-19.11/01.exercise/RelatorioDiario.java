public class RelatorioDiario implements Relatorio {
  @Override
  public void gerar() {
    System.out.println("Gerando Relatório Diário: Priorizando métricas das últimas 24h...");
  }
}