public class Test {

    public static void main(String[] args) {
        Pizzeria PizzaLoca = new Pizzeria();

        PizzaLoca.agregarPizzaAlMenu(PizzaFactory.ANANA_CHICA);
        PizzaLoca.agregarPizzaAlMenu(PizzaFactory.ESPECIAL_CHICA);
        PizzaLoca.agregarPizzaAlMenu(PizzaFactory.MUZZARELLA_CHICA);

        PizzaLoca.agregarPizzaAlMenu(PizzaFactory.PIZZA_COMBINADA_LOCA);

        PizzaLoca.agregarPizzaAlMenu("Peperoni");

        PizzaLoca.mostrarMenu();
    }
}
