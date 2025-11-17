public class EstadoAlertaVermelho implements EstadoUsina {
  private UsinaNuclear usina;

  public EstadoAlertaVermelho(UsinaNuclear usina) {
    this.usina = usina;
  }

  @Override
  public void monitorar(DadosSensores dados) {
    // REGRA 8: ALERTA_VERMELHO → EMERGENCIA
    if (!dados.isSistemaResfriamentoOK()) {
      System.out.println("FALHA CRÍTICA: Sistema de resfriamento falhou!");
      // REGRA 4: Transição de ALERTA_VERMELHO para EMERGENCIA
      usina.setEstado(new EstadoEmergencia(usina));
    }
    // REGRA 2 (Bidirecional): Retorno ao Amarelo
    else if (dados.getTemperatura() <= 400) {
      System.out.println("Temperatura baixou para < 400°C. Revertendo para ALERTA AMARELO.");
      usina.setEstado(new EstadoAlertaAmarelo(usina));
    } else {
      System.out.println("ALERTA VERMELHO: Temp: " + dados.getTemperatura() + "°C. Resfriamento ATIVO.");
    }
  }

  @Override
  public void ligar() {
    System.out.println("Ação inválida em ALERTA VERMELHO.");
  }

  @Override
  public void desligar() {
    System.out.println("Iniciando desligamento de emergência (Vermelho)...");
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