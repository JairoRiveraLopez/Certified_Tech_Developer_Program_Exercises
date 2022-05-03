public class Curso extends OfertaAcademica{

    private Integer horasMensuales;
    private Integer duracionMeses;
    private Double precioHora;

    public Curso(String nombre, String apellido, Integer horasMensuales, Integer duracionMeses, Double precioHora) {
        super(nombre, apellido);
        this.horasMensuales = horasMensuales;
        this.duracionMeses = duracionMeses;
        this.precioHora = precioHora;
    }

    @Override
    public Double calcularPrecio() {
        return (horasMensuales * precioHora) * duracionMeses;
    }

}
