package Entities;

public class Medicamento {

    private Long id;
    private String codigoNumerico;
    private String nombre;
    private String laboratorioDeProduccion;
    private Integer cantidad;
    private Double precio;

    public Medicamento(Long id, String codigoNumerico, String nombre, String laboratorioDeProduccion, Integer cantidad, Double precio) {
        this.id = id;
        this.codigoNumerico = codigoNumerico;
        this.nombre = nombre;
        this.laboratorioDeProduccion = laboratorioDeProduccion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public String getCodigoNumerico() {
        return codigoNumerico;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLaboratorioDeProduccion() {
        return laboratorioDeProduccion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Double getPrecio() {
        return precio;
    }
}
