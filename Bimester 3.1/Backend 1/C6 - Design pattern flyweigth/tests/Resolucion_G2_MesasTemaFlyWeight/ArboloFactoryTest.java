package Resolucion_G2_MesasTemaFlyWeight;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ArboloFactoryTest {

    Bosque bosque = new Bosque();

    @Test
    void test_cantidadCantidadArbolesPlantados() {
        for (int i = 0; i < 500000; i++) {
            Arbol sembradosArboles = ArboloFactory.plantarArbol("ornamental");
            bosque.agregarArbol(sembradosArboles);
        }

        for (int i = 0; i < 500000; i++) {
            Arbol sembradosArboles = ArboloFactory.plantarArbol("frutal1");
            bosque.agregarArbol(sembradosArboles);
        }
        Integer numeroObtenido = bosque.getBosque().size();
        assertEquals(numeroObtenido, 1000000);
    }

    @Test
    void test_cantidadCantidadArbolesPorColor() {
        for (int i = 0; i < 500000; i++) {
            Arbol sembradosArboles = ArboloFactory.plantarArbol("ornamental");
            bosque.agregarArbol(sembradosArboles);
        }

        for (int i = 0; i < 500000; i++) {
            Arbol sembradosArboles = ArboloFactory.plantarArbol("frutal1");
            bosque.agregarArbol(sembradosArboles);
        }
        Integer contadorArbolesVerdes = 0;
        Integer contadorArbolesRojos = 0;

        for (Arbol arbol:bosque.getBosque()) {
            if(arbol.getColor().equals("Verde")){
                contadorArbolesVerdes++;
            } else {
                contadorArbolesRojos++;
            }
        }
        assertEquals(contadorArbolesVerdes, 500000);
        assertEquals(contadorArbolesRojos, 500000);
    }

}