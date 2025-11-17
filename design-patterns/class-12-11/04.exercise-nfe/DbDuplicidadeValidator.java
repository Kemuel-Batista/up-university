public class DbDuplicidadeValidator extends AbstractValidator implements Rollbackable {
  private boolean inseriuRegistro = false;

  public DbDuplicidadeValidator(int timeout) {
    super(timeout);
  }

  protected String getName() {
    return "Banco de Dados (Duplicidade)";
  }

  @Override
  protected void performValidation(ValidationContext context) {
    System.out.println("   ... Verificando duplicidade no DB...");

    // Simulação: OK, não é duplicado.
    // REQUISITO 4: O validador "insere" um registro temporário
    // ou de "em processamento".
    System.out.println("   ... NFe não duplicada. Inserindo registro 'PENDENTE' no DB.");
    this.inseriuRegistro = true;

    // Adiciona a si mesmo na pilha de rollback, CASO
    // uma validação *futura* falhe.
    context.addRollback(this);
  }

  // REQUISITO 4: Implementação do Rollback
  @Override
  public void rollback(ValidationContext context) {
    if (inseriuRegistro) {
      System.err.println("   [ROLLBACK]: Removendo registro 'PENDENTE' do DB (Validador: " + getName() + ")");
      this.inseriuRegistro = false;
    }
  }
}