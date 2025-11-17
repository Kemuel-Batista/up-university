public class SimuladorUsina {
  public static void main(String[] args) throws InterruptedException {
    UsinaNuclear usina = new UsinaNuclear(); // Começa Desligada

    System.out.println("\n===== CENÁRIO 1: FLUXO DE ALERTA =====");
    usina.ligar(); // DESLIGADA -> OPERACAO_NORMAL

    // Simula dados
    usina.atualizarSensores(new DadosSensores(280, 100, 10, true, 0));
    usina.monitorar(); // Temp: 280°C

    // REGRA 6: > 300°C
    usina.atualizarSensores(new DadosSensores(310, 120, 15, true, 0));
    usina.monitorar(); // OPERACAO_NORMAL -> ALERTA_AMARELO

    // REGRA 7: > 400°C por 30s
    usina.atualizarSensores(new DadosSensores(410, 200, 30, true, 15000)); // 15s
    usina.monitorar(); // Continua Amarelo

    usina.atualizarSensores(new DadosSensores(415, 210, 35, true, 35000)); // 35s
    usina.monitorar(); // ALERTA_AMARELO -> ALERTA_VERMELHO

    // REGRA 8: Falha no resfriamento
    usina.atualizarSensores(new DadosSensores(450, 250, 50, false, 40000)); // Cooling FAIL
    usina.monitorar(); // ALERTA_VERMELHO -> EMERGENCIA

    // REGRA 3: Tenta sair da emergência (sem efeito)
    usina.atualizarSensores(new DadosSensores(100, 100, 10, true, 0));
    usina.monitorar(); // Permanece em EMERGENCIA
    usina.desligar(); // Permanece em EMERGENCIA

    System.out.println("\n===== CENÁRIO 2: MANUTENÇÃO =====");
    UsinaNuclear usina2 = new UsinaNuclear(); // Começa Desligada
    usina2.ligar(); // DESLIGADA -> OPERACAO_NORMAL

    usina2.atualizarSensores(new DadosSensores(290, 100, 10, true, 0));
    usina2.monitorar(); // Operação normal

    // REGRA 5: Inicia manutenção
    usina2.iniciarManutencao(); // OPERACAO_NORMAL -> ESTADO_MANUTENCAO

    // Simula um alerta de temperatura ALTA (que deve ser ignorado)
    usina2.atualizarSensores(new DadosSensores(350, 150, 20, true, 0));
    usina2.monitorar(); // "Em manutenção. Monitoramento suspenso."
    System.out.println("Estado atual: " + usina2.getNomeEstadoAtual()); // Confirma: EstadoManutencao

    // Encerra manutenção
    usina2.encerrarManutencao(); // ESTADO_MANUTENCAO -> OPERACAO_NORMAL (estado anterior)

    // Agora o monitoramento volta
    usina2.monitorar(); // ALERTA: Temperatura > 300°C!
    System.out.println("Estado final: " + usina2.getNomeEstadoAtual()); // Confirma: EstadoAlertaAmarelo
  }
}