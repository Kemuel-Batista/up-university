public class StudentConsumer {
  public static void main(String[] args) {
    Student student = new Student();

    Diploma diploma = new Diploma(student);
    Graduation graduation = new Graduation(student);

    student.setSituation("Graduated");

    student.detach(diploma);
    student.detach(graduation);

  }
}
