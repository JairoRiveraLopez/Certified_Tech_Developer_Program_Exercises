package Resolucion_EjercitacionPreclase_Flyweight;

import java.util.HashMap;

public class CancionFactory {
    private static final HashMap<String, Cancion> cancionMap = new HashMap<>();

    public static Cancion getCancion (String nombre, String autor, String genero){
        String descripcionCancion = "Nombre: " + nombre + ". Autor: " + autor + ". Genero : " + genero + ".";
        Cancion cancion = (Cancion) cancionMap.get(descripcionCancion);
        if (cancion == null){
            cancion = new Cancion(nombre, autor, genero);
            cancionMap.put(descripcionCancion, cancion);
            System.out.println("Creando cancion > " + descripcionCancion);
        }
        return cancion;
    }

}
