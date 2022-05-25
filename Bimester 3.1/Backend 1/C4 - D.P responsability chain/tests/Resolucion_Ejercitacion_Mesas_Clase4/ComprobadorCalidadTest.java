package Resolucion_Ejercitacion_Mesas_Clase4;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;


class ComprobadorCalidadTest {
    private Articulo articulo = new Articulo("Pastillas", 1100, 1200, "sano");
    private static ComprobadorCalidad testCalidad;
    private AnalistaCalidad Edna = new AnalistaCalidad();

    @BeforeAll
    public static void Data(){
    testCalidad = new CriterioLote();
    CriterioPeso testPeso = new CriterioPeso();
    CriterioEnvase testEnvase = new CriterioEnvase();

    testCalidad.setSiguienteCriterio(testPeso);
    testPeso.setSiguienteCriterio(testEnvase);

    }

    @Test
    void test_funcionalidad_creadorArticulos() {
        ArticuloFactory creadorArticulos = new ArticuloFactory();
        Articulo articuloAutomatizado = creadorArticulos.generarArticulo("Pastillas", 1100, 1200, "sano");
        assertEquals(articulo.getClass(), articuloAutomatizado.getClass());
    }
    @Test
    void test_funcionalidad_ComprobadorCalidad_AprobadoAnalistaCalidad(){
       Articulo enviarArticulo =  Edna.enviarArticuloRevision(articulo);
       String mensajeEsperado = "Verificacion de calidad: CriterioEnvase. Resultado : Aceptado. Articulo: Pastillas.";
       String mensajeActual = testCalidad.verificarCalidad(enviarArticulo);
       Assertions.assertEquals(mensajeActual, mensajeEsperado);
    }
    @Test
    void test_funcionalidad_ComprobadorCalidad_AprobadoTestFactory(){
        ArticuloFactory creadorArticulos = new ArticuloFactory();
        Articulo enviarArticulo =  creadorArticulos.generarArticulo("Croquetas", 1100, 1200, "casi sano");
        String mensajeEsperado = "Verificacion de calidad: CriterioEnvase. Resultado : Aceptado. Articulo: Croquetas.";
        String mensajeActual = testCalidad.verificarCalidad(enviarArticulo);
        Assertions.assertEquals(mensajeActual, mensajeEsperado);
    }
    @Test
    void test_funcionalidad_ComprobadorCalidad_RechazadoLote() {
        Articulo articulo2 = new Articulo("Papa", 600, 1200, "sano");
        String mensajeEsperado = "Verificacion de calidad: CriterioLote. Resultado : Rechazado. Articulo: Papa.";
        String mensajeActual = testCalidad.verificarCalidad(articulo2);
        Assertions.assertEquals(mensajeActual, mensajeEsperado);
    }

    @Test
    void test_funcionalidad_ComprobadorCalidad_RechazadoPeso() {
        Articulo articulo2 = new Articulo("Chicles", 1101, 200, "sano");
        String mensajeEsperado = "Verificacion de calidad: CriterioPeso. Resultado : Rechazado. Articulo: Chicles.";
        String mensajeActual = testCalidad.verificarCalidad(articulo2);
        Assertions.assertEquals(mensajeActual, mensajeEsperado);
    }

    @Test
    void test_funcionalidad_ComprobadorCalidad_RechazadoEnvase() {
        Articulo articulo2 = new Articulo("Fritangas", 1101, 1202, "insano");
        String mensajeEsperado = "Verificacion de calidad: CriterioEnvase. Resultado : Rechazado. Articulo: Fritangas.";
        String mensajeActual = testCalidad.verificarCalidad(articulo2);
        Assertions.assertEquals(mensajeActual, mensajeEsperado);
    }

}