package Resolucion_ejerciciopreclase_patronfacade;

import java.util.List;

public class ServicioAutenticacion {

    public Boolean validarUsuarioYContrasenia (List<Cuenta> cuentas, Integer DNI, String contrasenia){
        return cuentas.stream().anyMatch(cuenta -> cuenta.getDNI().equals(DNI) && cuenta.getContrasenia().equals(contrasenia));
    }
}
