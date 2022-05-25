package Resolucion_EjercitacionPreclase_Flyweight;

import org.junit.jupiter.api.*;



class CancionFactoryTest {

    ListaReproduccion miLista = new ListaReproduccion();

    @Test
    void creacion_exitosa_usandofactory() {
        Cancion cancionPrueba = new Cancion("Prueba", "Prueba", "Prueba");
        Assertions.assertEquals(CancionFactory.getCancion("Sol", "Juanes", "Pop").getClass(), cancionPrueba.getClass());
    }

    @Test
    void mostrar_cancionesagregadas_lista() {
        Cancion cancion1 = CancionFactory.getCancion("Sol", "Juanes", "Pop");
        Cancion cancion2 = CancionFactory.getCancion("Luna", "Diego Torres", "Pop");
        miLista.agregarCancion(cancion1);
        miLista.agregarCancion(cancion2);
        Assertions.assertEquals(miLista.getListaReproduccion().size(), 2);
    }

}