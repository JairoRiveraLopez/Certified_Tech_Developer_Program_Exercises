package Resolucion_preclase;

import org.apache.log4j.Logger;
public class Leon {
    private static final Logger logger = Logger.getLogger(Leon.class);
    private String nombre;
    private Integer edad;
    private Boolean esAlfa;

    public Leon(String nombre, Integer edad, Boolean esAlfa) {
        this.nombre = nombre;
        this.edad = edad;
        this.esAlfa = esAlfa;
    }

    public void correr(){
        logger.info("El " + this.getClass().getName() + " " + this.nombre + " esta corriendo.");
    }

    public void esMayoraA10 () throws Exception{
        if(this.edad > 10 && this.esAlfa){
            logger.info("El Leon " + this.nombre + " tiene mas de 10 anios y es Alfa.");
        } else if (this.edad < 0){
            throw new Exception();
        } else{
            logger.info("El leon" + this.nombre + " no tiene mas de 10 anios y no es Alfa.");
        }
    }
}
