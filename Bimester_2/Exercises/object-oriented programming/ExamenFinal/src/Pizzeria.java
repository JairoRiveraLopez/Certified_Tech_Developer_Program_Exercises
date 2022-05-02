import java.util.ArrayList;
import java.util.List;

public class Pizzeria {
    private List<Pizza> menu;


    public Pizzeria() {
        menu = new ArrayList<>();
    }

    public void mostrarMenu(){
        for (Pizza pizza : menu) {
            System.out.println(pizza);
        }
    }

    public void agregarPizzaAlMenu(String codigo){
        try {
            menu.add(PizzaFactory.getInstance().generarPizza(codigo));
        } catch (PizzaException e) {
            System.out.println(e.getMessage());
        }
    }
}
