import java.util.ArrayList;

public class CentralItinerarios implements Mostrable{
    private String rutaArea;
    private ArrayList<Volador> vuelos = new ArrayList<>();

    public void agregar (Volador v){
        this.vuelos.add(v);
    }

    public void quitar (Volador v){
        this.vuelos.remove(v);
    }

    public void cambiarRutaSiCumple(String nuevaRutaArea){
        this.rutaArea = nuevaRutaArea;
        notificar("Ruta actualizada a " + obtenerRutaArea());
       }

    public String obtenerRutaArea(){
        return rutaArea;
    }

    public void notificar (String notificacion){
        for(Volador v : vuelos){
            System.out.println(v.actualizar() + notificacion);
        }
    }

}
