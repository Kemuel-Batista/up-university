import java.util.Map;

public class TarifaMaritima implements TarifaCalculo {
  private static final double TARIFA_FIXA = 80.0;
    private static final double FATOR_POR_VOLUME = 1.5;

  @Override
  public double calcular(Map<String, Object> parametros) {
    double volumeM3 = ((Number) parametros.getOrDefault("volumeM3", 0.0)).doubleValue();

    double valor = TARIFA_FIXA + (volumeM3 * FATOR_POR_VOLUME);

    System.out.printf("Cálculo Marítimo: Volume=%.2f m³ -> Valor=%.2f%n", volumeM3, valor);
    return valor;
  }
}
