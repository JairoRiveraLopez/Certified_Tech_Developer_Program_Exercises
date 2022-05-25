package Resolucion_G2_MesasTemaFlyWeight;

public class Arbol {
    public static final String TIPO_ORNAMENTAL = "ornamental";
    public static final String TIPO_FRUTAL1 = "frutal1";
    public static final String TIPO_FRUTAL2 = "frutal2";

    private int alto;
    private int horizontal;
    private String color;
    private String tipoArbol;


    public Arbol(int alto, int horizontal, String color, String tipoArbol) {
        this.alto = alto;
        this.horizontal = horizontal;
        this.color = color;
        this.tipoArbol = tipoArbol;
    }

    public int getAlto() {
        return alto;
    }

    public int getHorizontal() {
        return horizontal;
    }

    public String getColor() {
        return color;
    }

    public String getTipoArbol() {
        return tipoArbol;
    }
}
