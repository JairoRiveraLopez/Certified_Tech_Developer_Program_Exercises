package Resolucion_Ejercitacion_Claseintegradora;

import org.junit.jupiter.api.*;


class VendedorTest {


    @Test
    void categorizar_Empleado() {
        // Se crea empleado(Por años de antiguedad tiene 10 puntos)
        Empleado EMP001 = new Empleado("Oriana", 2);
        // Se crea afiliado
        Afiliado AFL001 = new Afiliado("Gertrudis");
        // Se consigue el afiliado (Al hacerlo, gana 10 puntos)
        EMP001.conseguirAfiliados(AFL001);
        // Vende cuatro veces (Gana 20 puntos)
        EMP001.setNumeroDeVentas(4);
        // Vende una vez más y se suma al conteo (5 ventas hasta aquí) (Esta cantidad de ventas suma 5 puntos)
        EMP001.vender();
        // La suma total es de 45 puntos, lo que lo convierte en Maestro
        Assertions.assertEquals(EMP001.categorizar(), "Oriana tiene un total de 45 puntos y se categoriza como Maestro");
    }

    @Test
    void categorizar_Afiliado() {
        // Se crea el afiliado
        Afiliado AFL001 = new Afiliado("Gertrudis");
        // Vende una vez (Gana 15 puntos)
        AFL001.setNumeroDeVentas(1);
        // Vende una vez más y se suma al conteo (2 ventas hasta aquí) (Esta cantidad de ventas suma 15 puntos)
        AFL001.vender();
        // La suma total es de 30 puntos, lo que lo convierte en Aprendiz
        Assertions.assertEquals(AFL001.categorizar(), "Gertrudis tiene un total de 30 puntos y se categoriza como Aprendiz");
    }
    @Test
    void categorizar_Pasante() {
        // Se crea el pasante
        Pasante PAS001 = new Pasante("Timmy");
        // Vende 10 veces vez (Gana 50 puntos)
        PAS001.setNumeroDeVentas(10);
        // Vende una vez más y se suma al conteo (11 ventas hasta aquí) (Esta cantidad de ventas suma 5 puntos)
        PAS001.vender();
        // La suma total es de 55 puntos, lo que lo convierte en Pasante experimentado
        Assertions.assertEquals(PAS001.categorizar(), "Timmy tiene un total de 55 puntos y se categoriza como Pasante experimentado");
    }


}