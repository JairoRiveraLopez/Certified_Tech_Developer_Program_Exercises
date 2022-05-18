package Resolucion_Ejercicio_Clase2;

public class PreparadorMenuClasico extends PreparadorMenu{

    @Override
    protected Double calcularPrecioMenu(Menu menu) {
        if (menu instanceof MenuClasico){
            MenuClasico menuClasico = (MenuClasico) menu;
            return menuClasico.getPrecioBase();
        }
        return null;
    }
}
