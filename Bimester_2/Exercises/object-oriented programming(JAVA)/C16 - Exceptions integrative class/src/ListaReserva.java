import java.util.ArrayList;
import java.util.List;

public class ListaReserva {

    private List<Reserva> reservas;

    public ListaReserva() {
        reservas = new ArrayList<>();
    }

    public void agregarReserva (Reserva reserva){
        reservas.add(reserva);
    }

    private List<String> getEstacionesValidas(){
        List<String> estacionesValidas = new ArrayList<>();
        estacionesValidas.add("Buenos Aires");
        estacionesValidas.add("Luján");
        estacionesValidas.add("Mercedes");
        estacionesValidas.add("Suipacha");
        estacionesValidas.add("Chivilcoy");
        estacionesValidas.add("Alberti");
        estacionesValidas.add("Bragado");
        return estacionesValidas;
    }

    public Double recaudacionTotal (){
        Double precioEstandar = 50.0;
        Double precioConDescuento = precioEstandar * 0.80;
        Double recaudacionTotal = 0.0;

        for (Reserva reserva:reservas) {
            if (reserva.getRecorrido().getEstacionPartida().contains("Buenos Aires") ||
                    reserva.getRecorrido().getEstacionPartida().contains("Bagardo") ||
                            reserva.getRecorrido().getEstacionDestino().contains("Buenos Aires") ||
                                    reserva.getRecorrido().getEstacionDestino().contains("Bagardo")){
            recaudacionTotal += precioConDescuento * reserva.getCantidadViajeros();
            } else {
                recaudacionTotal += precioEstandar * reserva.getCantidadViajeros();
            }
        }

        return recaudacionTotal;
    }

    public Integer cantidadVecesRecorrida (String estacion) throws ListaReservaException{
        Integer cantidadPersonasEstacion = 0;

            if(getEstacionesValidas().contains(estacion)){
                for (Reserva reserva:reservas) {
                    if(reserva.getRecorrido().getEstacionPartida().equals(estacion) || reserva.getRecorrido().getEstacionDestino().equals(estacion)){
                        cantidadPersonasEstacion += reserva.getCantidadViajeros();
                    }
                }
        } else {
                throw new ListaReservaException ("La estacion ingresada no es valida.");
            }

            return cantidadPersonasEstacion;
    }
}
