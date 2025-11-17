import java.util.HashMap;

/**
 * O "Adapter".
 * Ele implementa a interface moderna (Target) e contém
 * uma instância do sistema legado (Adaptee).
 */
public class AdaptadorBancario implements ProcessadorTransacoes {

  private final SistemaBancarioLegado sistemaLegado;

  public AdaptadorBancario(SistemaBancarioLegado sistemaLegado) {
    this.sistemaLegado = sistemaLegado;
  }

  @Override
  public RespostaAutorizacao autorizar(String cartao, double valor, String moeda) {
    System.out.println("[ADAPTADOR] Recebida requisição moderna. Traduzindo para o formato legado...");

    // 1. Converter Requisição (Moderno -> Legado)
    HashMap<String, Object> parametrosLegados = new HashMap<>();
    parametrosLegados.put("card_number", cartao);
    parametrosLegados.put("amount_total", valor);

    // 2. Tratar Dados (Restrição de Moeda)
    parametrosLegados.put("currency_code", this.converterMoedaParaCodigo(moeda));

    // 3. Tratar Dados (Restrição de Campo Obrigatório Ausente)
    // O sistema moderno não sabe sobre "transaction_source",
    // mas o adaptador sabe que é obrigatório e injeta um valor padrão.
    parametrosLegados.put("transaction_source", "SISTEMA_WEB_V2");

    // 4. Chamar o Legado
    HashMap<String, Object> respostaLegada = sistemaLegado.processarTransacao(parametrosLegados);

    System.out.println("[ADAPTADOR] Recebida resposta legada. Traduzindo para o formato moderno...");

    // 5. Converter Resposta (Legado -> Moderno) - A parte "Bidirecional"
    return this.converterRespostaLegada(respostaLegada);
  }

  /**
   * Método auxiliar privado para a lógica de "tradução" dos dados.
   */
  private int converterMoedaParaCodigo(String moeda) {
    switch (moeda.toUpperCase()) {
      case "USD":
        return 1;
      case "EUR":
        return 2;
      case "BRL":
        return 3;
      default:
        return 0; // Código para "desconhecido"
    }
  }

  /**
   * Método auxiliar privado para a lógica de "tradução" da resposta.
   */
  private RespostaAutorizacao converterRespostaLegada(HashMap<String, Object> respostaLegada) {
    // O legado usa 'status_code' (int) e nós usamos 'sucesso' (boolean)
    boolean sucesso = false;
    if (respostaLegada.get("status_code") != null && (int) respostaLegada.get("status_code") == 200) {
      sucesso = true;
    }

    // O legado usa 'transaction_id' e nós 'idTransacao'
    String idTransacao = (String) respostaLegada.get("transaction_id");

    // O legado usa 'response_message' e nós 'mensagem'
    String mensagem = (String) respostaLegada.get("response_message");

    return new RespostaAutorizacao(sucesso, idTransacao, mensagem);
  }
}