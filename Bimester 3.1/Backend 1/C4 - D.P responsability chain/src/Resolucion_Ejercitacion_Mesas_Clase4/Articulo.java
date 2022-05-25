package Resolucion_Ejercitacion_Mesas_Clase4;

public class Articulo {
    private String nombre;
    private Integer lote;
    private Integer peso;
    private String envasado;

    public Articulo(String nombre, Integer lote, Integer peso, String envasado) {
        this.nombre = nombre;
        this.lote = lote;
        this.peso = peso;
        this.envasado = envasado;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getLote() {
        return lote;
    }

    public Integer getPeso() {
        return peso;
    }

    public String getEnvasado() {
        return envasado;
    }
}
