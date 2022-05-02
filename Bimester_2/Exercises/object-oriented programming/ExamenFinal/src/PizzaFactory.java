public class PizzaFactory {

        public static final String MUZZARELLA_CHICA = "MUZZARELLA CHICA";
        public static final String ESPECIAL_CHICA = "ESPECIAL CHICA";
        public static final String ANANA_CHICA = "ANANA CHICA";
        public static final String PIZZA_COMBINADA_LOCA = "PIZZA COMBINADA LOCA";

        private static PizzaFactory instance;

        private PizzaFactory(){

        }

        public static PizzaFactory getInstance() {
            if(instance == null){
                instance = new PizzaFactory();
            }
            return instance;
        }

        public Pizza generarPizza(String codigo) throws PizzaException{
            switch (codigo){
                case MUZZARELLA_CHICA:
                    return new PizzaSimple("MUZZARELLA CHICA", "Una pizza de queso", 700.0, false);
                case ESPECIAL_CHICA:
                    return new PizzaSimple("ESPECIAL CHICA","Única",850.0,false);
                case ANANA_CHICA:
                    return new PizzaSimple("ANANA CHICA","Diferente",950.0,false);
                case PIZZA_COMBINADA_LOCA :
                    PizzaCombinada Pizza_Combinada_Loca = new PizzaCombinada("PIZZA LOCA", "La mejor combinación");
                    Pizza_Combinada_Loca.agregarPizza(generarPizza(ESPECIAL_CHICA));
                    Pizza_Combinada_Loca.agregarPizza(generarPizza(ANANA_CHICA));
                    return Pizza_Combinada_Loca;

            }
            throw new PizzaException(codigo + " no existe en nuestra oferta de pizzas.");
        }
    }

