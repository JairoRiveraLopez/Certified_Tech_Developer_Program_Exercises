package Resolucion_Ejercitacion_Mesas_Clase4;

public class ArticuloFactory {

    private static ArticuloFactory instance;

    ArticuloFactory(){

    }

    public static ArticuloFactory getInstance() {
        if(instance == null){
            instance = new ArticuloFactory();
        }
        return instance;
    }

    public Articulo generarArticulo(String nombre, Integer lote, Integer peso, String envasado){
        return new Articulo(nombre, lote, peso, envasado);
    }
}
