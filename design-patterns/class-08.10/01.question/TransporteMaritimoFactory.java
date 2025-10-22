public class TransporteMaritimoFactory implements TransportFactory {
  @Override
  public TarifaCalculo criarCalculoTarifa() {
    return new TarifaMaritima();
  }
}
