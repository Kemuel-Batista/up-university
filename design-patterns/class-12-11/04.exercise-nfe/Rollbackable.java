/**
 * REQUISITO 4: Interface para validadores que modificam o
 * estado e precisam de rollback.
 */
public interface Rollbackable {
  void rollback(ValidationContext context);
}