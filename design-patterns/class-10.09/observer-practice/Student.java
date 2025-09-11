import java.util.ArrayList;
import java.util.List;

public class Student {
  private String situation;
  private List<StudentListener> observers = new ArrayList<StudentListener>();

  public void setSituation(String situation) {
    this.situation = situation;

    if (situation.equals("Graduated")) {
      this.notifyAllObservers();
    }
  }

  public String getSituation() {
    return this.situation;
  }

  // Método de notificação
  private void notifyAllObservers() {
    for (StudentListener obs : this.observers) {
      obs.process();
    }
  }

  // Método de inscrição
  public void attach(StudentListener observer) {
    this.observers.add(observer);
  }

  // Método de remoção
  public void detach(StudentListener observer) {
    this.observers.remove(observer);
  }
}
