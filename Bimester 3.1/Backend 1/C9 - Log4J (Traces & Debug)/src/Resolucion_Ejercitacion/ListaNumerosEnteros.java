package Resolucion_Ejercitacion;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaNumerosEnteros {
    private static final Logger logger = Logger.getLogger(ListaNumerosEnteros.class);

    private List<Integer> listaNumeroEnteros;

    public ListaNumerosEnteros() {
        this.listaNumeroEnteros = new ArrayList<>();
    }

    public void agregarNumero(Integer n){
        listaNumeroEnteros.add(n);
    }

    public Integer promedioLista() throws Exception{

        if(entre2Numeros(listaNumeroEnteros.size(), 0, 4)){
            logger.info("La longitud de la lista es menor a 5.");
        } else if(entre2Numeros(listaNumeroEnteros.size(), 5, 10)){
            logger.info("La longitud de la lista es mayor a 5.");
        } else if (listaNumeroEnteros.size() > 10){
            logger.info("La longitud de la lista es mayor a 10.");
        }
        else{
            throw new Exception();
        }

        Integer numeroSuma = 0;
        for (Integer num:listaNumeroEnteros) {
            numeroSuma += num;
        }
        return numeroSuma / listaNumeroEnteros.size();
    }

    public Integer numMaximo (){
        Integer max = Collections.max(listaNumeroEnteros);
        return max;
    }

    public Integer numMinimo (){
        Integer max = Collections.min(listaNumeroEnteros);
        return max;
    }

    public static boolean entre2Numeros(int num, int menor, int mayor) {
        return menor <= num && num <= mayor;
    }
}
