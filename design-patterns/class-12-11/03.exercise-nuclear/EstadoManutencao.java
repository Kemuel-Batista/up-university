public class EstadoManutencao implements EstadoUsina {
  private UsinaNuclear usina;
  private EstadoUsina estadoAnterior; // "Lembra" o estado de onde veio

  // REGRA 5: Recebe o estado anterior para "sobrescrever temporariamente"
  public EstadoManutencao(UsinaNuclear usina, EstadoUsina estadoAnterior) {
    this.usina = usina;
    this.estadoAnterior = estadoAnterior;
  }

  @Override
  public void monitorar(DadosSensores dados) {
    System.out.println("Em manutenção. Monitoramento de produção suspenso.");
    // A lógica de monitoramento de regras (temp, pressão) é ignorada.
  }

  @Override
  public void ligar() {
    System.out.println("MANUTENÇÃO: Ação inválida.");
  }

  @Override
  public void desligar() {
    System.out.println("MANUTENÇÃO: Ação inválida.");
  }

  @Override
  public void iniciarManutencao() {
    System.out.println("Usina já está em manutenção.");
  }

  @Override
  public void encerrarManutencao() {
    System.out.println("Encerrando manutenção. Retornando ao estado anterior.");
    // Retorna ao estado que foi salvo (Desligada ou OperacaoNormal)
    usina.setEstado(this.estadoAnterior);
  }
}