public class EstadoOperacaoNormal implements EstadoUsina {
  private UsinaNuclear usina;

  public EstadoOperacaoNormal(UsinaNuclear usina) {
    this.usina = usina;
  }

  @Override
  public void monitorar(DadosSensores dados) {
    // REGRA 6: OPERACAO_NORMAL → ALERTA_AMARELO
    if (dados.getTemperatura() > 300) {
      System.out.println("ALERTA: Temperatura > 300°C!");
      usina.setEstado(new EstadoAlertaAmarelo(usina));
    } else {
      System.out.println("Operação normal. Temp: " + dados.getTemperatura() + "°C");
    }
  }

  @Override
  public void ligar() {
    System.out.println("Usina já está em operação normal.");
  }

  @Override
  public void desligar() {
    System.out.println("Iniciando procedimento de desligamento...");
    usina.setEstado(new EstadoDesligada(usina));
  }

  @Override
  public void iniciarManutencao() {
    System.out.println("Iniciando manutenção... Pausando operações normais.");
    usina.setEstado(new EstadoManutencao(usina, this));
  }

  @Override
  public void encerrarManutencao() {
    System.out.println("Erro: Não está em manutenção.");
  }
}