package Resolucion_Ejercicio_Clase2;

public abstract class PreparadorMenu {

    public String armarMenu (Menu menu){
        calcularPrecioMenu(menu);
        return mostrarMensaje(menu);
    }

    protected abstract Double calcularPrecioMenu (Menu menu);

    private String mostrarMensaje (Menu menu){
        String mensaje = "";
        if (menu instanceof MenuClasico menuClasico){
            mensaje = "Arma el menu clasico con los ingredientes de siempre. El precio del men es: " + calcularPrecioMenu(menu) + "$.";
        } else if (menu instanceof MenuInfantil){
            MenuInfantil menuInfantil = (MenuInfantil) menu;
            mensaje = "Arma el menu infantil con los ingredientes de siempre y agregale " + menuInfantil.getCantidadJuguetes() + " juguetes. El precio del menu es: " + calcularPrecioMenu(menu) + "$.";
        } else{
            MenuVegetariano menuVegetariano = (MenuVegetariano) menu;
            String tieneEspecias = menuVegetariano.getTieneEspecias().toString();
            if (tieneEspecias.equals("true")) {
                tieneEspecias = "Si";
            } else{
                tieneEspecias = "No";
            }
            mensaje = "Arma el menu vegetariano con los ingredientes de siempre. " + tieneEspecias + " tiene especias." + " Tiene " + menuVegetariano.getCantidadSalsas() + " salsas vegetarianas. " + "El precio del menu es " + calcularPrecioMenu(menu) + "$.";
        }
        return mensaje;
    }
}
