public class Triangulo implements Armable{
    private Double base;
    private Double altura;

    public Triangulo(Double base, Double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public Double calcularSuperficie() {
        Double AreaTriangulo = base * altura;
        return AreaTriangulo;
    };
    }

