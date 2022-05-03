public class PizzaSimple extends Pizza{

    private Double precioBase;
    private Boolean esGrande;

    public PizzaSimple(String nombre, String descripcion, Double precioBase, Boolean esGrande) {
        super(nombre, descripcion);
        this.precioBase = precioBase;
        this.esGrande = esGrande;
    }


    @Override
    public Double calcularPrecio() {
        Double precioTotal = 0.0;
        if(esGrande){
           precioTotal = precioBase * 2;
        } else{
            precioTotal = precioBase;
        }
        return precioTotal;
    }
}
