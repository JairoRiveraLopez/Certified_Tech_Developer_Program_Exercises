package Resolucion_ejercitacionmesas_patronfacade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioTurismoTest {

    ServicioTurismo Despegar = new ServicioTurismo();

    Vuelo vuelo = new Vuelo("Medellin", "Bogota", 12, 2, 2022, 12, 3, 2022, 20);
    Hotel hotel = new Hotel("Bogota", 12, 2, 2022, 12, 3, 2022, 2);

    @Test
    void realizarBusquedaPositiva() {
        String mensajeEsperadoHotel = "Hotel > Fecha salida : 2022-02-12. Fecha regreso: 2022-03-12 Ciudad: Bogota";
        String mensajeEsperadoVuelo = "Vuelo > Fecha salida : 2022-02-12. Fecha regreso: 2022-03-12 CiudadDestino: Bogota";
        String mensajeEsperado = mensajeEsperadoHotel + "\n" + mensajeEsperadoVuelo;
        String mensajeObtenido = Despegar.realizarBusqueda(vuelo, hotel);

        assertEquals(mensajeObtenido, mensajeEsperado);
    }

    @Test
    void realizarBusquedaNegativaHotel() {
        Hotel hotel2 = new Hotel("Bogota", 12, 2, 2022, 12, 3, 2022, 0);
        String mensajeEsperadoHotel = "Hotel no disponible.";
        String mensajeEsperadoVuelo = "Vuelo > Fecha salida : 2022-02-12. Fecha regreso: 2022-03-12 CiudadDestino: Bogota";
        String mensajeEsperado = mensajeEsperadoHotel + "\n" + mensajeEsperadoVuelo;
        String mensajeObtenido = Despegar.realizarBusqueda(vuelo, hotel2);

        assertEquals(mensajeObtenido, mensajeEsperado);
    }
}