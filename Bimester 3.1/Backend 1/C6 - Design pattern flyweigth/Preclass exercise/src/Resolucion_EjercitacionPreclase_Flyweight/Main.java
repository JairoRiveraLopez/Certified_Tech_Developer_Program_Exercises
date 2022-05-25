package Resolucion_EjercitacionPreclase_Flyweight;

public class Main {
    public static void main(String[] args) {
        ListaReproduccion miLista = new ListaReproduccion();
        miLista.agregarCancion(CancionFactory.getCancion("Sol", "Juanes", "Pop"));
        miLista.mostrarListaReproduccion();
    }
}
