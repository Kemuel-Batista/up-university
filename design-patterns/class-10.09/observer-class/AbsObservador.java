public abstract class AbsObservador {
  // Propriedade do tipo observado
  protected Observado objeto_de_interesse;

  // Assinatura do método a ser disparado pelo observado
  abstract void update();
}