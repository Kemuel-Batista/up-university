public class TransporteAereoFactory implements TransportFactory {
  @Override
  public TarifaCalculo criarCalculoTarifa() {
    return new TarifaAerea();
  }
}
