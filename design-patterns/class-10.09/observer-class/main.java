public class main {
  public static void main(String[] args) {
    Observado observado = new Observado();

    ConcreteObserver observer1 = new ConcreteObserver(observado);

    observado.setState(10);
    observado.setState(20);

    observado.detach(observer1);

    observado.setState(30);
  }
}
