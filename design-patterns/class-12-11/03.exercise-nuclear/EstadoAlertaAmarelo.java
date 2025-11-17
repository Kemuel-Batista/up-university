public class EstadoAlertaAmarelo implements EstadoUsina {
  private UsinaNuclear usina;

  public EstadoAlertaAmarelo(UsinaNuclear usina) {
    this.usina = usina;
  }

  @Override
  public void monitorar(DadosSensores dados) {
    // REGRA 7: ALERTA_AMARELO → ALERTA_VERMELHO
    if (dados.getTemperatura() > 400 && dados.getDuracaoAlertaTemperaturaMs() > 30000) {
      System.out.println("ALERTA GRAVE: Temp > 400°C por mais de 30s!");
      usina.setEstado(new EstadoAlertaVermelho(usina));
    }
    // REGRA 2 (Bidirecional): Retorno ao normal
    else if (dados.getTemperatura() <= 300) {
      System.out.println("Temperatura normalizada. Retornando à operação normal.");
      usina.setEstado(new EstadoOperacaoNormal(usina));
    } else {
      System.out.println("ALERTA AMARELO: Temp: " + dados.getTemperatura() + "°C. Monitorando...");
    }
  }

  @Override
  public void ligar() {
    System.out.println("Ação inválida em ALERTA AMARELO.");
  }

  @Override
  public void desligar() {
    System.out.println("Iniciando desligamento de emergência (Amarelo)...");
    usina.setEstado(new EstadoDesligada(usina));
  }

  @Override
  public void iniciarManutencao() {
    System.out.println("PERIGO: Não é possível iniciar manutenção durante um alerta.");
  }

  @Override
  public void encerrarManutencao() {
    System.out.println("Erro: Não está em manutenção.");
  }
}