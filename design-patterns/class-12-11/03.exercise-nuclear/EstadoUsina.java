public interface EstadoUsina {
  void monitorar(DadosSensores dados);

  // Ações de mudança de modo
  void ligar();

  void desligar();

  void iniciarManutencao();

  void encerrarManutencao();
}