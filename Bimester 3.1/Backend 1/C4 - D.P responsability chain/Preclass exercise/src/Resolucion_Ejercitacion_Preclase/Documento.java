package Resolucion_Ejercitacion_Preclase;

public class Documento {
    private Integer tipo;
    private String contenido;

    public Documento(Integer tipo, String contenido) {
        this.tipo = tipo;
        this.contenido = contenido;
    }

    public Integer getTipo() {
        return tipo;
    }


}
