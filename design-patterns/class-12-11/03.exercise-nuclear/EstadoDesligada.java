public class EstadoDesligada implements EstadoUsina {
  private UsinaNuclear usina;

  public EstadoDesligada(UsinaNuclear usina) {
    this.usina = usina;
  }

  @Override
  public void monitorar(DadosSensores dados) {
    // Desligada, não monitora ativamente
  }

  @Override
  public void ligar() {
    System.out.println("Ligando usina... Verificando sistemas...");
    // Adicionar lógica de verificação de segurança aqui
    usina.setEstado(new EstadoOperacaoNormal(usina));
  }

  @Override
  public void desligar() {
    System.out.println("Usina já está desligada.");
  }

  @Override
  public void iniciarManutencao() {
    System.out.println("Iniciando manutenção em usina desligada.");
    // "Sobrescreve" o estado atual, passando "this" (EstadoDesligada)
    // como o estado para o qual retornar.
    usina.setEstado(new EstadoManutencao(usina, this));
  }

  @Override
  public void encerrarManutencao() {
    System.out.println("Erro: Não está em manutenção.");
  }
}