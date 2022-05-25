package Resolucion_ejercitacionmesas_patronfacade;

public class BusquedaVuelo {
    public String mostrarConsultaVuelo (Vuelo vuelo){
        if(vueloDisponible(vuelo)){
            return vuelo.getClass().getSimpleName() + " > " + "Fecha salida : " + vuelo.getFechaSalida() + ". Fecha regreso: " + vuelo.getFechaRegreso() + " CiudadDestino: "  + vuelo.getCiudadDestino();
        } else{
            return "Vuelo no disponible.";
        }

    }

    public Boolean vueloDisponible(Vuelo vuelo){
        return vuelo.getSillasDisponibles() > 0;
    }
}
