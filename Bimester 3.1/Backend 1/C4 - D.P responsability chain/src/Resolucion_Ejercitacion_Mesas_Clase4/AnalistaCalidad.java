package Resolucion_Ejercitacion_Mesas_Clase4;

public class AnalistaCalidad {
    public Articulo enviarArticuloRevision (Articulo articulo){
        System.out.println("Envio a revision el articulo " + articulo.getNombre() + " de lote " + articulo.getLote() + ".");
        return articulo;
    }
}
