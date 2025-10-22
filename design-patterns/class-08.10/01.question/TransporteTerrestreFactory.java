public class TransporteTerrestreFactory implements TransportFactory {
  @Override
  public TarifaCalculo criarCalculoTarifa() {
    return new TarifaTerrestre();
  }
}
