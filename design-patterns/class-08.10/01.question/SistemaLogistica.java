import java.util.Map;

public class SistemaLogistica {
  public static void main(String[] args) {
    TransportService service = new TransportService();

    service.processCalculo(new TransporteTerrestreFactory(), Map.of("distancia", 100, "peso", 50));

    service.processCalculo(new TransporteAereoFactory(), Map.of("distancia", 200, "peso", 20));

    service.processCalculo(new TransporteMaritimoFactory(), Map.of("distancia", 500, "peso", 100));
  }
}
