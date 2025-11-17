import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Este é o "Contexto" (ou Padrão State) que é passado pela cadeia.
 * Ele carrega o estado da validação, o contador de falhas (para o
 * circuit breaker) e a pilha de rollback.
 */
public class ValidationContext {
  private final NFeDocument document;
  private final List<String> failures = new ArrayList<>();
  private final Stack<Rollbackable> rollbackStack = new Stack<>();

  private static final int CIRCUIT_BREAKER_LIMIT = 3;
  private boolean circuitBreakerTripped = false;

  public ValidationContext(NFeDocument document) {
    this.document = document;
  }

  public NFeDocument getDocument() {
    return document;
  }

  public void addFailure(String failureMessage) {
    System.err.println("   [FALHA]: " + failureMessage);
    this.failures.add(failureMessage);

    // REQUISITO 3: Mecanismo de "Circuit Breaker"
    if (this.failures.size() >= CIRCUIT_BREAKER_LIMIT) {
      this.circuitBreakerTripped = true;
      System.err.println("!!! CIRCUIT BREAKER ATIVADO! 3 falhas. Interrompendo cadeia. !!!");
    }
  }

  public boolean hasFailures() {
    return !failures.isEmpty();
  }

  public int getFailureCount() {
    return failures.size();
  }

  public boolean isCircuitBreakerTripped() {
    return circuitBreakerTripped;
  }

  // REQUISITO 4: Adiciona uma operação de rollback na pilha
  public void addRollback(Rollbackable validator) {
    this.rollbackStack.push(validator);
  }

  public Stack<Rollbackable> getRollbackStack() {
    return rollbackStack;
  }

  public List<String> getFailures() {
    return failures;
  }
}