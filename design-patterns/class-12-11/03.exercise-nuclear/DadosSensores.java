public class DadosSensores {
  private double temperatura;
  private double pressao;
  private double nivelRadiacao;
  private boolean sistemaResfriamentoOK;
  private long duracaoAlertaTemperaturaMs; // Para a regra dos 30s

  // Construtor e Getters...
  public DadosSensores(double temp, double press, double rad, boolean coolingOk, long durationMs) {
    this.temperatura = temp;
    this.pressao = press;
    this.nivelRadiacao = rad;
    this.sistemaResfriamentoOK = coolingOk;
    this.duracaoAlertaTemperaturaMs = durationMs;
  }

  // Getters
  public double getTemperatura() {
    return temperatura;
  }

  public boolean isSistemaResfriamentoOK() {
    return sistemaResfriamentoOK;
  }

  public long getDuracaoAlertaTemperaturaMs() {
    return duracaoAlertaTemperaturaMs;
  }
}