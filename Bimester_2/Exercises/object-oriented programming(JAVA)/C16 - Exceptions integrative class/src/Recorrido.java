public class Recorrido {
    private String estacionPartida;
    private String estacionDestino;

    public Recorrido(String estacionPartida, String estacionDestino) {
        this.estacionPartida = estacionPartida;
        this.estacionDestino = estacionDestino;
    }

    public String getEstacionDestino() {
        return estacionDestino;
    }

    public String getEstacionPartida() {
        return estacionPartida;
    }
}
