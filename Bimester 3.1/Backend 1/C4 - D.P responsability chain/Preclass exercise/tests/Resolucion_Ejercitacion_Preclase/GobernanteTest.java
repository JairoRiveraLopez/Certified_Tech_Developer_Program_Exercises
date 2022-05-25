package Resolucion_Ejercitacion_Preclase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GobernanteTest {

    static Gobernante sujetoprueba;

    @BeforeAll
    public static void Data() {
        sujetoprueba = new Diputado();
        Presidente Putin = new Presidente();
        Ministro Chevchenko = new Ministro();

        sujetoprueba.setGobernante(Chevchenko);
        Chevchenko.setGobernante(Putin);

    }

    @Test
    void comprobarGestionDocumento_Presidente() {
        Documento reporte3 = new Documento(3, "Invasión a país vecino.");
        String mensajeEsperado = "Presidente: Recibido. Proseguire a gestionar el documento.";
        String mensajeObtenido = sujetoprueba.gestionarDocumento(reporte3);
        Assertions.assertEquals(mensajeObtenido, mensajeEsperado);
    }

    @Test
    void comprobarGestionDocumento_Ministro() {
        Documento reporte2 = new Documento(2, "Reporte de asesinatos en el país.");
        String mensajeEsperado = "Ministro: Recibido. Proseguire a gestionar el documento.";
        String mensajeObtenido = sujetoprueba.gestionarDocumento(reporte2);
        Assertions.assertEquals(mensajeObtenido, mensajeEsperado);
    }

    @Test
    void comprobarGestionDocumento_Diputado() {
        Documento reporte1 = new Documento(1, "Reporte de exportaciones del mes.");
        String mensajeEsperado = "Diputado: Recibido. Proseguire a gestionar el documento.";
        String mensajeObtenido = sujetoprueba.gestionarDocumento(reporte1);
        Assertions.assertEquals(mensajeObtenido, mensajeEsperado);
    }
}