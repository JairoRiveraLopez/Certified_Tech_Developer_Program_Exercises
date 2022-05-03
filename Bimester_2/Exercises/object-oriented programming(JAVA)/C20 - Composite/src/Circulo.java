public class Circulo implements Armable{
    private Double radio;

    public Circulo(Double radio) {
        this.radio = radio;
    }

    @Override
    public Double calcularSuperficie() {
        Double AreaCirculo = (radio * radio) * Math.PI;
        return AreaCirculo;
    }
    }

