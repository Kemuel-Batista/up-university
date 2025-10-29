public interface OrderState {
  void pay(); // Pagar
  void ship(); // Enviar
  void deliver(); // Entregar
  void cancel(); // Cancelar
}