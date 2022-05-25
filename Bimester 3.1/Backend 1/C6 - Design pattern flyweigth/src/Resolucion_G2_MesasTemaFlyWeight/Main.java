package Resolucion_G2_MesasTemaFlyWeight;

public class Main {

    public static void main(String[] args) {
            Bosque bosque = new Bosque();
        for(int i = 0; i < 500000; i++){
            Arbol sembradosArboles = ArboloFactory.plantarArbol("ornamental");
            bosque.agregarArbol(sembradosArboles);
        }

        for(int i = 0; i < 500000; i++){
            Arbol sembradosArboles = ArboloFactory.plantarArbol("frutal1");
            bosque.agregarArbol(sembradosArboles);
        }

        System.out.println(bosque.getBosque().size());



    }
}
