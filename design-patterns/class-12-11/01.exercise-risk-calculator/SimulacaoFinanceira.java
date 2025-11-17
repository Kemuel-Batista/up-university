/**
 * Classe "Cliente" que utiliza o padrão Strategy.
 * Ela demonstra a troca dinâmica dos algoritmos de risco.
 */
public class SimulacaoFinanceira {
  public static void main(String[] args) {

    // 1. Criar o contexto complexo com os parâmetros financeiros
    ContextoRisco contexto = new ContextoRisco(
        new double[] { 100.50, 250.75, -50.20 }, // Valores do portfólio
        0.95, // Taxa de confiança (95%)
        "Crise de juros altos", // Cenário de estresse
        10 // Período de 10 dias
    );

    // 2. Criar as instâncias das estratégias (algoritmos)
    RiscoStrategy varStrategy = new ValueAtRiskStrategy();
    RiscoStrategy esStrategy = new ExpectedShortfallStrategy();
    RiscoStrategy stressStrategy = new StressTestingStrategy();

    // 3. Criar o processador (Contexto) com uma estratégia inicial (VaR)
    ProcessadorDeRisco processador = new ProcessadorDeRisco(contexto, varStrategy);

    // 4. Executar o cálculo. O processador usará a estratégia VaR.
    System.out.println(">>> Execução 1: Cálculo de Risco Diário (VaR)");
    processador.executarCalculoDeRisco();

    // 5. Trocar a estratégia em tempo de execução (Ex: Mudança de regra de negócio)
    // O cliente (SimulacaoFinanceira) muda a estratégia sem conhecer os detalhes.
    processador.setEstrategia(esStrategy);

    // 6. Executar o mesmo método. Agora o processador usará a estratégia ES.
    System.out.println(">>> Execução 2: Análise de Cauda (Expected Shortfall)");
    processador.executarCalculoDeRisco();

    // 7. Trocar a estratégia novamente para o teste de estresse
    processador.setEstrategia(stressStrategy);

    // 8. Executar o cálculo. Agora o processador usará o Stress Testing.
    System.out.println(">>> Execução 3: Simulação de Crise (Stress Test)");
    processador.executarCalculoDeRisco();
  }
}