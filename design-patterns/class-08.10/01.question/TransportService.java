import java.util.Map;

public class TransportService {
  public void processCalculo(TransportFactory factory, Map<String, Object> parametros) {
    TarifaCalculo calculo = factory.criarCalculoTarifa();
    calculo.calcular(parametros);
  }
}
