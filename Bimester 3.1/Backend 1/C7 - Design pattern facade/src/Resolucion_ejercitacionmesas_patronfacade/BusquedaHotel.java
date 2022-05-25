package Resolucion_ejercitacionmesas_patronfacade;

public class BusquedaHotel {
    public String mostrarConsultaHotel (Hotel hotel){
        if(hotelDisponible(hotel)){
            return hotel.getClass().getSimpleName() + " > " + "Fecha salida : " + hotel.getFechaSalida() + ". Fecha regreso: " + hotel.getFechaRegreso() + " Ciudad: "  + hotel.getCiudad();
        } else{
            return "Hotel no disponible.";
        }

    }

    public Boolean hotelDisponible(Hotel hotel){
        return hotel.getHabitacionesDisponibles() > 0;
    }
}
