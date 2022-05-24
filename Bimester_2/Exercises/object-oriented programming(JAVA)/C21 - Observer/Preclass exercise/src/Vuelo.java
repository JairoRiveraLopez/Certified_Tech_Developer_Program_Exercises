import java.time.LocalTime;

public class Vuelo implements Volador{

    private String aeropuertoOrigen;
    private String aeropuertoDestino;
    public LocalTime tiempoDeSalida;



    public Vuelo(String aeropuertoOrigen, String aeropuertoDestino, int hora, int minuto) {
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        tiempoDeSalida = LocalTime.of(hora, minuto);

    }

    @Override
    public String actualizar(){
        return this.getClass().getSimpleName() + " ha cambiado de ruta: ";
    }

    public void setAeropuertoOrigen(String nuevoAeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public void setAeropuertoDestino(String nuevoAeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public void setTiempoDeSalida(int hora, int minuto) {
        this.tiempoDeSalida = LocalTime.of(hora, minuto);
    }
}
