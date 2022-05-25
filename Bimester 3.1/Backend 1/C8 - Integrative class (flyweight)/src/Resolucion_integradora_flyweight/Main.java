package Resolucion_ejercitacionmesasclaseintegradora_flyweight;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Ropa prenda1 = RopaFactory.getRopa("S", "Camisa", true, true);
        Ropa prenda2 = RopaFactory.getRopa("S", "Pantalon", true, true);
        Ropa prenda3 = RopaFactory.getRopa("XS", "Camisa", true, false);
        Ropa prenda4 = RopaFactory.getRopa("XS", "Pantalon", true, false);
        Ropa prenda5 = RopaFactory.getRopa("M", "Camisa", true, true);
        Ropa prenda6 = RopaFactory.getRopa("M", "Camisa", true, false);

        prenda6.setEstaDeteriorada(true);
        NegocioRopa Levi = new NegocioRopa();

        Levi.agregarALista(prenda1);
        Levi.agregarALista(prenda2);
        Levi.agregarALista(prenda3);
        Levi.agregarALista(prenda4);
        Levi.agregarALista(prenda5);
        Levi.agregarALista(prenda6);

        Levi.mostrarContenidoLista(Levi.getListaTallaM());

    }
}
