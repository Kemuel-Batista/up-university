public class Diploma extends StudentListener {
  public Diploma(Student student) {
    this.student = student;
    this.student.attach(this);
  }

  @Override
  void process() {
    System.out.println("Agendamento para obter diploma realizado com sucesso: " + this);
  }
}
