public class Circulo extends FiguraGeometrica{
    private Double radio;

    public Circulo(Double radio) throws FiguraGeometricaException{
        if (radio > 0){
            this.radio = radio;
        } else{
            throw new FiguraGeometricaException("Para calcular el area, el dato numerico debe ser mayor a 0.");
        }

    }


    @Override
    public Double calcularArea() {
        return Math.PI*(radio*radio);
    }
}
