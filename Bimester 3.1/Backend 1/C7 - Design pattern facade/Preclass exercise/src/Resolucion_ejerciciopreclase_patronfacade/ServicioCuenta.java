package Resolucion_ejerciciopreclase_patronfacade;

import java.util.ArrayList;
import java.util.List;

public class ServicioCuenta {

    public Cuenta getCuenta (List<Cuenta> cuentas, Integer DNI){
        Cuenta cuenta = null;
        for (Cuenta c : cuentas){
            if(c.getDNI().equals(DNI)){
                cuenta = c;
            }
        }
        return cuenta;
    }


}
