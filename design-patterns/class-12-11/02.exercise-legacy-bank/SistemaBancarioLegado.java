import java.util.HashMap;

/**
 * O "Adapter" - o sistema legado e incompatível.
 * Ele espera um HashMap genérico e retorna um HashMap genérico.
 */
public class SistemaBancarioLegado {
  public HashMap<String, Object> processarTransacao(HashMap<String, Object> parametros) {
    System.out.println("[LEGADO] Recebendo parâmetros brutos: " + parametros.toString());

    // Simulação de validação de campos obrigatórios do legado
    if (!parametros.containsKey("transaction_source") || !parametros.containsKey("currency_code")) {
      System.out.println("[LEGADO] ERRO: Campos obrigatórios 'transaction_source' ou 'currency_code' ausentes.");
      return criarRespostaLegada(500, null, "FALHA_PARAMETROS");
    }

    // Simulação da lógica de processamento
    String cartao = (String) parametros.get("card_number");
    double valor = (double) parametros.get("amount_total");

    System.out.println("[LEGADO] Processando R$ " + valor + " no cartão " + cartao.substring(0, 4) + "...");

    // Sucesso simulado
    String idTransacaoLegada = "TXN_LEGADO_" + System.currentTimeMillis();
    return criarRespostaLegada(200, idTransacaoLegada, "APROVADA");
  }

  private HashMap<String, Object> criarRespostaLegada(int status, String id, String msg) {
    HashMap<String, Object> resposta = new HashMap<>();
    resposta.put("status_code", status); // 200 = OK, 500 = Erro
    resposta.put("transaction_id", id);
    resposta.put("response_message", msg);
    return resposta;
  }
}