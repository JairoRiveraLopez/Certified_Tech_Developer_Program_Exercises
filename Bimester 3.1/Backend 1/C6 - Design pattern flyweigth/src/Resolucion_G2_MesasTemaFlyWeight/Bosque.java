package Resolucion_G2_MesasTemaFlyWeight;

import java.util.ArrayList;
import java.util.List;

public class Bosque {
    private List<Arbol> arboles;

    public Bosque() {
        this.arboles = new ArrayList<>();
    }

    public void agregarArbol (Arbol arbol){
        arboles.add(arbol);
    }

    public List<Arbol> getBosque() {
        return arboles;
    }
}
