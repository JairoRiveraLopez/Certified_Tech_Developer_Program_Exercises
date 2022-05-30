package Resolucion_preclase;

import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        Leon Simba = new Leon("Simba", -2, true);
        Tigre Askar = new Tigre("Askar", -2);
        Leon Orslok = new Leon("Orslok", 12, true);

        Simba.correr();
        Askar.correr();
        Orslok.correr();

        try {
            Simba.esMayoraA10();
        } catch (Exception e) {
            logger.error("La edad no puede ser negativa.", e);
        }

        try {
            Askar.esMayoraA10();
        } catch (Exception e) {
            logger.error("La edad no puede ser negativa.", e);
        }

        try {
            Orslok.esMayoraA10();
        } catch (Exception e) {
            logger.error("La edad no puede ser negativa.", e);
        }


    }
}
