public class EstadoEmergencia implements EstadoUsina {
  private UsinaNuclear usina;

  public EstadoEmergencia(UsinaNuclear usina) {
    this.usina = usina;
    System.out.println("!!! EVACUAR IMEDIATAMENTE !!!");
  }

  @Override
  public void monitorar(DadosSensores dados) {
    // REGRA 3: Previne transições circulares.
    // Uma vez em emergência, o sistema está "travado" aqui.
    System.out.println("EMERGÊNCIA. Sistemas manuais necessários. Nenhuma ação automática.");
  }

  // Nenhuma ação é permitida em emergência
  @Override
  public void ligar() {
    System.out.println("EMERGÊNCIA: Ação bloqueada.");
  }

  @Override
  public void desligar() {
    System.out.println("EMERGÊNCIA: Ação bloqueada.");
  }

  @Override
  public void iniciarManutencao() {
    System.out.println("EMERGÊNCIA: Ação bloqueada.");
  }

  @Override
  public void encerrarManutencao() {
    System.out.println("EMERGÊNCIA: Ação bloqueada.");
  }
}