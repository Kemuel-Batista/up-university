public class CriadorRotas {
  // O contexto requer injeção de dependência
  private ICriadorRotas criadorRotas;
  
  public CriadorRotas(ICriadorRotas criadorRotas) {
    this.criadorRotas = criadorRotas;
  }

  public void setEstrategia(ICriadorRotas criadorRotas) {
    this.criadorRotas = criadorRotas;
  }

  public String executar() {
    return this.criadorRotas.criarRota();
  }
}
