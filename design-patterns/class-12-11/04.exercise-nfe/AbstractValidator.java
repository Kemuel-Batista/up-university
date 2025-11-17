/**
 * O Handler Abstrato.
 * Ele gerencia o próximo na cadeia e usa o padrão "Template Method"
 * (o método 'validate') para controlar a lógica de execução.
 */
public abstract class AbstractValidator {
  protected AbstractValidator nextValidator;
  protected final int timeoutMillis; // REQUISITO 5: Timeout individual

  public AbstractValidator(int timeoutMillis) {
    this.timeoutMillis = timeoutMillis;
  }

  public AbstractValidator setNext(AbstractValidator nextValidator) {
    this.nextValidator = nextValidator;
    return nextValidator; // Permite encadeamento fluente
  }

  /**
   * Este é o "Template Method" que controla o fluxo.
   * Os filhos não podem sobrescrevê-lo (final).
   */
  public final void validate(ValidationContext context) {
    // REQUISITO 3: Se o circuit breaker disparou, interrompe tudo.
    if (context.isCircuitBreakerTripped()) {
      return;
    }

    // REQUISITO 2: Lógica condicional (pular)
    if (shouldSkip(context)) {
      System.out.println("... Pulando validador: " + getName());
      // Passa para o próximo sem executar este
      if (nextValidator != null) {
        nextValidator.validate(context);
      }
      return;
    }

    System.out.println("-> Executando validador: " + getName() +
        " (Timeout: " + timeoutMillis + "ms)");

    // REQUISITO 5: Simulação de Timeout
    // Em um sistema real, isso seria feito com Future.get(timeout)
    long startTime = System.currentTimeMillis();
    boolean success = false;
    try {
      // Chama a lógica de negócio do filho
      performValidation(context);
      success = true;
    } catch (Exception e) {
      context.addFailure("Exceção inesperada em " + getName() + ": " + e.getMessage());
    }

    long duration = System.currentTimeMillis() - startTime;

    if (duration > timeoutMillis) {
      context.addFailure("Timeout! " + getName() +
          " excedeu " + timeoutMillis + "ms (levou " + duration + "ms)");
    }

    // REQUISITO 4: Se este validador for Rollbackable e *passou*,
    // ele é adicionado à pilha pelo próprio validador
    // dentro de performValidation().

    // Passa para o próximo na cadeia
    if (nextValidator != null) {
      nextValidator.validate(context);
    }
  }

  /**
   * Lógica de negócios de cada validador (a ser implementada pelos filhos).
   */
  protected abstract void performValidation(ValidationContext context) throws Exception;

  /**
   * Nome do validador (para logs).
   */
  protected abstract String getName();

  /**
   * REQUISITO 2: Condição de pulo (a ser sobrescrita pelos filhos).
   * Por padrão, não pula.
   */
  protected boolean shouldSkip(ValidationContext context) {
    return false;
  }
}