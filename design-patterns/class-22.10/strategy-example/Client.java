public class Client {
  public static void main(String[] args) {
    CriadorRotas criadorRotas = new CriadorRotas(new Auto());
    System.out.println(criadorRotas.executar());
  }
}
