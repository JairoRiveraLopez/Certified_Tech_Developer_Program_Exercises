package Resolucion_Ejercitacion_Mesas_Clase4;

public abstract class ComprobadorCalidad {
    public static final String statusRechazado = "Rechazado";
    public static final String statusAceptado= "Aceptado";

    protected ComprobadorCalidad sigCriterio;

    public abstract String verificarCalidad (Articulo articulo);

    public ComprobadorCalidad setSiguienteCriterio (ComprobadorCalidad compC){
        sigCriterio = compC;
        return sigCriterio;
    }

    public ComprobadorCalidad getSigCriterio() {
        return sigCriterio;
    }

    public static boolean entre2Numeros(int num, int menor, int mayor) {
        return menor <= num && num <= mayor;
    }
}
