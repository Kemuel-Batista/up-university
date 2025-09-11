import java.util.ArrayList;
import java.util.List;

public class Observado {
  private int state;
  private List<AbsObservador> observers = new ArrayList<AbsObservador>();

  public void setState(int state) {
    this.state = state;
    // Acionar o método de notificação
    this.notifyAllObservers();
  }

  public int getState() {
    return this.state;
  }

  // Método de notificação
  private void notifyAllObservers() {
    for (AbsObservador obs : this.observers) {
      obs.update();
    }
  }

  // Método de inscrição
  public void attach(AbsObservador observer) {
    this.observers.add(observer);
  }

  // Método de remoção
  public void detach(AbsObservador observer) {
    this.observers.remove(observer);
  }
}
