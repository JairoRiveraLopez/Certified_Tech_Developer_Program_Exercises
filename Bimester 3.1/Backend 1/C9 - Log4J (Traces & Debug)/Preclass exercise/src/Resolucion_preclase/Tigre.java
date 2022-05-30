package Resolucion_preclase;

import org.apache.log4j.Logger;
public class Tigre {
    private static final Logger logger = Logger.getLogger(Tigre.class);
    private String nombre;
    private Integer edad;

    public Tigre(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void correr(){
        logger.info("El " + this.getClass().getName() + " " + this.nombre + " esta corriendo.");
    }

    public void esMayoraA10 () throws Exception{
        if(this.edad > 10){
            logger.info("El Tigre " + this.nombre + " tiene mas de 10 años.");
        } else if (this.edad < 0){
            throw new Exception();
        } else{
            logger.info("El Tigre" + this.nombre + " no tiene mas de 10 años");
        }
    }

}
