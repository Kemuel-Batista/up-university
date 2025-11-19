public class PlataformaMain {
  public static void main(String[] args) {
    // Iniciamos com um perfil Conservador
    PlataformaInvestimento plataforma = new PlataformaInvestimento(new ModeloConservador());
    plataforma.executarAnaliseRisco(10000);

    System.out.println("--------------------------------------------------");

    // O cliente mudou de ideia ou o consultor alterou o perfil dinamicamente
    System.out.println("Alterando estratégia para AGRESSIVO em tempo de execução...");
    plataforma.setStrategy(new ModeloAgressivo());

    // O fluxo principal (executarAnaliseRisco) permanece o mesmo
    plataforma.executarAnaliseRisco(10000);
  }
}
