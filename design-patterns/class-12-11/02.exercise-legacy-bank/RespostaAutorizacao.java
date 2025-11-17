public class RespostaAutorizacao {
  private final boolean sucesso;
  private final String idTransacao;
  private final String mensagem;

  public RespostaAutorizacao(boolean sucesso, String idTransacao, String mensagem) {
    this.sucesso = sucesso;
    this.idTransacao = idTransacao;
    this.mensagem = mensagem;
  }

  // Getters
  public boolean isSucesso() {
    return sucesso;
  }

  public String getIdTransacao() {
    return idTransacao;
  }

  public String getMensagem() {
    return mensagem;
  }

  @Override
  public String toString() {
    return "RespostaAutorizacao {" +
        "sucesso=" + sucesso +
        ", idTransacao='" + idTransacao + '\'' +
        ", mensagem='" + mensagem + '\'' +
        '}';
  }
}