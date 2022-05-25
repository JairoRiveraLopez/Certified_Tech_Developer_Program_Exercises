package Resolucion_ejercitacionmesas_patronfacade;

public class ServicioTurismo implements IServicioTurismo{

    private BusquedaHotel busquedaHotel;
    private BusquedaVuelo busquedaVuelo;

    public ServicioTurismo() {
        this.busquedaHotel = new BusquedaHotel();
        this.busquedaVuelo = new BusquedaVuelo();
    }

    @Override
    public String realizarBusqueda(Vuelo vuelo, Hotel hotel) {
        String mensajeConsultaHotel = busquedaHotel.mostrarConsultaHotel(hotel);
        String mensajeConsultaVuelo  = busquedaVuelo.mostrarConsultaVuelo(vuelo);
        return mensajeConsultaHotel + "\n" + mensajeConsultaVuelo;
    }
}
