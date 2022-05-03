import java.util.ArrayList;
import java.util.List;

public class PizzaCombinada extends Pizza{

    private List<Pizza> pizzas;

    public PizzaCombinada(String nombre, String descripcion) {
        super(nombre, descripcion);
        pizzas = new ArrayList<>();
    }

    public void agregarPizza(Pizza pízza){
        pizzas.add(pízza);
    }


    @Override
    public Double calcularPrecio() {
        Double precioPromedio = 0.0;

        for (Pizza pizza:pizzas) {
            precioPromedio += pizza.calcularPrecio();
        }
        precioPromedio = precioPromedio / pizzas.size();

        return precioPromedio;
    }
}
