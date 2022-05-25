package Resolucion_G2_MesasTemaFlyWeight;

import java.util.HashMap;

public class ArboloFactory {
    private static final HashMap<String, Arbol> arbolMap = new HashMap<>();

    public static Arbol plantarArbol (String tipoArbol){
        Arbol arbol = ArboloFactory.arbolMap.get(tipoArbol);
        if (arbol == null) {
            arbol = crearEstandarArbol(tipoArbol);
            ArboloFactory.arbolMap.put(tipoArbol, arbol);
        }
        return arbol;
        }

    private static Arbol crearEstandarArbol (String tipoArbol){
        return switch (tipoArbol) {
            case Arbol.TIPO_ORNAMENTAL -> new Arbol(200, 400, "Verde", Arbol.TIPO_ORNAMENTAL);
            case Arbol.TIPO_FRUTAL1 -> new Arbol(500, 300, "Rojo", Arbol.TIPO_FRUTAL1);
            case Arbol.TIPO_FRUTAL2 -> new Arbol(100, 200, "Celeste", Arbol.TIPO_FRUTAL2);
            default -> null;
        };
    }

}
