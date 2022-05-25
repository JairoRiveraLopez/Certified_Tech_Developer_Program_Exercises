package Resolucion_ejercitacionmesasclaseintegradora_flyweight;

import org.junit.jupiter.api.*;


class RopaFactoryTest {
    Ropa prenda1 = RopaFactory.getRopa("S", "Camisa", true, true);
    Ropa prenda2 = RopaFactory.getRopa("S", "Pantalon", true, true);
    Ropa prenda3 = RopaFactory.getRopa("XS", "Camisa", true, false);
    Ropa prenda4 = RopaFactory.getRopa("XS", "Pantalon", true, false);
    Ropa prenda5 = RopaFactory.getRopa("M", "Camisa", true, true);
    Ropa prenda6 = RopaFactory.getRopa("M", "Camisa", true, false);


    @Test
    void validar_TamanioTallaXSNegocioRopa() {
        NegocioRopa Levi = new NegocioRopa();
        Levi.agregarALista(prenda1);
        Levi.agregarALista(prenda2);
        Levi.agregarALista(prenda3);
        Levi.agregarALista(prenda4);
        Levi.agregarALista(prenda5);
        Levi.agregarALista(prenda6);
        Assertions.assertEquals(Levi.getListaTallaXS().size(), 2);
    }

    @Test
    void validar_TamanioTallaSNegocioRopa() {
        NegocioRopa Levi = new NegocioRopa();
        Levi.agregarALista(prenda1);
        Levi.agregarALista(prenda2);
        Levi.agregarALista(prenda3);
        Levi.agregarALista(prenda4);
        Levi.agregarALista(prenda5);
        Levi.agregarALista(prenda6);
        Assertions.assertEquals(Levi.getListaTallaS().size(), 2);
    }

    @Test
    void validar_TamanioTallaMNegocioRopa() {
        NegocioRopa Levi = new NegocioRopa();
        Levi.agregarALista(prenda1);
        Levi.agregarALista(prenda2);
        Levi.agregarALista(prenda3);
        Levi.agregarALista(prenda4);
        Levi.agregarALista(prenda5);
        Levi.agregarALista(prenda6);
        Assertions.assertEquals(Levi.getListaTallaM().size(), 2);
    }

    @Test
    void validar_ropaImportadaNegocioRopa() {
        NegocioRopa Levi = new NegocioRopa();
        Levi.agregarALista(prenda1);
        Levi.agregarALista(prenda2);
        Levi.agregarALista(prenda3);
        Levi.agregarALista(prenda4);
        Levi.agregarALista(prenda5);
        Levi.agregarALista(prenda6);
        Assertions.assertEquals(Levi.getListaRopaImportada().size(), 3);
    }

    @Test
    void validar_ropaDeterioradaNegocioRopa() {
        prenda5.setEstaDeteriorada(true);
        prenda6.setEstaDeteriorada(true);
        NegocioRopa Levi = new NegocioRopa();
        Levi.agregarALista(prenda1);
        Levi.agregarALista(prenda2);
        Levi.agregarALista(prenda3);
        Levi.agregarALista(prenda4);
        Levi.agregarALista(prenda5);
        Levi.agregarALista(prenda6);
        Assertions.assertEquals(Levi.getListaRopaEnMalasCondiciones().size(), 2);
    }


}