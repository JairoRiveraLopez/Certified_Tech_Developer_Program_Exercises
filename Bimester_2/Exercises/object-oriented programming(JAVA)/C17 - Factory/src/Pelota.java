public class Pelota extends Producto{
    private Double radio;

    public Pelota(Double radio) {
        this.radio = radio;
    }

    @Override
    public Double calcularEspacio() {
        return ((4*Math.PI)*(Math.pow(radio,3)) / 3);
    }
}
