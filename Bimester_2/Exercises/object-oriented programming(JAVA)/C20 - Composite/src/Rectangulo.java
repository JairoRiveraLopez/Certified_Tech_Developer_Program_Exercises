public class Rectangulo implements Armable{
    private Double alto;
    private Double largo;

    public Rectangulo(Double alto, Double largo) {
        this.alto = alto;
        this.largo = largo;
    }

    @Override
    public Double calcularSuperficie() {
        Double AreaRectangulo = alto * largo;
        return AreaRectangulo;
    }
}
