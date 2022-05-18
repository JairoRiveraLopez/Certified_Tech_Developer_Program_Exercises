package Resolucion_Ejercicio_Clase2;

public class PreparadorMenuInfantil extends PreparadorMenu{
    @Override
    protected Double calcularPrecioMenu(Menu menu) {
        if (menu instanceof MenuInfantil){
            MenuInfantil menuInfantil = (MenuInfantil) menu;
            Double precioDelMenu = menuInfantil.getPrecioBase();
            precioDelMenu += (menuInfantil.getCantidadJuguetes() * 3.0);
            return precioDelMenu;
        }
        return null;
    }
}
