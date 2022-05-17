public class Cuadrado extends FiguraGeometrica{
    private Double lado;

    public Cuadrado(Double lado) throws FiguraGeometricaException{
        if (lado > 0){
            this.lado = lado;
        } else{
            throw new FiguraGeometricaException("Para calcular el area, el dato numerico debe ser mayor a 0.");
        }

    }

    @Override
    public Double calcularArea() {
        return lado * lado;
    }
}
