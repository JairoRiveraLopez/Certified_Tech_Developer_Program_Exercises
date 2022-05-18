package Resolucion_Ejercicio_Clase2;

public class PreparadorMenuVegetariano extends PreparadorMenu{
    @Override
    protected Double calcularPrecioMenu(Menu menu) {

        if (menu instanceof MenuVegetariano){
            MenuVegetariano menuVegetariano = (MenuVegetariano) menu;

            Double precioDelMenu = menuVegetariano.getPrecioBase();
            if(menuVegetariano.getTieneEspecias()) {
                precioDelMenu *= 1.01;
            }
            precioDelMenu += (menuVegetariano.getCantidadSalsas() * 2.0);
            return precioDelMenu;
        }
        return null;
    }
}
