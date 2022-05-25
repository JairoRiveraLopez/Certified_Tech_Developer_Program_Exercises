package Resolucion_ejercitacion_clase5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class servicioDescargaTest {

    @Test
    void validarDescargarCancionProxy_Premium() {
        Usuario Jacobo = new Usuario(1, "Premium");
        CancionesDescargadas miLista = new CancionesDescargadas();
        assertEquals(miLista.descargarCancion(Jacobo), "Cancion descargada. Ve a tu lista de canciones");
    }

    @Test
    void validarDescargarCancionProxy_Gratis() {
        Usuario Paola = new Usuario(1, "Gratis");
        CancionesDescargadas miLista = new CancionesDescargadas();
        assertEquals(miLista.descargarCancion(Paola), "Adquiere Spotify Premium para poder descargar canciones");
    }

}