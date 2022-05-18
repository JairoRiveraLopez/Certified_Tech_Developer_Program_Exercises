package Resolucion_Ejercicio_Clase2;

public class Main {
    public static void main(String[] args) {
        MenuClasico menuClasico = new MenuClasico(10.0);
        MenuVegetariano menuVegetariano = new MenuVegetariano(12.0, true, 2);
        MenuInfantil menuInfantil = new MenuInfantil(8.0, 2);

        PreparadorMenuClasico preparadorMenuClasico = new PreparadorMenuClasico();
        System.out.println(preparadorMenuClasico.armarMenu(menuClasico));

        PreparadorMenuVegetariano preparadorMenuVegetariano = new PreparadorMenuVegetariano();
        System.out.println(preparadorMenuVegetariano.armarMenu(menuVegetariano));

        PreparadorMenuInfantil preparadorMenuInfantil = new PreparadorMenuInfantil();
        System.out.println(preparadorMenuInfantil.armarMenu(menuInfantil));
    }
}
