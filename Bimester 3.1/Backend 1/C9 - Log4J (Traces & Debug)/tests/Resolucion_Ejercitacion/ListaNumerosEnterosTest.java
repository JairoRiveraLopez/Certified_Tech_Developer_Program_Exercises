package Resolucion_Ejercitacion;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;


class ListaNumerosEnterosTest {
    private static final Logger logger = Logger.getLogger(ListaNumerosEnterosTest.class);
    ListaNumerosEnteros listaPrueba1 = new ListaNumerosEnteros();
    ListaNumerosEnteros listaPrueba2 = new ListaNumerosEnteros();

    @Test
    void TestPromedioListaYMenorA5() {
        listaPrueba1.agregarNumero(2);
        listaPrueba1.agregarNumero(4);
        listaPrueba1.agregarNumero(6);
        try{
            Assertions.assertEquals(listaPrueba1.promedioLista(), 4);
        } catch (Exception e){
            logger.error("La lista es igual a cero.", e);
        }
    }

    @Test
    void TestPromedioListaYMayorA5() {
        listaPrueba1.agregarNumero(2);
        listaPrueba1.agregarNumero(2);
        listaPrueba1.agregarNumero(2);
        listaPrueba1.agregarNumero(4);
        listaPrueba1.agregarNumero(6);
        listaPrueba1.agregarNumero(8);
        try{
            Assertions.assertEquals(listaPrueba1.promedioLista(), 4);
        } catch (Exception e){
            logger.error("La lista es igual a cero.", e);
        }
    }

    @Test
    void TestPromedioListaYMayorA10() {
        listaPrueba1.agregarNumero(2);
        listaPrueba1.agregarNumero(2);
        listaPrueba1.agregarNumero(2);
        listaPrueba1.agregarNumero(2);
        listaPrueba1.agregarNumero(2);
        listaPrueba1.agregarNumero(2);
        listaPrueba1.agregarNumero(2);
        listaPrueba1.agregarNumero(2);
        listaPrueba1.agregarNumero(2);
        listaPrueba1.agregarNumero(2);
        listaPrueba1.agregarNumero(2);
        try{
            Assertions.assertEquals(listaPrueba1.promedioLista(), 2);
        } catch (Exception e){
            logger.error("La lista es igual a cero.", e);
        }
    }

    @Test
    void testFuncionTraerNumeroMaximo() {
        listaPrueba1.agregarNumero(2);
        listaPrueba1.agregarNumero(4);
        listaPrueba1.agregarNumero(6);
        Assertions.assertEquals(listaPrueba1.numMaximo(), 6);
    }
    @Test
    void testFuncionTraerNumeroMinimo() {
        listaPrueba1.agregarNumero(2);
        listaPrueba1.agregarNumero(4);
        listaPrueba1.agregarNumero(6);
        Assertions.assertEquals(listaPrueba1.numMinimo(), 2);
    }




}