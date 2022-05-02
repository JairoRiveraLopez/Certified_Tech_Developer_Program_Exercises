public class Caja extends Producto{
    private Double longitud;
    private Double ancho;
    private Double altura;

    @Override
    public Double calcularEspacio() {
        return longitud*ancho*altura;
    }

    public Caja(Double longitud, Double ancho, Double altura) {
        this.longitud = longitud;
        this.ancho = ancho;
        this.altura = altura;
    }
}
