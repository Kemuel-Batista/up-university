public class Graduation extends StudentListener {
  public Graduation(Student student) {
    this.student = student;
    this.student.attach(this);
  }

  @Override
  void process() {
    System.out.println("Agendamento para colação de grau realizado com sucesso: " + this);
  }
}
