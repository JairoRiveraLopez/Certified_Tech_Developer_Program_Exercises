public abstract class Pizza {

    private String nombre;
    private String descripcion;

    public Pizza(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public abstract Double calcularPrecio();

    public String getNombrePizza() {
        return nombre;
    }

    @Override
    public String toString(){
        return "El nombre de la pizza es: " + nombre + "\n" + "El precio de la pizza es: " + calcularPrecio();
    }
}
