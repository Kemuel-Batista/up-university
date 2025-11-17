/**
 * O código cliente.
 * Note que ele depende apenas da interface moderna "ProcessadorTransacoes".
 * Ele não tem ideia de que o "SistemaBancarioLegado" existe.
 */
public class DemoLegacyBank {

  public static void main(String[] args) {
    // 1. Instanciamos o sistema legado que não podemos mudar
    SistemaBancarioLegado sistemaLegado = new SistemaBancarioLegado();

    // 2. Instanciamos nosso Adaptador e injetamos o sistema legado nele
    ProcessadorTransacoes processador = new AdaptadorBancario(sistemaLegado);

    // 3. O cliente faz a chamada usando a interface moderna e simples
    System.out.println("--- Iniciando Transação 1 (BRL) ---");
    RespostaAutorizacao resp1 = processador.autorizar(
        "1234-5678-9012-3456",
        150.75,
        "BRL");

    // 4. O cliente recebe uma resposta no formato moderno
    System.out.println("[CLIENTE] Resposta recebida: " + resp1.toString());
    System.out.println("[CLIENTE] Transação 1 foi sucesso? " + resp1.isSucesso());

    System.out.println("\n--- Iniciando Transação 2 (USD) ---");
    RespostaAutorizacao resp2 = processador.autorizar(
        "9876-5432-1098-7654",
        99.99,
        "USD");
    System.out.println("[CLIENTE] Resposta recebida: " + resp2.toString());
  }
}