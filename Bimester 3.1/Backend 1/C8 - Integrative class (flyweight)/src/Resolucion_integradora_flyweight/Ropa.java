package Resolucion_ejercitacionmesasclaseintegradora_flyweight;

public class Ropa {
    private String talla;
    private String tipo;
    private Boolean esNueva;
    private Boolean esImportada;
    private Boolean estaDeteriorada;

    public Ropa(String talla, String tipo, Boolean esNueva, Boolean esImportada) {
        this.talla = talla;
        this.tipo = tipo;
        this.esNueva = esNueva;
        this.esImportada = esImportada;
        this.estaDeteriorada = false;
    }

    public String getTalla() {
        return talla;
    }

    public String getTipo() {
        return tipo;
    }

    public Boolean getEsNueva() {
        return esNueva;
    }

    public Boolean getEsImportada() {
        return esImportada;
    }

    public Boolean getEstaDeteriorada() {
        return estaDeteriorada;
    }

    public void setEstaDeteriorada(Boolean estáDeteriorada) {
        this.estaDeteriorada = estáDeteriorada;
    }
}
