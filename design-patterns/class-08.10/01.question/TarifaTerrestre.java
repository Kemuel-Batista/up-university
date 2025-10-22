import java.util.Map;

public class TarifaTerrestre implements TarifaCalculo {
  private static final double TARIFA_BASE = 50.0;
  private static final double FATOR_POR_KM = 0.8;

  @Override
  public double calcular(Map<String, Object> parametros) {
    double distanciaKm = ((Number) parametros.getOrDefault("distanciaKm", 0.0)).doubleValue();

    double valor = TARIFA_BASE + (distanciaKm * FATOR_POR_KM);

    System.out.printf("Cálculo Terrestre: Distância=%.2f km -> Valor=%.2f%n", distanciaKm, valor);
    return valor;
  }
}
