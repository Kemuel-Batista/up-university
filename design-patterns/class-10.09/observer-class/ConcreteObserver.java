public class ConcreteObserver extends AbsObservador {
  public ConcreteObserver(Observado objeto_de_interesse) {
    this.objeto_de_interesse = objeto_de_interesse;
    this.objeto_de_interesse.attach(this);
  }

  @Override
  void update() {
    System.out.println("Notificação recebida: " + this);
  }
}
