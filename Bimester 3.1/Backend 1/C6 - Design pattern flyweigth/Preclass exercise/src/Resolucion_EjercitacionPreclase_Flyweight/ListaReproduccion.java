package Resolucion_EjercitacionPreclase_Flyweight;

import java.util.ArrayList;
import java.util.List;

public class ListaReproduccion {
    private List<Cancion> listaReproduccion;

    public ListaReproduccion() {
        this.listaReproduccion = new ArrayList<>();
    }

    public void agregarCancion (Cancion cancion){
        listaReproduccion.add(cancion);
    }

    public void eliminarCancion (Cancion cancion){
        listaReproduccion.remove(cancion);
    }

    public void mostrarListaReproduccion(){
        Integer numeroOrden = 0;
        if(listaReproduccion.isEmpty()){
            System.out.println("No hay canciones en la lista de reproduccion.");
        } else{
            for (Cancion cancion: listaReproduccion) {
                numeroOrden++;
                System.out.println("Cancion#" + numeroOrden + " > " + cancion.descripcionCancion());
            }
        }
    }

    public List<Cancion> getListaReproduccion() {
        return listaReproduccion;
    }
}
