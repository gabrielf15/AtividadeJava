public class Main {
    private double distancia;
    private int tempoEspera;
    private double tarifaBase;
    private double fatorDemanda;

    public Main(double distancia, int tempoEspera, double tarifaBase, double fatorDemanda) {
        this.distancia = distancia;
        this.tempoEspera = tempoEspera;
        this.tarifaBase = tarifaBase;
        this.fatorDemanda = fatorDemanda;
    }

    public double calcularValorCorrida() {
        return (distancia * 2) + (tempoEspera * 0.5) + (tarifaBase * fatorDemanda);
    }

    public void exibirDetalhesCorrida() {
        double valorFinal = calcularValorCorrida();
        System.out.println("Detalhes da Corrida:");
        System.out.println("Distância percorrida: " + distancia + " km");
        System.out.println("Tempo de espera: " + tempoEspera + " minutos");
        System.out.println("Tarifa base: R$" + tarifaBase);
        System.out.println("Fator de demanda: " + fatorDemanda);
        System.out.println("Valor final da corrida: R$" + valorFinal);
    }

    public static void main(String[] args) {
        Main corrida = new Main(22, 5, 25, 4);
        corrida.exibirDetalhesCorrida();
    }
}
