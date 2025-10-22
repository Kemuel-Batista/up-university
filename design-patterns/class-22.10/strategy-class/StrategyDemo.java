public class StrategyDemo {
  public static void main(String[] args) {
    Context context = new Context(new AddStrategy());
    System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

    context.setStrategy(new SubtractStrategy());
    System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

    context.setStrategy(new MultiplyStrategy());
    System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
  }
}
