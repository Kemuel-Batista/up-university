public class UsinaNuclear {

  private EstadoUsina estadoAtual;
  // Dados dos sensores que serão "lidos" e passados para o estado
  private DadosSensores dadosAtuais;

  public UsinaNuclear() {
    // Estado inicial
    this.estadoAtual = new EstadoDesligada(this);
    System.out.println("Usina criada. Estado: " + getNomeEstadoAtual());
  }

  // Método principal de operação. A usina "vive" chamando este método.
  public void monitorar() {
    // Em um sistema real, this.dadosAtuais seria atualizado por sensores
    // Aqui, o estado atual é quem processa os dados.
    if (this.dadosAtuais != null) {
      this.estadoAtual.monitorar(this.dadosAtuais);
    }
  }

  // Métodos para acionar eventos
  public void ligar() {
    this.estadoAtual.ligar();
  }

  public void desligar() {
    this.estadoAtual.desligar();
  }

  public void iniciarManutencao() {
    this.estadoAtual.iniciarManutencao();
  }

  public void encerrarManutencao() {
    this.estadoAtual.encerrarManutencao();
  }

  // --- Métodos de controle do Contexto ---

  // Permite que os estados alterem o estado da usina
  public void setEstado(EstadoUsina novoEstado) {
    this.estadoAtual = novoEstado;
    System.out.println("--- MUDANÇA DE ESTADO: " + getNomeEstadoAtual() + " ---");
  }

  // Usado pelo Main para simular leituras de sensor
  public void atualizarSensores(DadosSensores dados) {
    this.dadosAtuais = dados;
  }

  public String getNomeEstadoAtual() {
    return this.estadoAtual.getClass().getSimpleName();
  }
}