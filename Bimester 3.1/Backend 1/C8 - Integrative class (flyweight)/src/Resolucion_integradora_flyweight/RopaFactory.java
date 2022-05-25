package Resolucion_ejercitacionmesasclaseintegradora_flyweight;

import java.util.HashMap;

public class RopaFactory {
    private static final HashMap<String, Ropa> ropaMap = new HashMap<>();

    public static Ropa getRopa (String talla, String tipo, Boolean esNueva, Boolean esImportada){
        String descripcionPrenda = "Talla: " + talla + ". Tipo: " + tipo + ". esNueva : " + esNueva + ". esImportada : " + esImportada + ".";
        Ropa ropa = (Ropa) ropaMap.get(descripcionPrenda);
        if (ropa == null){
            ropa = new Ropa(talla, tipo, esNueva, esImportada);
            ropaMap.put(descripcionPrenda, ropa);
            System.out.println("Creando ropa > " + descripcionPrenda);
        }
        return ropa;
    }


}
