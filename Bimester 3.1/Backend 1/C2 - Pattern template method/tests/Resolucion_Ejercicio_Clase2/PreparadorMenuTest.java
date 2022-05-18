package Resolucion_Ejercicio_Clase2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreparadorMenuTest {
    MenuClasico menuClasico = new MenuClasico(10.0);
    MenuVegetariano menuVegetariano1 = new MenuVegetariano(12.0, true, 2);
    MenuVegetariano menuVegetariano2 = new MenuVegetariano(10.0, false, 2);
    MenuVegetariano menuVegetariano3 = new MenuVegetariano(10.0, true, 0);
    MenuVegetariano menuVegetariano4 = new MenuVegetariano(10.0, false, 0);

    MenuInfantil menuInfantil = new MenuInfantil(8.0, 2);
    MenuInfantil menuInfantil2 = new MenuInfantil(8.0, 0);

    PreparadorMenuClasico preparadorMenuClasico = new PreparadorMenuClasico();
    PreparadorMenuVegetariano preparadorMenuVegetariano = new PreparadorMenuVegetariano();
    PreparadorMenuInfantil preparadorMenuInfantil = new PreparadorMenuInfantil();

    @Test
    void armarMenuClasico() {
        assertEquals(preparadorMenuClasico.armarMenu(menuClasico), "Arma el menu clasico con los ingredientes de siempre. El precio del men es: 10.0$.");
    }

    @Test
    void armarMenuVegetariano_tieneEspecias() {
        assertEquals(preparadorMenuVegetariano.armarMenu(menuVegetariano1), "Arma el menu vegetariano con los ingredientes de siempre. Si tiene especias. Tiene 2 salsas vegetarianas. El precio del menu es 16.12$.");
    }

    @Test
    void armarMenuVegetariano_noTieneEspecias() {
        assertEquals(preparadorMenuVegetariano.armarMenu(menuVegetariano2), "Arma el menu vegetariano con los ingredientes de siempre. No tiene especias. Tiene 2 salsas vegetarianas. El precio del menu es 14.0$.");
    }

    @Test
    void armarMenuVegetariano_noTieneSalsas() {
        assertEquals(preparadorMenuVegetariano.armarMenu(menuVegetariano3), "Arma el menu vegetariano con los ingredientes de siempre. Si tiene especias. Tiene 0 salsas vegetarianas. El precio del menu es 10.1$.");
    }

    @Test
    void armarMenuVegetariano_noTieneSalsasNiEspecias() {
        assertEquals(preparadorMenuVegetariano.armarMenu(menuVegetariano4), "Arma el menu vegetariano con los ingredientes de siempre. No tiene especias. Tiene 0 salsas vegetarianas. El precio del menu es 10.0$.");
    }

    @Test
    void armarMenuInfantil() {
        assertEquals(preparadorMenuInfantil.armarMenu(menuInfantil), "Arma el menu infantil con los ingredientes de siempre y agregale 2 juguetes. El precio del menu es: 14.0$.");
    }

    @Test
    void armarMenuInfantil_sinJuguetes() {
        assertEquals(preparadorMenuInfantil.armarMenu(menuInfantil2), "Arma el menu infantil con los ingredientes de siempre y agregale 0 juguetes. El precio del menu es: 8.0$.");
    }




}