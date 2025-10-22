import java.util.Map;

public class TarifaAerea implements TarifaCalculo {
  private static final double TARIFA_BASE = 100.0;
  private static final double FATOR_POR_PESO = 2.5;
  private static final double TAXA_AEROPORTUARIA = 30.0;

  @Override
  public double calcular(Map<String, Object> parametros) {
    double pesoKg = ((Number) parametros.getOrDefault("pesoKg", 0.0)).doubleValue();

    double valor = TARIFA_BASE + (pesoKg * FATOR_POR_PESO) + TAXA_AEROPORTUARIA;

    System.out.printf("Cálculo Aéreo: Peso=%.2f kg -> Valor=%.2f%n", pesoKg, valor);
    return valor;
  }
}
