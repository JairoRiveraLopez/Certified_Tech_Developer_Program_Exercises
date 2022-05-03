public abstract class OfertaAcademica {
    private String nombre;
    private String descripcion;

    public OfertaAcademica(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public abstract Double calcularPrecio();

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString(){
        return "El nombre del curso es: " + nombre + "\n" + "El precio del curso es: " + calcularPrecio();
    }
}
